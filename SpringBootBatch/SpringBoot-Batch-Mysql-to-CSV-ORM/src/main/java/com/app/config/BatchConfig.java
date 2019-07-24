package com.app.config;

import java.util.Date;
import java.util.HashMap;

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
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;

import com.app.model.Product;
import com.app.repo.ProductRepository;

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
	//  				1.setting repository   2. fetching data    3. convert to object
	
	// datasource code in properties file
	
	@Autowired
	private ProductRepository repo;

	
	@SuppressWarnings("serial")
	@Bean
	public ItemReader<Product> reader()
	{
		return 	new RepositoryItemReader<Product>() {{
			
			setRepository(repo);
			
			setMethodName("findAll");
			
			// a sorting required 
			setSort(new HashMap<String,Sort.Direction>() {{    //after sorting setting value to map
					put("id",Sort.Direction.ASC);
				}}
			);
		}};
	}
	
	
	// ItemProcessor , using lambda  to avoid class
	
	@Bean
	public ItemProcessor<Product,Product> process()
	{
		// return new OwnClass() ;
		return (p)->{ 
						System.out.println(p);
						return p;
					};
	}
	
	
	// ItemWriter 
	// it will make db connection , create sql ,then based in chunk size prepare batch and insert in db
	
	
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
