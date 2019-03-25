package com.cisco.preparation.lamdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Unit1Exercise {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickenson", 40), new Person("Lewis", "Pasture", 20),
				new Person("Charles", "Babbage", 30), new Person("Larry", "Ellison", 70),
				new Person("Sundar", "Pichai", 10), new Person("Satya", "Nadella", 50));
		// Step 1: sort the persons list basing on lastname
		System.out.println("Before sort: " + people);
//		Collections.sort(people, (first, second) -> first.getLastName().compareTo(second.getLastName()));
		Collections.sort(people, Person::compareByAge);
		System.out.println("After sort: " + people);

		// Step 2: Create a method that prints all elements in the list
		printPersonsConditionally(people, p -> true);

		// Step 3: Create a method that prints all people that have last name
		// starting with C
		System.out.println("All people with lastname beginning with C");
		printPersonsConditionally(people, p -> p.getLastName().startsWith("C"));

		System.out.println("All people with lastname beginning with E");
		printPersonsConditionally(people, p -> p.getLastName().startsWith("E"));
		System.out.println("All people with firstname beginning with C");
		printPersonsConditionally(people, p -> p.getFirstName().startsWith("C"));
		System.out.println("All people with firstname beginning with C");
		printPersonsConditionallyWithPredicate(people, p -> p.getFirstName().startsWith("C"));
	}

	private static void printPersonsConditionally(List<Person> people, Condition<Person> condition) {
		for (Person p : people) {
			if (condition.check(p))
				System.out.println(p);
		}
	}
	
	private static void printPersonsConditionallyWithPredicate(List<Person> people, Predicate<Person> condition) {
		for (Person p : people) {
			if (condition.test(p))
				System.out.println(p);
		}
	}
}
