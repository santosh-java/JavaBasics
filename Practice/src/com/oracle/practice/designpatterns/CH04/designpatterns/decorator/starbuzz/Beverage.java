package com.oracle.practice.designpatterns.CH04.designpatterns.decorator.starbuzz;

public abstract class Beverage {
	String description = "Unknown Beverage";
  
	public String getDescription() {
		return description;
	}
 
	public abstract double cost();
}
