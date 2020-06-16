package org.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Prioritization {

	@Test (priority = -1)
	private void tc1() {
		Assert.assertTrue(true, "The Test case 1 gets passed");
	}

	
	@Test(enabled = false)
	private void tc2() {
		Assert.assertTrue(false, "The Test case 2 gets failed");
	}
	
	
	@Test(priority = 0)
	private void tc3() {
		Assert.assertTrue(true, "The Test case 3 gets passed");
	}
	
	
	@Test (retryAnalyzer = RerunFailedTestCase.class)
	private void tc4() {
		Assert.assertTrue(false, "The Test case 4 gets failed");
	}
	
	
	
}
