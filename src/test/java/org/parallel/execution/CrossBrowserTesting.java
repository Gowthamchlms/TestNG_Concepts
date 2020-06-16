package org.parallel.execution;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.utilityClass.UtilityClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting extends UtilityClass {

SoftAssert valid = new SoftAssert();
	
	@Parameters ({"browser"})
	@BeforeClass
	private void browserLaun(String browser) {
		if (browser == "chrome") {
			browserLaunch();
		}
		
		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		
	}
	
	
	@BeforeMethod
	private void startTime() {
		Date time = new Date();
		System.out.println("Start time of test case: " + time );
	}
	
	
	@Test 
	private void tc1() {
		url("http://adactinhotelapp.com/index.php", 10);
		System.out.println("The user gets entered into Adactin home page");
		valid.assertTrue(driver.getCurrentUrl().equals("http://adactinhotelapp.com/index.php"), "The user enters the proper page");
		
	}
	
	
	@Test
	private void tc2() {
		driver.findElement(By.id("username")).sendKeys("GOWTHAMK");
		driver.findElement(By.id("password")).sendKeys("Myvizhi@1194");
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
