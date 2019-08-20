package com.app.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MyMessage implements Serializable{



	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String name;
	private List<String> roles = new ArrayList<>();;
	private Map<String,Double> depSal;
	
	
	public MyMessage() {
		super();
	}

	public MyMessage(Integer id, String name, List<String> roles, Map<String, Double> depSal) {
		super();
		this.id = id;
		this.name = name;
		this.roles = roles;
		this.depSal = depSal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public Map<String, Double> getDepSal() {
		return depSal;
	}

	public void setDepSal(Map<String, Double> depSal) {
		this.depSal = depSal;
	}

	@Override
	public String toString() {
		return "MyMessage [id=" + id + ", name=" + name + ", roles=" + roles + ", depSal=" + depSal + "]";
	}
	
	
	
}
