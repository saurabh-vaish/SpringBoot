package com.app.config;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.listener.MyJobListener;
import com.app.processor.Processor;
import com.app.reader.Reader;
import com.app.writer.Writer;

/**
 * 
 *  It is used to config batching in spring boot . its an imp file . It configure --> Steps , Jobs 
 * 
 * 
 * **/


// here configuration is done using top to bottom approach


@Configuration
public class BatchConfig {

	
	// 3. Creating Jobs using JobBuilderFactory . It takes Step(I) and JobBuilderFactory to create a job
	
	@Autowired
	private JobBuilderFactory jf; 				// has a 
	
	@Bean
	public Job j1()
	{
		return jf.get("j1")		// name must be same as object name
				
				.incrementer(new RunIdIncrementer())
				
				.listener(listener())				// listeners are used to perform some task before and after executing a job
				
				.start(step1())      // usues step object to execute step  
				
				//.next(step2()) .next(step3())			// if more steps then add this
				
				.build();					// create job
	}
	
	// listener are optional for jobs
	
	@Bean
	public MyJobListener listener()
	{
		return new MyJobListener();
	}
	
	//2. Creating step using step builder factory , it uses StepBuilderFactory for creating steps
	
	@Autowired
	private StepBuilderFactory sf;    // making has a relation with SBF
	
	
	// we can create Steps as many as we want but every Step contain same process
	
	@Bean
	public Step step1()					// creating Step  
	{
		return sf.get("step1")   /// step name must be same as object name
				
				.<String,String>chunk(3)       // defining chunk size 
				
				.reader(read())   			// adding any  ItemReader impl class object
				
				.processor(process())		// adding any  ItemProcessor impl class object
				
				.writer(write())			// adding any  ItemWriter impl class object
				
				.build()					// building Step
				;
	}
	
	
	// 1.  configure reader , writer , processor
	
	@Bean
	public Reader read()
	{
		return new Reader();
	}
	
	
	@Bean
	public Writer write()
	{
		return new Writer();
	}
	
	
	@Bean
	public Processor process()
	{
		return new Processor() ;
	}
	
}
