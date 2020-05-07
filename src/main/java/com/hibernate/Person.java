package com.hibernate;

public class Person {
	
	private int prsnId;
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public int getPrsnId() {
		return prsnId;
	}


	public void setPrsnId(int prsnId) {
		this.prsnId = prsnId;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
