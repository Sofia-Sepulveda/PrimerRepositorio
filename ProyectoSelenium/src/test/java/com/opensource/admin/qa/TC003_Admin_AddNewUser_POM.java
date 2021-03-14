package com.opensource.admin.qa;

import org.testng.annotations.Test;

import com.opensource.admin.AddUser;
import com.opensource.admin.Login;
import com.opensource.admin.UserManagement;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TC003_Admin_AddNewUser_POM {
	WebDriver driver;
	SeleniumWrapper seleniumWrapper;
	Login login;
	UserManagement userManagement;
	AddUser addUser;
	String username;
	String  password;
	String employeeName;
	String employeeUsername;
	String userPassword;
	

	@BeforeTest
	public void beforeTest() {
		seleniumWrapper = new SeleniumWrapper(driver);
		driver = seleniumWrapper.chromeDriverConnection();
		login = new Login(driver);
		userManagement = new UserManagement(driver);
		addUser = new AddUser(driver);
		username="Admin";
		password="admin123";
		employeeName ="Jacqueline White";
		employeeUsername = "Sofia6";
		userPassword = "SofiaUno1!/";
	}

	@Test
	public void TC003_Admin_AddNewUser_POM_TestScript() {
		
		//Step 1
		seleniumWrapper.launchBrowser(GlobalVariables.QA_URL);
		
		//Step 2
		login.loginOrange(username, password);
		
		//Step 3
		userManagement.validateLogged();
		
		//Step 4
		userManagement.clickAdmin();
		
		//Step 5
		userManagement.clickAdd();
		
		//Step 6
		addUser.enterEmployeeName(employeeName);
		
		//Step 7
		addUser.enterUserName(employeeUsername);
		
		//Step 8
		addUser.enterPassword(userPassword);
		addUser.confirmPassword(userPassword);
		
		//Step 9
		addUser.clickSave();
		
		//Step 10
		//Step 11
		userManagement.searchUser(employeeUsername, true);
		
		//Step 12
		userManagement.validateFromSearchTable("1", "2", employeeUsername);
		
		//Step 13
		login.logoutOrange();
	}

	@AfterTest
	public void afterTest() {
		seleniumWrapper.closeBrowser();
	}

}
