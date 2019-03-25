package com.oracle.practice.lambdas.unit1;

public class Greeter {

	public static void main(String[] args) {
		Greeter g = new Greeter();
		
		Greeting myLamdaGreeter = () -> System.out.println("Hello World! Lambda");
		
		Greeting myInnerGreeter = new Greeting() {
			public void greet() {
				System.out.println("Hello World! Innerclass");
			}
		};
		
		g.greet(myInnerGreeter);
		g.greet(myLamdaGreeter);
	}

	private void greet(Greeting hwg) {
		hwg.greet();
	}

}
