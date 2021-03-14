package com.opensource.admin.qa;

import org.testng.annotations.Test;

import com.opensource.admin.AddUser;
import com.opensource.admin.Login;
import com.opensource.admin.UserManagement;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class TC004_Admin_DeleteUser_POM {
	  WebDriver driver;
	  SeleniumWrapper seleniumWrapper;
	  UserManagement userManagement;
	  AddUser addUser;
	  Login login;
	  String username;
	  String password;
	  String employeeName;
	  String employeeUserName;
	  String employeePassword;
	  

  @BeforeTest
  public void beforeTest() throws FileNotFoundException {
	  seleniumWrapper =new SeleniumWrapper(driver);
	  driver = seleniumWrapper.chromeDriverConnection();
	  login = new Login(driver);
	  userManagement = new UserManagement(driver);
	  addUser = new AddUser(driver);
	  	  
	  this.username = seleniumWrapper.getCellData("TC001_Admin_SearchEmployee_POM", 1, 0);
	  this.password = seleniumWrapper.getCellData("TC001_Admin_SearchEmployee_POM", 1, 1);
	  this.employeeName = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 0);
	  this.employeeUserName =  seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 1);
	  this.employeePassword= seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 2);
	  
  }
  
  @Test
  public void TC004_Admin_DeleteUser_POM_TC() {
	  
	  //Precondición agregar un nuevo usuario
	  seleniumWrapper.launchBrowser(GlobalVariables.QA_URL);
	  login.loginOrange(username, password);
	  userManagement.clickAdmin();
	  userManagement.clickAdd();
	  addUser.enterEmployeeName(employeeName);
	  addUser.enterUserName(employeeUserName);
	  addUser.enterPassword(employeePassword);
	  addUser.confirmPassword(employeePassword);
	  addUser.clickSave();
	  login.logoutOrange();
	 // seleniumWrapper.closeBrowser();
	  
	  //Step  1 Open explorer
	//  seleniumWrapper.launchBrowser(GlobalVariables.QA_URL);
	  
	  //Step 2
	  login.loginOrange(username, password);
	  
	  //Step 3
	  userManagement.validateLogged();
	  
	  //Step 4
	  userManagement.clickAdmin();
	  
	  //Step 5 and Step 6
	  userManagement.searchUser(employeeUserName, true);
	  
	  //Step 7
	  userManagement.validateFromSearchTable("1", "2", employeeUserName);
	  
	  //Step 8
//	  userManagement.selectUserbyRowColumn("1", "2");
	  userManagement.selectUserTable();
	  
	  //Step 9
	  userManagement.deleteUser();
	  
	  //Step 10
	  userManagement.validateDeleteMessage("Delete records?");
	  
	  //Step 11
	  userManagement.confirmDelete();
	  
	  //Step 12
	  userManagement.searchInResultsTable("2", employeeUserName, false);
	  
	  //Step 13
	  login.logoutOrange();
	  	
  }

  @AfterTest
  public void afterTest() {
	  seleniumWrapper.closeBrowser();
  }

}
