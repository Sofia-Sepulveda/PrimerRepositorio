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

public class TC005_Admin_CreateUserDisabled_POM {
WebDriver driver;
SeleniumWrapper seleniumwrapper;
Login login;
UserManagement usermanagement;
AddUser adduser;
String user;
String password;
String employeeName;
String userName;
String passwordUser;

	
	@BeforeTest
	  public void beforeTest() {
		seleniumwrapper = new SeleniumWrapper(driver);
		driver = seleniumwrapper.chromeDriverConnection();
		login = new Login(driver);
		usermanagement = new UserManagement(driver);
		adduser = new AddUser (driver);
		this.user= seleniumwrapper.getCellData("TC001_Admin_SearchEmployee_POM", 1, 0);
		this.password = seleniumwrapper.getCellData("TC001_Admin_SearchEmployee_POM", 1, 1);
		this.employeeName =  seleniumwrapper.getCellData(this.getClass().getSimpleName(), 1, 0);
		this.userName = seleniumwrapper.getCellData(this.getClass().getSimpleName(), 1, 1);
		this.passwordUser = seleniumwrapper.getCellData(this.getClass().getSimpleName(), 1, 2);
		
	  }
	
	@Test
  public void TC005_Admin_CreateUserDisabled_POM_TC() {
		
		//Step 1
		seleniumwrapper.launchBrowser(GlobalVariables.QA_URL);
		
		//Step  2
		login.loginOrange(user, password);
		
		//Step 3
		usermanagement.validateLogged();
		
		//Step 4
		usermanagement.clickAdmin();
		
		//Step 5
		usermanagement.clickAdd();
		
		//Step 6
		adduser.enterEmployeeName(employeeName);
		
		//Step 7
		adduser.enterUserName(userName);
		
		//Step 8
		adduser.userStatus("Disabled");
		
		//Step 9
		adduser.enterPassword(passwordUser);
		adduser.confirmPassword(passwordUser);
		
		//Step 10
		adduser.clickSave();
		
		//Step 11
		//Step 12
		usermanagement.searchUser(userName, true);
		
		//Step 13
		usermanagement.searchInResultsTable("5", "Disabled", true);
		
		//Step 14
		login.logoutOrange();
  }


  @AfterTest
  public void afterTest() {
	  seleniumwrapper.closeBrowser();
  }

}
