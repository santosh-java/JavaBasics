package com.oracle.practice.lambdas.unit3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1,2,3,4,5);
		System.out.println("Without method reference");
		printConditionally(l,p->true,p->System.out.println(p));
		System.out.println("With method reference");
		printConditionally(l, p->true, System.out::println);
	}
	
	private static void printConditionally(List<Integer> l, Predicate<Integer> predicate, Consumer<Integer> consumer) {
		for(Integer i: l) {
			if(predicate.test(i)) {
				consumer.accept(i);
			}
		}
	}

}
