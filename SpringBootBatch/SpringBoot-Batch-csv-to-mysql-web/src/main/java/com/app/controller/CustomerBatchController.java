package com.app.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.repo.CustomerRepository;

@Controller
@RequestMapping("/batch")
public class CustomerBatchController {

	
	@Autowired
	public CustomerRepository repo;
	
	
	// to launch job
	@Autowired 
	public JobLauncher launcher;
	
	
	@Autowired 
	public Job job;

	
	// job parameters
	public JobParameters params() 
	{
		return new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters(); }


	@RequestMapping("/")
	public String showPage(Model map)
	{
		return "show";
	}
	
	
	
	@RequestMapping("/launch")
	public String jobLauncher(Model map)
	{
		// job launcher to execute the job

		try {
			launcher.run(job, params());   // needs two paramerters job , jobParameter 
			
			map.addAttribute("customer",repo.findAll());
			
			map.addAttribute("msg","data has been exported successfully");
			return "show";
			
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		
			map.addAttribute("msg","Exception occur");
			return "show";
		}
	}
	
	
	@RequestMapping("/data")
	public String showData(Model map)
	{
			map.addAttribute("customer",repo.findAll());
			
			return "show";
		
	}
	
	
}
