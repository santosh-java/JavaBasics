package com.oracle.practice.programming.queues;

import com.oracle.practice.programming.StackOverflowException;
import com.oracle.practice.programming.StackUnderflowException;
import com.oracle.practice.programming.stacks.Stack;

/**
 * A queue implementation using two stacks
 * 
 * @author smarthi
 *
 */
public class QueueWithStack<T> {

	private Stack<T> forwardStack;
	private Stack<T> reverseStack;

	public QueueWithStack() {
		this.forwardStack = new Stack<T>();
		this.reverseStack = new Stack<T>();
	}

	// Operations: enqueue, dequeue, isFull, isEmpty
	public boolean isFull() {
		return forwardStack.isFull() || reverseStack.isFull();
	}

	public boolean isEmpty() {
		return forwardStack.isEmpty() && reverseStack.isEmpty();
	}

	public void enqueue(T data) throws QueueOverflowException, StackOverflowException, StackUnderflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}

		if (forwardStack.isEmpty()) {
			while (!reverseStack.isEmpty()) {
				forwardStack.push(reverseStack.pop());
			}
		}

		forwardStack.push(data);
	}

	public T dequeue() throws QueueUnderflowException, StackOverflowException, StackUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}

		if (reverseStack.isEmpty()) {
			while (!forwardStack.isEmpty()) {
				reverseStack.push(forwardStack.pop());
			}
		}

		return reverseStack.pop();
	}
	
	public static void main(String[] args) {
		QueueWithStack<Integer> q = new QueueWithStack<Integer>();
		
		try {
			System.out.println("Enqueue 1");
			q.enqueue(1);
			System.out.println("Dequeue " + q.dequeue());
			System.out.println("Enqueue 2");
			q.enqueue(2);
			System.out.println("Enqueue 3");
			q.enqueue(3);
			System.out.println("Dequeue " + q.dequeue());
			System.out.println("Enqueue 4");
			q.enqueue(4);
			System.out.println("Enqueue 5");
			q.enqueue(5);
			System.out.println("Enqueue 6");
			q.enqueue(6);
			while(!q.isEmpty()) {
				System.out.println("Dequeue "+q.dequeue());
			}
		} catch (QueueOverflowException | StackOverflowException | StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
