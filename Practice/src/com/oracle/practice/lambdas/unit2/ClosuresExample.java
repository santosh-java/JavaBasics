package com.oracle.practice.lambdas.unit2;

public class ClosuresExample {

	public static void main(String[] args) {
		int a = 19;
		int b = 10;

		doProcess(i -> System.out.println(i + b), a);
	}

	public static void doProcess(Process p, int i) {
		p.process(i);
	}
}

interface Process {
	void process(int i);
}