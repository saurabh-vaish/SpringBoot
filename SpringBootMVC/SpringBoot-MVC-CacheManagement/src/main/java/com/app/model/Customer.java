package com.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
@Table(name="customer_caching")
public class Customer implements Serializable   // the class the need cahcing
{
	
	@Id
	@GeneratedValue(generator ="cust" )
	@GenericGenerator(name ="cust",strategy ="increment")
	private Integer custId;
	
	private String custCode;
	private String custName;
	private String custType;
	private String note;
	

	
	
}
