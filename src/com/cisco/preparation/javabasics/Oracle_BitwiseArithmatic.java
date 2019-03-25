package com.cisco.preparation.javabasics;

public class Oracle_BitwiseArithmatic {
	public static void main(String[] args) {
		System.out.println(multiply(5, -5));
	}

	public static int multiply(int x, int y) {
		if(y == 0)
			return 0;
		
		if(y > 0){
			int val = (x + multiply(x, y-1));
			return val;
		}
		if(y < 0){
			int val = -multiply(x, -y);
			return val;
		}
		
		return Integer.MIN_VALUE;
	}
}
