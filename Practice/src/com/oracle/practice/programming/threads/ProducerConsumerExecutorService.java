package com.oracle.practice.programming.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerExecutorService {

	private ExecutorService pool;
	private BlockingQueue<Integer> buffer;

	public static void main(String[] args) {
		ProducerConsumerExecutorService pces = new ProducerConsumerExecutorService();
		pces.startBusiness();
	}

	public ProducerConsumerExecutorService() {
		this.buffer = new LinkedBlockingQueue<Integer>(1);
		this.pool = Executors.newFixedThreadPool(2);
	}

	public void startBusiness() {
		pool.execute(this::produce);
		pool.execute(this::consume);
		try {
			pool.awaitTermination(1, TimeUnit.SECONDS);
			pool.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void produce() {
		int value = 0;
		while (true) {
			System.out.println("Produced :" + value);
			try {
				buffer.put(value++);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void consume() {
		while(true) {
			try {
				System.out.println("Consumer :" + buffer.take());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
