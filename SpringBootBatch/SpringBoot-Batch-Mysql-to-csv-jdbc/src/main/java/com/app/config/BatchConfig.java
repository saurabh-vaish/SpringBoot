package com.app.config;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.app.model.Product;

/**
 * 
 *  In Real time we can config reader , writer , processor all in the configuration file .
 *  Here we will use  implementation classes for ItemReader , ItemWriter .
 *  Since ItemProcessor required ,program defined class , so instead of creating own class we will lambda expression .
 * 
 * 	Here we are also using core java concept for code extension block and intension block .
 * 
 * 
 * */



@Configuration
@EnableBatchProcessing
public class BatchConfig {

	
	 // job launcher to execute the job
	
	  @Autowired 
	  public JobLauncher launcher;
	  
	  // job parameters
	  public JobParameters params() 
	  {
		  return new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters(); }
	  
	  
	  // configuring runner in configuration file
	  
	  @Bean
	  public CommandLineRunner runner() 
	  { 
		  return (args)->{ 
			  launcher.run(j1(),params() ); 
			  }; 
	  }
	  
	
	// jobBuilderFactory
	@Autowired
	private JobBuilderFactory jf;
	 
	@Bean
	public Job j1()
	{
		return jf.get("j1").incrementer(new RunIdIncrementer()).listener(listener()).start(s1()).build();
	}
	
	
	// configuring listener for job
	@Bean
	public JobExecutionListener listener()
	{
		return new JobExecutionListener() {
		
			@Override
			public void beforeJob(JobExecution jobExecution) {
				System.out.println("job start time "+new Date());
				System.out.println("job status "+jobExecution.getStatus().toString());
			}

			@Override
			public void afterJob(JobExecution jobExecution) {
				System.out.println("job end time "+new Date());
				System.out.println("job status "+jobExecution.getStatus().toString());		
			}
			
		};
	}
	
	// stepBuilderFactory
	@Autowired
	private StepBuilderFactory sf;
	
	// step
	@Bean
	public Step s1()
	{
		return sf.get("s1").<Product,Product>chunk(3).reader(reader()).processor(process()).writer(writer()).build();
	}
	
	
	// ItemReader  --> reading from db and converting into Model class object
	//  				1. getting connection  2. fetching data    3. convert to object
	@Bean
	public ItemReader<Product> reader()
	{
		return new JdbcCursorItemReader<Product>() {{
			//setting datasource
			setDataSource(dataSource());
			// setting sql to fetch data
			setSql("select pid,pcode,pcost from prodstab");
			// setting rowMapper to convert into Product object to write in csv
			setRowMapper(new RowMapper<Product>() {  							 // anonymous class for rowmapper
				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product p =new Product();
					p.setId(rs.getInt("pid"));
					p.setCode(rs.getString("pcode"));
					p.setCost(rs.getDouble("pcost")); 
					return p;
				}
			});
		}};
	}
	
	// datasource
	@Bean
	public DataSource dataSource()
	{
		return new DriverManagerDataSource() {{
			setDriverClassName("com.mysql.jdbc.Driver");
			setUrl("jdbc:mysql://localhost:3306/springboot");
			setUsername("root");
			setPassword("root");
		}};
	}
	
	
	// ItemProcessor ---> Using lambda
	@Bean
	public ItemProcessor<Product,Product> process()
	{
		return (p)->{return p;} ; //no calculation required
	}
	
	
	
	// ItemWriter --->FlatFileItemWriter   ---> 1. setting resource   2. setting delimiter for line to write   3. set variable names 
	// o/p file will be in target / classes folder in file system 
	
	@Bean
	public ItemWriter<Product> writer()
	{
		return new FlatFileItemWriter<Product>() {{
			// setting resource to store file , here in project only
			setResource(new ClassPathResource("products.csv"));					// make sure file exist in resource folder
			// setting delimiter for line to write 
			setLineAggregator(new DelimitedLineAggregator<Product>() {{
				// default is ","
				setDelimiter(",");
				// setting variable names to write  
				setFieldExtractor(new BeanWrapperFieldExtractor<Product>() {{
					setNames(new String[] {"id","code","cost"});
				}});
			}});
		}};
	}
	
}
