package com.app.model;

import javax.persistence.Entity;
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
@Table(name="item_rest")
public class Item {
	
	@Id
	@GeneratedValue(generator ="item")
	@GenericGenerator(name = "item",strategy = "increment")
	private Integer itemId;

	private String itemCode;

	private Double itemCost;


}
