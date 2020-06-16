package org.scripts;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunFailedTestCase implements IRetryAnalyzer{

	int minCount = 0, maxCount = 10;
	
	public boolean retry(ITestResult result) {
		
		while (minCount < maxCount) {
			minCount ++ ;
			return true;
		}
		return false;
	}

}
