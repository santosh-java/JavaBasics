package com.cisco.preparation.multithreading.producerconsumer;

public class Print123_WithThreeThreads {
	public static void main(String[] args) {
		Object monitor = new Object();
		Thread t1 = new Thread(new SequencePrinter_(monitor, true, false, false, 1));
		Thread t2 = new Thread(new SequencePrinter_(monitor, false, true, false, 2));
		Thread t3 = new Thread(new SequencePrinter_(monitor, false, false, true, 3));

		t1.start();
		t2.start();
		t3.start();
	}
}

class SequencePrinter_ implements Runnable {
	private final Object MONITOR;
	private Boolean one;
	private Boolean two;
	private Boolean three;
	private int threadId;

	public SequencePrinter_(Object monitor, Boolean one, Boolean two, Boolean three, int threadId) {
		this.MONITOR = monitor;
		this.one = one;
		this.two = two;
		this.three = three;
		this.threadId = threadId;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			switch (threadId) {
			case 1:
				if (!one) {
					synchronized (MONITOR) {
						try {
//							System.out.println(threadId + " is waiting");
							MONITOR.wait();
						} catch (InterruptedException ie) {

						}
					}
				}
				System.out.println(threadId);
				one = false;
				two = true;
				three = false;
				synchronized (MONITOR) {
//					System.out.println(threadId + " is notifying");
					MONITOR.notifyAll();
				}
				break;
			case 2:
				if (!two) {
					synchronized (MONITOR) {
						try {
//							System.out.println(threadId + " is waiting");
							MONITOR.wait();
						} catch (InterruptedException ie) {

						}
					}
				}
				System.out.println(threadId);
				one = false;
				two = false;
				three = true;
				synchronized (MONITOR) {
//					System.out.println(threadId + " is notifying");
					MONITOR.notifyAll();
				}
				break;
			case 3:
				if (!three) {
					synchronized (MONITOR) {
						try {
//							System.out.println(threadId + " is waiting");
							MONITOR.wait();
						} catch (InterruptedException ie) {

						}
					}
				}
				System.out.println(threadId);
				one = true;
				two = false;
				three = false;
				synchronized (MONITOR) {
//					System.out.println(threadId + " is notifying");
					MONITOR.notifyAll();
				}
				break;
			}
		}
	}

}
