package com.oracle.practice.programming.threads;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

	private int size = 1;
	private Queue<Integer> buffer = new LinkedList<Integer>();

	public void add(int value) {
		synchronized (this) {
			while (buffer.size() >= size) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			buffer.add(value);
			
			System.out.println("Produced " + value);
			notify();
		}
	}

	public int remove() {
		synchronized (this) {
			while (buffer.size() == 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			int result = buffer.poll();
			System.out.println("Consumed " + result);
			notify();
			return result;
		}
	}
}
