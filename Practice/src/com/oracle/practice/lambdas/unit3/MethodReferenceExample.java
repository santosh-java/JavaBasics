package com.oracle.practice.lambdas.unit3;

public class MethodReferenceExample {

	public static void main(String[] args) {
		Thread t = new Thread(MethodReferenceExample::printMessage); 
		// MethodReferenceExample::printMessage === () -> printMessage();
		t.start();
	}
	
	public static void printMessage() {
		System.out.println("Hello");
	}

}
