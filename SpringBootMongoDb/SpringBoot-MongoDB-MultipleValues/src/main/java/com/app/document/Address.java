package com.app.document;


public class Address {

	private String hno;
	private String loc;
	
	public Address() {
		super();
	}
	
	public Address(String hno, String loc) {
		super();
		this.hno = hno;
		this.loc = loc;
	}

	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Address [hno=" + hno + ", loc=" + loc + "]";
	}
	
	
	
}
