package com.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor     
@RequiredArgsConstructor   // except id
@NoArgsConstructor
@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer prodId;
	@NonNull
	private String prodName;
	@NonNull
	private Double prodSal;
}
