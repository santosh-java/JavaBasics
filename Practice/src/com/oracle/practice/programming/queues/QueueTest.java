package com.oracle.practice.programming.queues;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> intQ = new Queue<Integer>(Integer.class);
		try {
			intQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			intQ.enqueue(1);
			intQ.enqueue(2);
			intQ.enqueue(3);
			while(!intQ.isEmpty()) {
				intQ.dequeue();
			}
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
