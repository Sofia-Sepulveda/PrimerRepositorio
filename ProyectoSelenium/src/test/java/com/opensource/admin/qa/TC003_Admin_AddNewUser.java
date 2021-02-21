package com.opensource.admin.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC003_Admin_AddNewUser {
	@BeforeTest
	public void beforeTest() {
	}

	@Test
	public void TC003_Admin_AddNewUser_TC() {
		//Step  1
		Reporter.log("Open Browser \"OrangeHRM\" web page");
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver/Chrome/chromedriver.exe");
		WebDriver driver  = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Step 2
		Reporter.log("Enter Username and Password");
		driver.findElement(By.xpath("//input [@id ='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input [@id ='txtPassword']")).sendKeys("admin123");;
		driver.findElement(By.xpath("//input [@id ='btnLogin']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Step  3
		Reporter.log("Validate that you have logged in successfully");
		WebDriverWait espera =  new WebDriverWait(driver,30);
		espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a [@id ='menu_admin_viewAdminModule']")));
		
		//Step 4
		Reporter.log("Click Admin - Go to the admin page");
		driver.findElement(By.xpath("//a [@id ='menu_admin_viewAdminModule']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Step 5
		Reporter.log("Click Add");
		driver.findElement(By.xpath("//input [@id ='btnAdd']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input [@id ='systemUser_employeeName_empName']")));
		
		//Step 6
		Reporter.log("Enter valid Employee Name");
		driver.findElement(By.xpath("//input [@id ='systemUser_employeeName_empName']")).sendKeys("Nathan Elliot");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Step 7
		Reporter.log("Enter valid username");
		driver.findElement(By.xpath("//input [@id ='systemUser_userName']")).sendKeys("Sofia Sepulveda");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Step 8
		Reporter.log("Enter new password and confirm");
		driver.findElement(By.xpath("//input [@id ='systemUser_password']")).sendKeys("Password");
		driver.findElement(By.xpath("//input [@id ='systemUser_confirmPassword']")).sendKeys("Password");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Step 9
		Reporter.log("Click Save");
		driver.findElement(By.xpath("//input [@id ='btnSave']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//espera.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("input [contains (text (), 'Succesfully Saved')]")));
		
		//Step 10
		Reporter.log("Search username in field Username");
		driver.findElement(By.xpath("//input [@id ='searchSystemUser_userName']")).sendKeys("Sofia Sepulveda");
		
		//Step 11
		Reporter.log("Click Search");
		driver.findElement(By.xpath("//input [@id ='searchBtn']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Step 12
		Reporter.log("Verify username exist in table");
		String Name = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
		Assert.assertEquals(Name, "Sofia Sepulveda");
		
		
		//Step 13
		Reporter.log("Log out");
		driver.findElement(By.xpath("//a [@id ='welcome']")).click();
		driver.findElement(By.xpath("//a [contains (text(),  'Logout')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Step 14
		Reporter.log("Close Browser");
		driver.close();
			
	}

	@AfterTest
	public void afterTest() {
	}

}

