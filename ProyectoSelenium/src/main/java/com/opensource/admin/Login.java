package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.opensource.base.SeleniumWrapper;

//NIVEL 2
//Va por pantallas. Pantalla  1 Login
//SeleniumWrapper es la padre de todas las clases
//Los constructores no se heredan por lo que hay que crear  uno
public class Login extends SeleniumWrapper {

	//Constructor para instanciar el objeto de seleniumwrapper o sea el driver
	public Login(WebDriver driver) {
		super(driver);   //Super que voy a traer el valor de driver dentro de mi constructor
	
	}
	//En nivel 2 viven objetos. Los objetos de la pantalla Login 
	// para el nombre de los objetos usar convenction, guiarse por pagina http://makeseleniumeasy.com/2018/07/29/best-practises-in-page-object-model-naming-conventions-of-web-elements-actions-on-it/
	By txt_username =  By.xpath("//input[@id='txtUsername']");
	By txt_password = By.xpath("//input[@id='txtPassword'] ");
	By btn_login = By.xpath("//input[@id='btnLogin']");
	By btn_welcome = By.xpath("//a[@id='welcome']");
	By btn_logout  = By.xpath("//a[contains(text(), 'Logout')]");
	
	//En el nivel 2 tambien viven metodos
	
	
	//Metodo LoginOpenSourse
	public void loginOrange (String username, String password) {
		reporterLog("Login into Orange OpenSource");
		waitForElementPresent (txt_username, 10);
		type (txt_username, username, "UserName textfield");
		type (txt_password, password, "Password textfield");
		click(btn_login, "Button Login");
		implicitWait(5);
	}
	
	//Metodo LogOut
	public  void logoutOrange () {
		reporterLog("Logout into Orange OpenSource");
		click(btn_welcome, "Welcome Button ");
		click(btn_logout, "Logout Button");
		takeScreenshot("Logout");
		implicitWait(5);
	}
	

}
