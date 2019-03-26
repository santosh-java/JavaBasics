package com.oracle.practice.programming.stacks;

import com.oracle.practice.programming.Element;
import com.oracle.practice.programming.StackOverflowException;
import com.oracle.practice.programming.StackUnderflowException;

public class Stack<T> {
	private static int MAX_SIZE = 40;

	private Element<T> top;
	private int size = 0;

	// push,pop,peek
	public void push(T data) throws StackOverflowException {
		if (size == MAX_SIZE) {
			throw new StackOverflowException();
		}

		Element<T> elem = new Element<T>(data, top);
		top = elem;
		size++;
	}

	public T pop() throws StackUnderflowException {
		if (size == 0) {
			throw new StackUnderflowException();
		}

		Element<T> retElm = top;
		T ret = retElm.getData();
		top = top.getNext();
		retElm.setNext(null);
		retElm = null;
		size--;
		return ret;
	}

	public T peek() throws StackUnderflowException {
		if (size == 0) {
			throw new StackUnderflowException();
		}
		return top.getData();
	}

	// isempty, isfull,getsize

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == MAX_SIZE;
	}

	public int getSize() {
		return size;
	}
}
