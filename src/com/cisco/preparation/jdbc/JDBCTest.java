package com.cisco.preparation.jdbc;

import java.util.concurrent.atomic.AtomicInteger;

public class JDBCTest {
	public static void main(String[] args) {
		AtomicInteger a = new AtomicInteger(1);
		AtomicInteger b = a;
		System.out.println(a + " : " + b);
		System.out.println("a ihc: " + System.identityHashCode(a) + " : b ihc: " + System.identityHashCode(b));
		a.incrementAndGet();
		System.out.println(a + " : " + b);
		System.out.println("a ihc: " + System.identityHashCode(a) + " : b ihc: " + System.identityHashCode(b));
	}

}
