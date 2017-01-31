package com.cisco.preparation.javabasics;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MSantoshGiriGovind on 12/14/2016.
 */
public class UniqueString {
    public static void main(String[] args) {
        String ts = "abcdabgwas";
        Map<Character, Integer> charToCountMap = new HashMap<>();
        boolean isStringUnique = true;
        for (char c: ts.toCharArray()) {
            if(charToCountMap.containsKey(c))
            {
                charToCountMap.put(c, charToCountMap.get(c) + 1);
                isStringUnique = false;
                break;
            }else {
                charToCountMap.put(c, 1);
            }
        }

        if(isStringUnique){
            System.out.println("String " + ts + " does not contain any duplicate characters");
        }else
        {
            System.out.println("String " + ts + " contains duplicate characters");
        }
    }
}
