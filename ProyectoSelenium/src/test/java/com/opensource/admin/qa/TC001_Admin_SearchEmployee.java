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
import org.testng.asserts.SoftAssert;

public class TC001_Admin_SearchEmployee {
	
	  @BeforeTest
	  public void beforeTest() {
		  
		  //DATOS
	  }
	  
  @Test
  public void TC001_Admin_SearchEmployee_TC () {
	 
	  //Step 1
	  Reporter.log("Open Browser\"OrangeHRM\" web page");  //Manda un reporte a test NG que paso esta haciendo y resulta
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/Driver/Chrome/chromedriver.exe"); //Setear   driver;Dirección de donde esta el driver
	  WebDriver driver = new ChromeDriver();  //Polimorfismo. Aqui podría ser el Mozilla 
	  driver.get("https://opensource-demo.orangehrmlive.com/"); //launch del chrome
	  driver.manage().window().maximize(); //maximizar pantalla
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  
	  //Step 2
	  Reporter.log("Enter Username and Password");
	  driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@id='txtPassword'] ")).sendKeys("admin123"); //el password debe estar encriptado
	  driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  // Step 3
	  Reporter.log("Validate that you have logged in successfully");
	  WebDriverWait wait =new WebDriverWait (driver,30);  //AVERIGUAR PARA QUE ES ESTA LINEA
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_admin_viewAdminModule'] ")));//esperar hasta que se vea el elemento
	  
	  //Step 4
	  Reporter.log("Click Admin - Go to the admin page");
	  driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule'] ")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  //Step 5
	  Reporter.log("Search username in field Username");
	  driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("Admin");
	  
	  //Step 6
	  Reporter.log("Click Search");
	  driver.findElement(By.xpath("//input[@id='searchBtn'] ")).click();
	  
	  //Step 7
	  Reporter.log("Verify username exist in table");
	  String actualUserName = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();//Tabla dividirportd tr td
	  //Assert.assertEquals(actualUserName, "Admin");
	  
	  SoftAssert soft = new SoftAssert();
	  soft.assertEquals(actualUserName, "Admon");
	  
	  //Step 8
	  Reporter.log("Log out");
	  driver.findElement(By.xpath("//a[@id='welcome']")).click();
	  driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click(); //Como no  tiene un ID, usas un contains para identificarlo
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
	  //Step 9
	  Reporter.log("Close Browser");
	  driver.close();
	  
	  soft.assertAll();
  }


  @AfterTest
  public void afterTest() {
  }

}
