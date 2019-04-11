package com.oracle.testng.tests;

public class StaticTest {
	public static final int var;
	static {
		var = 10;
		System.out.println("Inside static block");
	}
	{
		System.out.println("Inside non static block");
	}
	public StaticTest() {
		System.out.println("Inside constructor");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inside main");
	}

}
