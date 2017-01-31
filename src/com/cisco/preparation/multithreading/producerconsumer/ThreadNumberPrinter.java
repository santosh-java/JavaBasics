package com.cisco.preparation.multithreading.producerconsumer;

import java.util.concurrent.atomic.AtomicLong;

public class ThreadNumberPrinter {

	public static void main(String[] args) {
		Object monitor = new Object();
		AtomicLong number = new AtomicLong(0);
		Thread t1 = new Thread(new Printer(1, 5, monitor, number));
		Thread t2 = new Thread(new Printer(2, 5, monitor, number));
		Thread t3 = new Thread(new Printer(3, 5, monitor, number));
		Thread t4 = new Thread(new Printer(4, 5, monitor, number));
		Thread t5 = new Thread(new Printer(5, 5, monitor, number));
		
		t5.start();
		t4.start();
		t3.start();
		t2.start();
		t1.start();
	}
}

class Printer implements Runnable {

	int threadId;
	int numOfThreads;
	Object monitor;
	AtomicLong number;

	public Printer(int id, int nubOfThreads, Object monitor, AtomicLong number) {
		threadId = id;
		this.numOfThreads = nubOfThreads;
		this.monitor = monitor;
		this.number = number;
	}

	public void run() {
		print();
	}

	private void print() {
		try {
			while (true) {
				Thread.sleep(500l);
				synchronized (monitor) {
					if (number.get() % numOfThreads != threadId-1) {
						System.out.println(Thread.currentThread().getName() + " goint to wait");
						monitor.wait();
					} else {
						System.out.println(threadId);
						number.getAndIncrement();
						monitor.notifyAll();
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
