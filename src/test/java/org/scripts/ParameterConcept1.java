package org.scripts;

import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utilityClass.UtilityClass;

public class ParameterConcept1 extends UtilityClass {
SoftAssert valid = new SoftAssert();
	
	@BeforeClass
	private void browserLaun() {
		browserLaunch();
		
	}
	
	@BeforeMethod
	private void startTime() {
		Date time = new Date();
		System.out.println("Start time of test case: " + time );
	}
	
	@Parameters ({"url", "time"})
	@Test
	private void tc1(String url, int time) {
		url(url, time);
		System.out.println("The user gets entered into Adactin home page");
		valid.assertTrue(driver.getCurrentUrl().equals("http://adactinhotelapp.com/index.php"), "The user enters the proper page");
	}
	
	@Parameters ({"username", "password"})
	@Test
	private void tc2(@Optional("GOWTHAMK") String username, String password) {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click();		
		valid.assertTrue(driver.getCurrentUrl().equals("http://adactinhotelapp.com/SearchHotel.php"), "The user enters the proper page");
		
	}
	
	@AfterMethod
	private void endTime() {
		Date time = new Date();
		System.out.println("End time of test case: " + time );
	}

	@AfterClass
	private void endExecution() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
	
}
