package com.oracle.practice.programming;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class RunLengthEncodeDecode {

	public static void main(String[] args) {
		RunLengthEncodeDecode rled = new RunLengthEncodeDecode();
		System.out.println(rled.runLengthEncodeNonMap("AAAAABBCCCCDDDAACBBBDDD"));
		System.out.println(rled.runLengthDecode(rled.runLengthEncodeNonMap("AAAAABBCCCCDDDAACBBBDDD")));
	}

	public String runLengthEncode(String source) {
		LinkedHashMap<String, Integer> encodedString = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < source.length(); i++) {
			String c = String.valueOf(source.charAt(i));
			if (encodedString.containsKey(c)) {
				encodedString.put(String.valueOf(c), encodedString.get(c) + 1);
			} else {
				encodedString.put(String.valueOf(c), 1);
			}
		}
		StringBuilder encodedStr = new StringBuilder();
		encodedString.forEach((character, repetetions) -> encodedStr.append(repetetions + character));
		return encodedStr.toString();
	}
	
	public String runLengthEncodeNonMap(String source) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			int count = 1;
			for(int j= i+1; j< source.length(); j++) {
				
				if(source.charAt(j) == c) {
					count++;
					i++;
				}else
					break;
			}
			result.append(count);
			result.append(c);
			
		}
		return result.toString();
	}

	public String runLengthDecode(String encodedStr) {
		StringBuilder decodedString = new StringBuilder();
		
		for (int i = 0; i < encodedStr.length(); i++) {
			int numStart = i;
			while(true) {
				char c = encodedStr.charAt(i);
				if(Character.isDigit(c)) {
					i++;
				}else {
					break;
				}
			}
			int repeats = Integer.parseUnsignedInt(encodedStr.substring(numStart,i));
			char ch = encodedStr.charAt(i);
			for(int j =0; j<repeats; j++) {
				decodedString.append(ch);
			}			
		}
		return decodedString.toString();
	}

}
