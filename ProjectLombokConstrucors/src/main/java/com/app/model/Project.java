package com.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data

@NoArgsConstructor()   // for default constructor , it will initialize default values to fields (non final) . 

//@AllArgsConstructor   // it will generate parameterized   constructor

@RequiredArgsConstructor    // it is used to generate constructor for arguments that we need with the help of @NonNull
							// if we are not using @NonNull then it will generate default constructor
							// if we are using @NonNull for all fileds then it will works as @AllArgsConstructor
							
public class Project {

	@NonNull
	private Integer pId;
	
	@NonNull private String pName;
	
	private  Double pCost;

	// private final Double pCost;   // if we are using final variable then we should use @NoArgsConstructor(force = true)
	
	
	
}
