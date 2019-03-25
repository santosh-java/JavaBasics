package com.oracle.practice.lambdas.unit2;

public class ThisReferenceExample {

	public void doProcessAnonymous(Process p, int i) {
		p.process(i);
	}
	
	public void doProcessLambda(Process p, int i) {
		p.process(i);
	}

	public static void main(String[] args) {
		ThisReferenceExample tre = new ThisReferenceExample();
		tre.doProcessAnonymous(new Process() {

			@Override
			public void process(int i) {
				System.out.println("Value of i is: " + i);
				System.out.println(this);
			}
			
			public String toString() {
				return "Name of the class is " + this.getClass();
			}
			
		}, 10);
		
		tre.doProcessLambda(i -> {
			System.out.println("Value of i is: " + i);
//			System.out.println(this); // this will not work here
		}, 10);
		
	}

}
