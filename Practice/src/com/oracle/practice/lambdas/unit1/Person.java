package com.oracle.practice.lambdas.unit1;

public class Person {
	@Override
	public String toString() {
		return "Name: " + this.fName + " " + this.lName + " Age: " + this.age;
	}

	private String fName;;
	private String lName;
	private int age;

	public Person(String fName, String lName, int age) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.age = age;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
