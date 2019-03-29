package com.oracle.practice.programming.queues;

import java.lang.reflect.Array;

public class Queue<T> {
	private T[] circularArr;
	private static final int MAX_QUEUE_SIZE = 40;
	private static final int QUEUE_EMPTY_INDICATOR = -1;
	private int headIndex;
	private int tailIndex;

	@SuppressWarnings("unchecked")
	public Queue(Class<T> queueDataClass) {
		circularArr = (T[]) Array.newInstance(queueDataClass, MAX_QUEUE_SIZE);
		headIndex = QUEUE_EMPTY_INDICATOR;
		tailIndex = QUEUE_EMPTY_INDICATOR;
	}

	// operations : enqueue, dequeue, isFull, isEmpty, peek, offer
	public boolean isFull() {
		return ((tailIndex + 1) % circularArr.length) == headIndex;
	}

	public boolean isEmpty() {
		return headIndex == QUEUE_EMPTY_INDICATOR;
	}

	public void enqueue(T data) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}
		System.out.println("Enqueuing " + data);
		tailIndex = (tailIndex + 1) % circularArr.length;
		if (isEmpty()) {
			headIndex = tailIndex;
		}
		circularArr[tailIndex] = data;
	}

	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}

		T retVal = circularArr[headIndex];
		System.out.println("Dequeuing " + retVal);

		if (headIndex == tailIndex) {
			headIndex = QUEUE_EMPTY_INDICATOR;
		}else {
			headIndex = (headIndex + 1) % circularArr.length;
		}

		return retVal;
	}

	public T peek() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		return circularArr[headIndex];
	}

	public boolean offer(T data) {
		if (isFull()) {
			return false;
		}

		tailIndex = (tailIndex + 1) % circularArr.length;
		if (isEmpty()) {
			headIndex = tailIndex;
		}
		circularArr[tailIndex] = data;
		System.out.println("Offered : " + data);
		return true;
	}
}
