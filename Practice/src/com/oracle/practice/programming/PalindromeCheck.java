package com.oracle.practice.programming;

public class PalindromeCheck {

	public static void main(String[] args) {
		PalindromeCheck pc = new PalindromeCheck();
		System.out.println("Is Window palindrome: " + pc.checkIfPalindrome("Window"));
		System.out.println("Is refer palindrome: " + pc.checkIfPalindrome("refer"));
		System.out.println("Is Lonely Tylenol palindrome: " + pc.checkIfPalindrome("Lonely Tylenol"));
	}
	
	public boolean checkIfPalindrome(String word) {
		if(word == null) {
			return false;
		}
		word = word.replaceAll(" ", "");
		word = word.toLowerCase();
		int stInd = 0;
		int enInd = word.length()-1;
		boolean result = true;
		
		while (stInd < enInd) {
			result = result && (word.charAt(stInd++)==word.charAt(enInd--));
			if(!result) {
				break;
			}
		}
		
		return result;
		
	}

}
