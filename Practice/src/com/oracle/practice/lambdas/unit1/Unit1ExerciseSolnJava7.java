package com.oracle.practice.lambdas.unit1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseSolnJava7 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		// step 1: sort list by first name
		System.out.println("Before sort");
		printAllPersons(people);

		Collections.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getfName().compareTo(o2.getfName());
			}
		});

		// step 2: Create a method that prints all elements in the list
		System.out.println("After sort");
		printAllPersons(people);
		
		// step 3: Create a method that prints all people that have last name begginning
		// with C
		printConditionally(people, new Condition() {

			@Override
			public boolean test(Person p) {
				return p.getlName().startsWith("C");
			}

		});
	}

	private static void printConditionally(List<Person> people, Condition condition) {
		for (Person p : people) {
			if (p.getlName().startsWith("C")) {
				System.out.println(p);
			}
		}
	}

	private static void printAllPersons(List<Person> people) {
		for (Person p : people) {
			System.out.println(p);
		}
	}

}

interface Condition {
	public boolean test(Person p);
}

class NameComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getfName().compareTo(o2.getfName());
	}

}
