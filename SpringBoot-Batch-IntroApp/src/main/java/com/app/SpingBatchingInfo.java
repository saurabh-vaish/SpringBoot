package com.app;

public class SpingBatchingInfo {

	/***
	 * 
	 * 	Batch :-  To multiple task as one or one big task in multiple steps .
	 * 		
	 * 			It needed three things ---- >  Steps Creation , Job Creation , Job Execution .
	 * 	
	 * 		1 task = 1 Job ,  1 subtask  =  1 step
	 * 
	 * 	Step --> A job can be done in one or multiple steps . A step having ---> 1.  ItemReader   2. ItemProcessor  3. ItemWriter
	 * 
	 * ItemReader(I)  :-It is used to read data from source like file object etc .
	 * 					It is used in step creation . 
	 * 					It takes generic T that can be string object or collection and must be same as Process input generic type
	 * 
	 * 	ItemProcessor(I) :- It is used to process data from reader .
	 * 						It is used in step creation . 
	 * 						It takes generic I that can be string object or collection and must be same as reader generic type and O must be same as Write generic type
	 * 
	 * ItemWriter(I)  :- It  is used to write data to destination in the form of chunks  .
	 * 				   	 It is used in step creation . 
	 * 					 It takes generic T that can be string object or collection and must be same as Process output generic type
	 * 
	 * 
	 * 	Step  :- A step is created using StepBuilderFactory (I)
	 * 
	 * 	Job :- A job is created using JobBuilderFactory (I) and Step(I)  . 
	 * 
	 * 	JobListener :- Job Execution Listeners are used to execute some logic before and after creating a job
	 * 
	 * 	JobLauncher :- Its a interface , used to execute  jobs using run() method .
	 *   	
	 *   run()  -->  It takes to parameters Job(I) & JobParameters(c).
	 *   
	 *   JobParameters ---> They are the inputs to Job while starting the job . Example parameter like Date & time , names , flags etc.
	 *  
	 * 						JobParameters are used to created using JobParametersBuilder(c) and toJobParameters() method. 
	 * 
	 * 
	 *  JobRepository :-  All the details related job , step ,chunk etc are stored in a job repository created by Spring Boot .
	 *  				  We need to give only a db like h2 or mysql . 
	 * 
	 * 	Execution  :--    Job Launcher --> Jobs ---> Steps ---> ItemReader reads --> ItemProcessor --->Stored in chunks  --> ItemWriter
	 * 
	 * 	
	 * 
	 * **/
	
	
	
}
