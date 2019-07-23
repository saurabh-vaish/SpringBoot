package com.app.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;


/**
 *  Job Execution Listeners are used to execute some logic before and after creating a job
 * 
 * **/


public class MyJobListener implements JobExecutionListener{

	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println("Job started "+jobExecution.getStatus().toString());
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println("Job ends "+jobExecution.getStatus().toString());
		
	}

}
