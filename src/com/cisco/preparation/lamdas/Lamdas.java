package com.cisco.preparation.lamdas;

public class Lamdas {
	public static void main(String[] args) {
		Greeting lamda = s -> System.out.println("Hello World!!!" + s);
		SafeDevide safeDevideFn = (int a, int b) -> {
			if(b==0)
				return b;
			else
				return a/b;
		};
		
		System.out.println(safeDevideFn.divide(10, 5));
		lamda.greet("Santosh ");
		
		Thread t = new Thread(()->{
			System.out.println("thread test");	
		});
		t.start();
	}
}

interface SafeDevide{
	public int divide(int numerator, int denominator);
}
