package com.oracle.practice.lambdas.unit3;

import java.util.Arrays;
import java.util.List;

import com.oracle.practice.lambdas.unit1.Person;

public class StreamsExample1 {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39));

		people.stream()
			.filter(p -> p.getfName().startsWith("C") || p.getlName().startsWith("C"))
			.forEach(p -> p.setAge(p.getAge()+10));
		
		people.stream().forEach(System.out::println);
	}

}
