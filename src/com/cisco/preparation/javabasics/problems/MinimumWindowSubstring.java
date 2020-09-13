package com.cisco.preparation.javabasics.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * Note:
 * <p>
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 * T can contain repeated characters
 */
public class MinimumWindowSubstring {
  public String minimumWindow(String s, String t) {
    Map<Character, Integer> searchCharsMap = fillSearchMap(t);
    Map<Character, Integer> inputCharsMap = new HashMap<>();
    int start = -1;
    int end = -1;
    int shortestSSLength = Integer.MAX_VALUE;

    for (int right = 0, left = 0; right < s.length(); right++) {
      Integer rCount = inputCharsMap.getOrDefault(s.charAt(right), 0);
      inputCharsMap.put(s.charAt(right), ++rCount);
      if (compareMaps(searchCharsMap, inputCharsMap)) {
        // At this point the we read characters from input string that contains all the search characters. Now we will
        // start incrementing left by one and check if the inputCharsMap contains required counts of search char counts.
        end = right;
        do {
          start = left++;
          char leftChar = s.charAt(start);
          inputCharsMap.put(leftChar, inputCharsMap.get(leftChar) - 1);
        }
        while (compareMaps(searchCharsMap, inputCharsMap) && left <= right);

        if (end - start < shortestSSLength) {
          shortestSSLength = end - start;
        }
      }
    }

    if (start >= 0 && end >= start) {
      return s.substring(start, end + 1);
    } else {
      return "";
    }
  }

  private boolean compareMaps(Map<Character, Integer> searchCharsMap, Map<Character, Integer> inputCharsMap) {
    boolean result = false;
    for (Character character : searchCharsMap.keySet()) {
      if (inputCharsMap.containsKey(character) && inputCharsMap.get(character) >= searchCharsMap.get(character)) {
        result = true;
      } else {
        return false;
      }
    }
    return result;
  }

  private Map<Character, Integer> fillSearchMap(String t) {
    Map<Character, Integer> result = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      Integer count = result.get(t.charAt(i));
      if (count != null) {
        result.put(t.charAt(i), ++count);
      } else {
        result.put(t.charAt(i), 1);
      }
    }
    return result;
  }
}
