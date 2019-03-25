package com.oracle.practice.programming.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBlockingQueue {
	private BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>(1);

	public static void main(String args[]) {
		ProducerConsumerBlockingQueue pcbq = new ProducerConsumerBlockingQueue();
		pcbq.startBusiness();
	}

	public void startBusiness() {
		Thread producerT = new Thread(this::produce);
		Thread consumerT = new Thread(this::consume);

		producerT.start();
		consumerT.start();
		try {
			producerT.join();
			consumerT.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void produce() {
		int value = 0;
		while (true) {
			try {
				System.out.println("Produced :" + value);
				bq.put(value++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int consume() {
		while (true) {
			try {
				System.out.println("Consumed :" + bq.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
