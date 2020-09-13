package com.cisco.preparation.javabasics.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * <p>
 * Given an array of unique characters <code>arr</code> and a string <code>str</code>, implement a function
 * <code>getShortestUniqueSubstring</code> that finds the smallest substring of <code>str</code> containing all characters
 * in <code>arr</code>. Return "" empty string if such substring does not exist.
 * <p>
 * Come up with an asymptotically optimal solution and analyse the time and space complexities.
 * <p>
 * Example:
 * input: arr = ['x', 'y', 'z'], str = "xyyzyzyx"
 * output: "zyx"
 * <p>
 * <u>Constraints:</u><br>
 * <b>[time limit] : 5000 ms <br>
 * [input] array.character <code>arr</code> <br>
 * 1 <= arr.length <= 30 <br>
 * <p>
 * [input] string <code>str</code> <br>
 * 1<= str.length <= 500 <br>
 * </b>
 * </p>
 *
 * <p>
 * <u>Pseudo code:</u> <br>
 *   <ol>
 * <li>
 * Have int variable SSLUN that holds the shortest substring length until now  </li>
 * <li>Have int variable SSS that holds the start index of shortest substring start position until now  </li>
 * <li>Have int variable SSE that holds the end index of shortest substring end position until now </li>
 * <li>Initialise Map <Character, TreeSet> [say <b>positionsMap</b>] that holds map of character in arr and corresponding indexes of characters in str </li>
 * <li>Start iterating through the string characters [say ch] one by one. if ch is one of arr elements, then </li>
 *  <ul>
 *    <li>Get TreeSet of ch from positionsMap and add corresponding index to it</li>
 *    <li>Now find the lowest index value of all the character's lowest values [say ll] </li>
 *    <li>Now find the highest index value of all the character's highest values [say hh]</li>
 *    <li>If the difference between hh and ll is < SSLUN then update SSLUN = hh - ll; SSS = ll; SSE = hh;</li>
 *  </ul>
 *
 * </ol>
 * </p>
 */
public class ShortestSubArray {
  public String getShortestUniqueSubstring(char[] arr, String str) {
    int sssLengthUntilNow = Integer.MAX_VALUE;
    int sssStart = -1;
    int sssEnd = -1;
    Map<Character, TreeSet<Integer>> positionsMap = new HashMap<>(arr.length);
    TreeSet<Integer> tempPositions = new TreeSet<>();
    init(positionsMap, arr);
    int uniqueCharCount = 0;
    boolean allCharsCounted = false;

    for (int i = 0; i < str.length(); i++) {
      Character charAtI = str.charAt(i);
      if (positionsMap.containsKey(charAtI)) {
        TreeSet<Integer> positions = positionsMap.get(charAtI);
        if (!allCharsCounted && positions.size() == 0) {
          uniqueCharCount++;
        }
        positions.add(i);
        if (!allCharsCounted && uniqueCharCount == arr.length) {
          allCharsCounted = true;
        }

        if (allCharsCounted) {
          tempPositions = updateLowsAndHighs(positionsMap);
          if (tempPositions.last() - tempPositions.first() < sssLengthUntilNow) {
            sssLengthUntilNow = tempPositions.last() - tempPositions.first();
            sssStart = tempPositions.first();
            sssEnd = tempPositions.last();
          }
        }
      }
    }

    if (!allCharsCounted) {
      return "";
    } else {
      return str.substring(sssStart, sssEnd + 1);
    }
  }

  public String minimumWindow(String arr, String str) {
    int sssLengthUntilNow = Integer.MAX_VALUE;
    int sssStart = -1;
    int sssEnd = -1;
    Map<Character, TreeSet<Integer>> positionsMap = new HashMap<>(arr.length());
    TreeSet<Integer> tempPositions = new TreeSet<>();
    init(positionsMap, arr);
    int uniqueCharCount = 0;
    boolean allCharsCounted = false;

    for (int i = 0; i < str.length(); i++) {
      Character charAtI = str.charAt(i);
      if (positionsMap.containsKey(charAtI)) {
        TreeSet<Integer> positions = positionsMap.get(charAtI);
        if (!allCharsCounted && positions.size() == 0) {
          uniqueCharCount++;
        }
        positions.add(i);
        if (!allCharsCounted && uniqueCharCount == arr.length()) {
          allCharsCounted = true;
        }

        if (allCharsCounted) {
          tempPositions = updateLowsAndHighs(positionsMap);
          if (tempPositions.last() - tempPositions.first() < sssLengthUntilNow) {
            sssLengthUntilNow = tempPositions.last() - tempPositions.first();
            sssStart = tempPositions.first();
            sssEnd = tempPositions.last();
          }
        }
      }
    }

    if (!allCharsCounted) {
      return "";
    } else {
      return str.substring(sssStart, sssEnd + 1);
    }
  }


  private TreeSet<Integer> updateLowsAndHighs(Map<Character, TreeSet<Integer>> positionsMap) {
    TreeSet<Integer> tempPos = new TreeSet<>();
    positionsMap.keySet().forEach(character -> {
      tempPos.add(positionsMap.get(character).last());
    });
    return tempPos;
  }

  private void init(Map<Character, TreeSet<Integer>> positionsMap, char[] arr) {
    for (Character c : arr) {
      positionsMap.put(c, new TreeSet<>());
    }
  }

  private void init(Map<Character, TreeSet<Integer>> positionsMap, String arr) {
    for (int i = 0; i < arr.length(); i++) {
      positionsMap.put(arr.charAt(i), new TreeSet<>());
    }
  }
}
