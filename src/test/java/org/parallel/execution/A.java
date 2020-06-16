package org.parallel.execution;

import org.scripts.RerunFailedTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A {

	@Test 
	private void tc1() {
		Assert.assertTrue(true, "The Test case 1 gets passed");
		System.out.println(Thread.currentThread().getId());
	}

	
	@Test
	private void tc2() {
		Assert.assertTrue(false, "The Test case 2 gets failed");
		System.out.println(Thread.currentThread().getId());
	}
	
	
	@Test
	private void tc3() {
		Assert.assertTrue(true, "The Test case 3 gets passed");
		System.out.println(Thread.currentThread().getId());
	}
	
	
	@Test 
	private void tc4() {
		Assert.assertTrue(false, "The Test case 4 gets failed");
		System.out.println(Thread.currentThread().getId());
	}
	
}
