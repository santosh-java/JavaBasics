package com.oracle.practice.programming.threads;

public class ProducerConsumerClassic {

	private static Buffer b = new Buffer();

	public static void main(String[] args) {
		ProducerConsumerClassic pcc = new ProducerConsumerClassic();
		try {
			pcc.startBusiness();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startBusiness() throws InterruptedException {
		Thread producerThread = new Thread(ProducerConsumerClassic::produce);
		Thread consumerThread = new Thread(ProducerConsumerClassic::consume);
		producerThread.start();
		consumerThread.start();
		producerThread.join();
		consumerThread.join();
	}

	public static void produce() {
		int value = 1;
		while (true) {
			b.add(value++);
		}
	}

	public static void consume() {
		while (true) {
			System.out.println("Insize calling consume : " + b.remove());
		}
	}

}
