/**
 * 
 */
package com.oracle.testng.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author smarthi
 *
 */
public class TestNGTest1 {
	@BeforeSuite
	public void setup() {
		System.out.println("Setup");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@Test
	public void testCase1() {
		System.out.println("Testcase 1");
	}
}
