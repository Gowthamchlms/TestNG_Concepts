package org.scripts;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class AutoReRunFailedTestCase implements IAnnotationTransformer{

	public void transform(ITestAnnotation a, Class testclass, Constructor testconstructor, Method testmethod) {
		
		IRetryAnalyzer retry = a.getRetryAnalyzer();
		
		if (retry == null) {
			a.setRetryAnalyzer(RerunFailedTestCase.class);
		}
		
	}
	
	
}

	
		

