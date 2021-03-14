package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.SeleniumWrapper;

public class AddUser extends SeleniumWrapper {
	By txt_employeeName  = By.xpath("//input [@id ='systemUser_employeeName_empName']");
	By txt_userName = By.xpath("//input [@id ='systemUser_userName']");
	By txt_password = By.xpath("//input [@id ='systemUser_password']");
	By txt_confirmPassword = By.xpath("//input [@id ='systemUser_confirmPassword']");
	By link_save = By.xpath("//input [@id ='btnSave']");
	By slct_status = By.xpath("//select [@id = 'systemUser_status']");

	//Constructor
	public AddUser(WebDriver driver) {
		super(driver);
	}

	
	//Metodo ingresar EmployeeName
	public void enterEmployeeName(String employeeName) {
		reporterLog("Enter EmployeeName");
		type(txt_employeeName, employeeName, "Type EmployeeName");
		takeScreenshot("Enter EmployeeName");
		
	}
	
	//Metodo ingresar UserName
	public void enterUserName(String userName) {
		reporterLog("Enter UserName");
		type(txt_userName, userName, "Type UserName");
		takeScreenshot("Enter UserName");
	}
	
	//Metodo ingresar Contraseña
	public void enterPassword(String password) {
		reporterLog("Enter Password");
		type(txt_password, password, "Type Password");
		takeScreenshot("Enter Password");
	}
	
	//Metodo confirmar Contraseña
	public void confirmPassword(String password) {
		reporterLog("Confirm Password");
		type(txt_confirmPassword, password, "Type Confirm Password");
		takeScreenshot("Confirm Password");
	}
	
	public void clickSave() {
		reporterLog("Save Button");
		click(link_save, "Click Button");
		implicitWait(15);
	}
	
	//Metodo StatusUser
	public void userStatus(String status) {
		reporterLog ("Select User Status");
		selectValueFromList (slct_status, status);
		takeScreenshot("Estatus");
	}

}
