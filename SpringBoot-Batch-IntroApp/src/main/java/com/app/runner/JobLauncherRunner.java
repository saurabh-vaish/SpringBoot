package com.app.runner;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



/***
 * 
 *   JobLunchers ---> Its a interface , used to execute  jobs using run() method .
 *   	
 *   run()  -->  It takes to parameters Job(I) & JobParameters(c).
 *   
 *   JobParameters ---> They are the inputs to Job while starting the job . Example parameter like Date & time , names , flags etc.
 *  
 * 						JobParameters are used to created using JobParametersBuilder(c) and toJobParameters() method. 
 * 
 * 
 * **/



@Component
public class JobLauncherRunner implements CommandLineRunner {

	@Autowired						
	private JobLauncher launcher;		// used to launch jobs
	
	
	@Autowired
	private Job job;			
	
	
	@Override
	public void run(String... args) throws Exception {
		
		JobParameters jobParameters = new JobParametersBuilder()
										.addLong("time",System.currentTimeMillis())    // adding time to job
										.toJobParameters();
		
		launcher.run(job, jobParameters);
		
	}

}
