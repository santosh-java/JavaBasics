package com.oracle.practice.lambdas.unit1;

public class TypeInferenceExample {
	public static void main(String args[]) {
		StringLengthLambda lenLamda = (str) -> str.length();
		
		StringLengthLambda lenLamda1 = str -> str.length();
		
		System.out.println("Length of Hello Lambda!!! is "+ lenLamda.getLength("Hello Lambda!!!"));
		System.out.println("Length of Hello Lambda New!!! is "+ lenLamda1.getLength("Hello Lambda New!!!"));
	}
}

interface StringLengthLambda{
	int getLength(String str);
}
