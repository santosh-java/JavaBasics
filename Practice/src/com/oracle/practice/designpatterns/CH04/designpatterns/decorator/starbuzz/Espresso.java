package com.oracle.practice.designpatterns.CH04.designpatterns.decorator.starbuzz;

public class Espresso extends Beverage {
  
	public Espresso() {
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}
}

