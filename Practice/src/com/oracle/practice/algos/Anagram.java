package com.oracle.practice.algos;

import java.util.ArrayList;
import java.util.List;

public class Anagram {

	public static void main(String[] args) {
		Anagram a = new Anagram();
		List<String> findAnagrams = a.findAnagrams("ABCDE");
		findAnagrams.stream().forEach(System.out::println);
	}

	public List<String> findAnagrams(String word) {
		List<String> result = new ArrayList<String>();
		if (word.length() == 1) {
			result.add(word);
			return result;
		}
		
		char c = word.charAt(0);
		String subset = word.substring(1);
		
		result = findAnagrams(subset);

		result = insertCharAtEveryPositionOfAWord(result, c);
		
		return result;
	}

	public List<String> insertCharAtEveryPositionOfAWord(List<String> prevAnagrams, char c) {
		List<String> currAnagrams = new ArrayList<String>();
		for (String anagram : prevAnagrams) {
			for (int i = 0; i <= anagram.length(); i++) {
				StringBuilder sb = new StringBuilder(anagram);
				if (i < anagram.length()) {
					sb.insert(i, c);
				} else {
					sb.append(c);
				}
				currAnagrams.add(sb.toString());
			}
		}
		return currAnagrams;
	}
}
