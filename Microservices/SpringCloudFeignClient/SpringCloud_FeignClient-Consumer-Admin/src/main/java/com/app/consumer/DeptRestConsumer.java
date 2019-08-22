package com.app.consumer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Dept;

@FeignClient("DEPT-PROVIDER")
public interface DeptRestConsumer {

	
	// same method as in DeptRestProvider
	
	@GetMapping("/dept/show")
	public String show();
	
	
	@GetMapping("/dept/get")
	public Dept getDept();
	
	
	@GetMapping("/dept/all")
	public List<Dept> getAll();
	
	
	@PostMapping("/dept/save")
	public String save(@RequestParam String msg);
	
}
