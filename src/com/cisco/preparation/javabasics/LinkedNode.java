package com.cisco.preparation.javabasics;

public class LinkedNode {

	LinkedNode next;
	int data;

	public LinkedNode(int data) {
		this.data = data;
		this.next = null;
	}
	
	public String toString(){
		return "["+data+"]";
	}
}
