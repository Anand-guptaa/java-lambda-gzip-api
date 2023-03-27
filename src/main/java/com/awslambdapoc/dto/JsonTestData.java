package com.awslambdapoc.dto;

import java.io.Serializable;

public class JsonTestData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5041694733823047914L;
	private String name;
	private String mname;
	private String lname;
	private String age;
	
	
	public JsonTestData(String name, String mname, String lname, String age) {
		super();
		this.name = name;
		this.mname = mname;
		this.lname = lname;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
