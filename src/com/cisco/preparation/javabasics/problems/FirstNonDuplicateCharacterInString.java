package com.cisco.preparation.javabasics.problems;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Find the first non-duplicate character from a given string.
 * <p>
 * Example: String = 'efficiency'
 * Answer: First non-duplicate character is 'n'
 */
public class FirstNonDuplicateCharacterInString {
  public Character findFirstNonDuplicateChar(String str) {
    LinkedHashMap<Character, Integer> charCount = new LinkedHashMap<>();
    for (int i = 0; i < str.length(); i++) {
      char key = str.charAt(i);
      Integer value = charCount.get(key);
      if (value != null) {
        value = value + 1;
      } else {
        value = 1;
      }
      charCount.put(key, value);
    }
    return charCount.entrySet()
      .stream()
      .filter(entry -> entry.getValue() == 1)
      .peek(System.out::println)
      .findFirst()
      .map(Map.Entry::getKey)
      .orElse(null);
  }
}
