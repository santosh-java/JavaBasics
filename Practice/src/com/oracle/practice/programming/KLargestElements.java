package com.oracle.practice.programming;

import java.util.PriorityQueue;

public class KLargestElements {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = null;
		int[] source = new int[] {19,2,65,23,1,4,6,82,45,12,40,50,7};	
		KLargestElements kle = new KLargestElements();
		pq = kle.findKLargestElements(3, source);
		for(int i = 0; i<3; i++) {
			System.out.println(pq.poll());
		}
	}
	
	public PriorityQueue<Integer> findKLargestElements(int k, int[] streamArray) {
		PriorityQueue<Integer> result = new PriorityQueue<Integer>(k, (i,j)->j.compareTo(i));
		
		for(Integer i: streamArray) {
			if(result.size() < k) {
				result.offer(i);
				continue;
			}
			
			if(i < result.peek()) {
				result.poll();
				result.add(i);
			}
		}
		
		return result;
	}

}
