package com.app.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter   // for ganerating setters
@Getter   // for ganerating getters
@ToString // for toString()
@EqualsAndHashCode   // for equal and hashCode()
@NoArgsConstructor   // for default constructor
@AllArgsConstructor  // for parametrised constructor

// or @Data    // for all above

public class Project {

	private Integer pId;
	private String pName;
	private Double pCost;
	
	
}
