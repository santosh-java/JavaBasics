package com.oracle.practice.lambdas.unit1;

public class RunnableLambda {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println("Printed in the Runnable method");
			}
		});
		
		t.start();
		
		Thread t2 = new Thread(()->System.out.println("Printed inside lambda"));
		t2.start();
		
		Thread t3 = new Thread(System.out::println);
		t3.start();
	}

}
