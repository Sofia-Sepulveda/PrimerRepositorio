package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.SeleniumWrapper;

// Nivel 2 Pagina de Admin
public class UserManagement extends SeleniumWrapper {

	
	
	public UserManagement(WebDriver driver) {
		super(driver);
		
	}
	//Objetos
	By link_admin = By.xpath("//a[@id='menu_admin_viewAdminModule'] "); //es link en lugar de boton porque cambia la url
	By txt_search_user = By.xpath("//input[@id='searchSystemUser_userName']");
	By btn_search  =  By.xpath("//input[@id='searchBtn']");
	By tbl_firstRowSerch = By.xpath("//tbody/tr[1]/td[2]");


	//Metodo Validar que estas logueado
	public void validateLogged () {
		reporterLog("Validate that you have logged in successfully");
		waitForElementPresent (link_admin, 10);
	}
	
	//Metodo ClicAdmin
	public void clickAdmin () {
		reporterLog ("Click Admin - Go to the admin page");
		click(link_admin, "Click to button Admin");
		implicitWait(10);
	}
	
	//Metodo SearchUser
	public void searchUser (String user, boolean clickSearch) {
		reporterLog ("Search username in field Username");
		type (txt_search_user, user, "Search field");
		if (clickSearch) { //ponemos un IF para considerar que en este metodo se le puede o no dar clic por si despues  crece
			click(btn_search, "Button Search");
		}
		implicitWait(10);
	}
	
	//Metodo Verificar Resultados
	public void validateFromSearchTable (String expectedValue) {
		reporterLog ("Verify value in search table");
		String actualValue = getText(tbl_firstRowSerch);
		assertEquals (actualValue, expectedValue);
	}
	
}
