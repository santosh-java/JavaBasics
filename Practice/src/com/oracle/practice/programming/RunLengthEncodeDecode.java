package com.oracle.practice.programming;

import java.util.LinkedHashMap;

public class RunLengthEncodeDecode {

	public static void main(String[] args) {
		RunLengthEncodeDecode rled = new RunLengthEncodeDecode();
		System.out.println(rled.runLengthEncode("AAAAABBCCCCDDD"));
		System.out.println(rled.runLengthDecode(rled.runLengthEncode("AAAAABBCCCCDDD")));

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
