package com.app.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer_rest")
public class Customer {

	@Id
	@GeneratedValue(generator = "cust")
	@GenericGenerator(name="cust",strategy = "increment")
	private Integer cid;

	private String cname;

	private String cserviceId;

	@ElementCollection(fetch=FetchType.EAGER)
	private List<String> cmode;


}
