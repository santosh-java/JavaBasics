package com.oracle.practice.programming.stacks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.oracle.practice.programming.StackOverflowException;
import com.oracle.practice.programming.StackUnderflowException;

/**
 * A class that checks if a particular expression string provided as input is
 * valid with respect to the brackets '({[' i.e. has same number of closing
 * brackets as the number of opening brackets.
 * 
 * @author smarthi
 *
 */
public class ValidateBracesInExpression {

	private final Map<Character, Character> mapCloseBraceToOpenBrace = new HashMap<Character, Character>();
	private final Set<Character> validOpeningBraces = new HashSet<Character>();

	public ValidateBracesInExpression() {
		init();
	}

	private void init() {
		mapCloseBraceToOpenBrace.put(']', '[');
		mapCloseBraceToOpenBrace.put('}', '{');
		mapCloseBraceToOpenBrace.put(')', '(');

		validOpeningBraces.addAll(mapCloseBraceToOpenBrace.values());
	}

	public boolean validateBracesInExpression(String expression) {
		if (expression == null || expression.length() == 0) {
			return true;
		}

		Stack<Character> openingBraces = new Stack<Character>();
		try {
			for (Character c : expression.toCharArray()) {
				if (validOpeningBraces.contains(c)) {
					openingBraces.push(c);
				}

				if (mapCloseBraceToOpenBrace.containsKey(c)) {
					if (!(openingBraces.pop() == mapCloseBraceToOpenBrace.get(c))) {
						return false;
					}
				}
			}
			return openingBraces.isEmpty();
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("StackOverflow");
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("StackUnderflow");
		}
		return false;
	}

	public static void main(String[] args) {
		ValidateBracesInExpression vbie = new ValidateBracesInExpression();
		System.out.println("Expression (ABC){DEF}[{GHI}LMN] is a :"
				+ (vbie.validateBracesInExpression("(ABC){DEF}[{GHI}LMN]") ? " valid " : " invalid ") + "expression");
	}
}
