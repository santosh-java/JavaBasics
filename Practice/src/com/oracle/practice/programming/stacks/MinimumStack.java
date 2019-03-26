package com.oracle.practice.programming.stacks;

import com.oracle.practice.programming.StackOverflowException;
import com.oracle.practice.programming.StackUnderflowException;

/**
 * Class that solves "Finding minimum value in a stack at any point in constant
 * time i.e. O(1)" problem
 * 
 * How we solve? : By keeping track of the minimum value until that point in a
 * separate stack say minstack. At every push into the main stack, we will
 * compare it with the top of minstack and see if it is less than the value
 * inserted into main stack. If so, we will push the same value to both main
 * stack and minstack. Otherwise we will push the value to main stack and the
 * value at top of the minstack will be pushed again to the minstack to keep
 * track of the minimum value of the contents of stack until that point.
 * 
 * @author smarthi
 *
 */
public class MinimumStack {

	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

	public int findMinimumOfStack() throws StackUnderflowException {
		return minStack.peek();
	}

	public void push(int value) throws StackUnderflowException, StackOverflowException {
		int min = value;
		if(!minStack.isEmpty()) {
			if(min > minStack.peek()) {
				min = minStack.peek();
			}
		}
		stack.push(value);
		minStack.push(min);
	}

	public int pop() throws StackUnderflowException {
		int popped = stack.pop();
		System.out.println("Minimum value corresponding to " + popped + " is :" + minStack.pop());
		return popped;
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		MinimumStack ms = new MinimumStack();
		try {
			ms.push(10);
			ms.push(3);
			ms.push(5);
			ms.push(8);
			ms.push(1);
			ms.push(13);
			ms.push(4);
			while(!ms.isEmpty()) {
				System.out.println("MS: " + ms.pop());
			}
		} catch (StackUnderflowException | StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
