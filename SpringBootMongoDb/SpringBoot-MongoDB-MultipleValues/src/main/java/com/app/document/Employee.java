package com.app.document;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 *   @Document ---- for mongo db . It is optional but it is good practice to use it
 *	 @Id  ----  it is also optional in case of mongo db but the varibale name should be id only , if we are using any other name 
 *				then it is recammonded to use it 
 *
 * 		for Primary Key we use always taks String as Mango use UUID for Id which is in hexadecimal form
 * 		So if we will use any other database then it will give InvalidDataAccessApiUsagesException
 * 
 * 	List/Set/Array - format ----   {"key":["val1","val2"...]
 * 
 * 	Map/Properties - format ---- { "key" : { "key1":"val1","key2":"val2",.....} }
 * 
 * 	Has-A  		   - format ----  { "hasAvariable" : { "key","val"....}  }
 * 
 */


@Document
public class Employee {

	@Id
	private String id;
	
	// primitives
	private Integer empId;
	private String empName;
	private Double empSal;

	
	// List/Set/Array  --- Json is same
	private String[] prjCodes;
	private List<String> empPrjs;
	
	
	// Map/ Properties
	private Map<String,String> empDepts;
	
	
	// Has-A 
	private Address addr;


	public Employee() {
		super();
	}


	public Employee(Integer empId, String empName, Double empSal, String[] prjCodes, List<String> empPrjs,
			Map<String, String> empDepts, Address addr) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.prjCodes = prjCodes;
		this.empPrjs = empPrjs;
		this.empDepts = empDepts;
		this.addr = addr;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Integer getEmpId() {
		return empId;
	}


	public void setEmpId(Integer empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public Double getEmpSal() {
		return empSal;
	}


	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}


	public String[] getPrjCodes() {
		return prjCodes;
	}


	public void setPrjCodes(String[] prjCodes) {
		this.prjCodes = prjCodes;
	}


	public List<String> getEmpPrjs() {
		return empPrjs;
	}


	public void setEmpPrjs(List<String> empPrjs) {
		this.empPrjs = empPrjs;
	}


	public Map<String, String> getEmpDepts() {
		return empDepts;
	}


	public void setEmpDepts(Map<String, String> empDepts) {
		this.empDepts = empDepts;
	}


	public Address getAddr() {
		return addr;
	}


	public void setAddr(Address addr) {
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + ", prjCodes="
				+ Arrays.toString(prjCodes) + ", empPrjs=" + empPrjs + ", empDepts=" + empDepts + ", addr=" + addr
				+ "]";
	}
	
	
	
	
}
