package com.opensource.admin.qa;

import org.testng.annotations.Test;

import com.opensource.admin.Login;
import com.opensource.admin.UserManagement;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TC002_Admin_SearchEmployee_NotExist_POM {
	WebDriver driver;
	SeleniumWrapper seleniumWrapper;
	UserManagement userManagement;
	Login login;
	String user;
	String password;
	

	@BeforeTest
	public void beforeTest() {
		seleniumWrapper = new SeleniumWrapper(driver);
		driver = seleniumWrapper.chromeDriverConnection();
		userManagement= new UserManagement(driver);
		login = new Login(driver);
		user = "Admin";
		password = "admin123";
	}

	@Test
	public void TC002_Admin_SearchEmployee_NotExist_POM_TestScript() {
		
		//Step 1
		seleniumWrapper.reporterLog("Open Browser");
		seleniumWrapper.launchBrowser(GlobalVariables.QA_URL);
		
		//Step 2
		login.loginOrange(user, password);
		
		//Step 3
		userManagement.validateLogged();
		
		//Step 4
		userManagement.clickAdmin();
		
		//Step  5
		//Step 6
		userManagement.searchUser("XYZ", true);
		
		//Step 7
		userManagement.validateNoResultsSearchTable("No Records Found");
		
		//Step 8
		login.logoutOrange();
	}

	@AfterTest
	public void afterTest() {
		
		//Step 9
		seleniumWrapper.closeBrowser();
	}

}
