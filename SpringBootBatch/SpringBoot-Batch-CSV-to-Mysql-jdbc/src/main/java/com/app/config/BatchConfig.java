package com.app.config;

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
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
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
				System.out.println("job status "+jobExecution.getStatus().toString());
			}

			@Override
			public void afterJob(JobExecution jobExecution) {
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
	
	
	
	
	// reader 
	
	// code in steps
	
	/*
	public ItemReader<Product> reader(){
		FlatFileItemReader<Product> reader=new FlatFileItemReader<>();
		//reader.setResource(new FileSystemResource("d:/abc/products.csv"));
		
		//-- reading file/loading file
		reader.setResource(new ClassPathResource("products.csv"));
		// -- read data line by line
		reader.setLineMapper(new DefaultLineMapper<Product>() {{
			//-- make one into multiple parts
			setLineTokenizer(new DelimitedLineTokenizer() {{
				 //stores as variables with names
				setNames("id","code","cost");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {{
				//convert to model class object
				setTargetType(Product.class);
			}});
		}});        
		
		return reader;
	}
	
	*/
	
	// reader short code 
	
	/**
	 *   ItemReader ---> FlatFileItemReader<>()
	 *   
	 *   FlatFileItemReader<>() ----> setResource(Resource)   // for setting resource from where file has to load , can use FileSystemResoure or ClassPathResource 
	 * 							----> setLineMapper(LineMapper )   // to read as line by line
	 * 
	 * 								LineMapper --->  DefaultLineMapper<>() ;  // implementation
	 * 												---> setLineTokenizer(tokenizer)    // to tokenize line   
	 * 														
	 * 															Tokenizer --> DelimitedLineTokenizer() 
	 * 																			--> setNames()   // to set names to variable of model class
	 * 					
	 * 												---> setFieldSetMapper(FieldSetMapper);
	 * 
	 * 														FieldSetMapper --->BeanWrapperFieldSetMapper<Product>()
	 * 																
	 * 																		--> setTargetType(Model.class);
	 * 
	 * 
	 * */									
	
	// here we are using class extension & instance block for faster execution and loading , unloading of objects
	
	@Bean
	public ItemReader<Product> reader()
	{
			return new FlatFileItemReader<Product>() {{    ///  impl class
				
				setResource(new ClassPathResource("products.csv"));			// loading resource
				
				setLineMapper(new DefaultLineMapper<Product>() {{			// anonymous class to read line by line
					
					setLineTokenizer(new DelimitedLineTokenizer() {{		// anonymous class to tokenize line & setting to variable 
						setNames("id","code","cost");
					}} );
					
					setFieldSetMapper(new BeanWrapperFieldSetMapper<Product>() {{		// anonymous class to map to model class obj
						setTargetType(Product.class);
					}});
				}});
				
			}};
		}
	
	
	// ItemProcessor , using lambda  to avoid class
	
	@Bean
	public ItemProcessor<Product,Product> process()
	{
		// return new OwnClass() ;
		return (p)->{ 
						p.setDiscount(p.getCost() *3/100.0);
						p.setGst(p.getCost() *12/100.0);
						return p;
					};
	}
	
	
	// ItemWriter 
	// it will make db connection , create sql ,then based in chunk size prepare batch and insert in db
	
	@Bean
	public ItemWriter<Product> writer()
	{
		return new JdbcBatchItemWriter<Product>() {{
			setDataSource(dataSource());					// define datasource
			setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Product>());   // providing source
			setSql("INSERT INTO PRODSTAB (PID,PCODE,PCOST,PDISC,PGST) VALUES (:id,:code,:cost,:discount,:gst)"); // making sql 
		}};
	}
	
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

	
	
}
