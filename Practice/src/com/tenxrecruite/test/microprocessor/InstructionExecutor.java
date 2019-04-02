/**
 * 
 */
package com.tenxrecruite.test.microprocessor;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * Class that handles following 4 instructions and the words it works on are of
 * 32-bit size.
 * 
 * CLEAR i : Put a zero into bit i. SET i : Put a one into bit i. OR i j : Store
 * in bit i the logical OR of the contents of bits i and j. AND i j : Store in
 * bit i the logical AND of the contents of bits i and j.
 * 
 * This class performs above operations on the provided 32-bit array
 * 
 * @author smarthi
 *
 */

interface Instruction {
	public char[] execute();

	public default boolean isPosInRange(int pos) {
		return pos >= 0 && pos <= 31;
	}
}

class ClearInstruction implements Instruction {
	private char[] word;

	private int pos;

	public char[] getWord() {
		return word;
	}

	public void setWord(char[] word) {
		this.word = word;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	@Override
	public char[] execute() {
		if (!isPosInRange(pos)) {
			throw new IllegalArgumentException("Invalid position provided for CLEARing... Please check...");
		}

		word[pos] = '0';
		return word;
	}

}

class SetInstruction implements Instruction {
	private char[] word;
	private int pos;

	public char[] getWord() {
		return word;
	}

	public void setWord(char[] word) {
		this.word = word;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	@Override
	public char[] execute() {
		if (!isPosInRange(pos)) {
			throw new IllegalArgumentException("Invalid position provided for SETting... Please check...");
		}

		word[pos] = '1';
		return word;
	}

}

class OrInstruction implements Instruction {
	private char[] word;
	private int firstPos;
	private int secondPos;

	public char[] getWord() {
		return word;
	}

	public void setWord(char[] word) {
		this.word = word;
	}

	public int getFirstPos() {
		return firstPos;
	}

	public void setFirstPos(int firstPos) {
		this.firstPos = firstPos;
	}

	public int getSecondPos() {
		return secondPos;
	}

	public void setSecondPos(int secondPos) {
		this.secondPos = secondPos;
	}

	@Override
	public char[] execute() {
		if (!isPosInRange(firstPos) || !isPosInRange(secondPos)) {
			throw new IllegalArgumentException("Invalid positions provided for ORing... Please check...");
		}
		if ((word[firstPos] == '?') || (word[secondPos] == '?')) {
			word[firstPos] = '?';
			return word;
		}

		if (word[firstPos] == '0' && word[secondPos] == '0')
			word[firstPos] = '0';
		else
			word[firstPos] = '1';
		
		return word;
	}

}

class AndInstruction implements Instruction {
	private char[] word;
	private int firstPos;
	private int secondPos;

	public char[] getWord() {
		return word;
	}

	public void setWord(char[] word) {
		this.word = word;
	}

	public int getFirstPos() {
		return firstPos;
	}

	public void setFirstPos(int firstPos) {
		this.firstPos = firstPos;
	}

	public int getSecondPos() {
		return secondPos;
	}

	public void setSecondPos(int secondPos) {
		this.secondPos = secondPos;
	}

	@Override
	public char[] execute() {
		if (!isPosInRange(firstPos) || !isPosInRange(secondPos)) {
			throw new IllegalArgumentException("Invalid positions provided for ANDing... Please check...");
		}
		if ((word[firstPos] == '?') || (word[secondPos] == '?')) {
			word[firstPos] = '?';
			return word;
		}
		
		if (word[firstPos] == '1' && word[secondPos] == '1')
			word[firstPos] = '1';
		else
			word[firstPos] = '0';
		
		return word;
	}

}

abstract class Microprocessor {
	private ClearInstruction clear;
	private SetInstruction set;
	private OrInstruction or;
	private AndInstruction and;

	public Microprocessor() {
		clear = new ClearInstruction();
		set = new SetInstruction();
		or = new OrInstruction();
		and = new AndInstruction();
	}

	public ClearInstruction getClear() {
		return clear;
	}

	public void setClear(ClearInstruction clear) {
		this.clear = clear;
	}

	public SetInstruction getSet() {
		return set;
	}

	public void setSet(SetInstruction set) {
		this.set = set;
	}

	public OrInstruction getOr() {
		return or;
	}

	public void setOr(OrInstruction or) {
		this.or = or;
	}

	public AndInstruction getAnd() {
		return and;
	}

	public void setAnd(AndInstruction and) {
		this.and = and;
	}

	public void performClear() {
		if (clear != null)
			clear.execute();
		else
			throw new IllegalStateException("Operation not supported!!!");
	}

	public void performSet() {
		if (set != null)
			set.execute();
		else
			throw new IllegalStateException("Operation not supported!!!");
	}

	public void performOr() {
		if (or != null)
			or.execute();
		else
			throw new IllegalStateException("Operation not supported!!!");
	}

	public void performAnd() {
		if (and != null)
			and.execute();
		else
			throw new IllegalStateException("Operation not supported!!!");
	}
}

public class InstructionExecutor extends Microprocessor {

	public static void main(String args[]) {
		InstructionExecutor insExecutor = new InstructionExecutor();

		try (Scanner s = new Scanner(System.in)) {
			while (s.hasNextLine()) {
				String input = s.nextLine();

				if (input == null || input.length() == 0) {
					break;
				}

				int instructionCount = -1;

				try {
					instructionCount = Integer.parseInt(input);
					if (instructionCount == 0) {
						break;
					}
					char[] word = createInitialWord(32);
					processInstructions(s, instructionCount, word, insExecutor);
					for (int i = word.length - 1; i >= 0; i--) {
						if (i == 0) {
							System.out.println(word[i]);
						} else {
							System.out.print(word[i]);
						}
					}
				} catch (NumberFormatException nfe) {
					System.out.println("Exception occurred!!!");
				}
			}
		}
	}

	private static void processInstructions(Scanner s, int instructionCount, char[] word, InstructionExecutor ie) {
		for (int i = 0; i < instructionCount; i++) {
			String instruction = s.nextLine();
			String[] inst = instruction.split(" ");
			instantiateAppropriateInstructionFromInputAndExecute(inst, word, ie);
		}
	}

	private static void instantiateAppropriateInstructionFromInputAndExecute(String[] inst, char[] word,
			InstructionExecutor ie) {
		switch (inst[0]) {
		case "CLEAR":
			ie.getClear().setWord(word);
			ie.getClear().setPos(Integer.parseInt(inst[1]));
			ie.performClear();
			break;
		case "SET":
			ie.getSet().setWord(word);
			ie.getSet().setPos(Integer.parseInt(inst[1]));
			ie.performSet();
			break;
		case "OR":
			ie.getOr().setWord(word);
			ie.getOr().setFirstPos(Integer.parseInt(inst[1]));
			ie.getOr().setSecondPos(Integer.parseInt(inst[2]));
			ie.performOr();
			break;
		case "AND":
			ie.getAnd().setWord(word);
			ie.getAnd().setFirstPos(Integer.parseInt(inst[1]));
			ie.getAnd().setSecondPos(Integer.parseInt(inst[2]));
			ie.performAnd();
			break;
		}
	}

	private static char[] createInitialWord(int size) {
		char[] word = (char[]) Array.newInstance(char.class, size);
		for (int i = 0; i < word.length; i++) {
			word[i] = '?';
		}
		return word;
	}
}
