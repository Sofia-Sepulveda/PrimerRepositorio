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
	By tbl_firstColumnSerch= By.xpath("//tbody/tr[1]/td[1]");
	By link_add = By.xpath("//input [@id ='btnAdd']");
	By chbx_user =By.xpath("//input [@id = 'ohrmList_chkSelectAll']");
	By btn_delete = By.xpath("//input [@id ='btnDelete']");
	By div_delete = By.xpath("//div [@id ='deleteConfModal']");
	By class_delete =By.xpath("//div [@id ='deleteConfModal']//p"); 
	By btn_ok_delete= By.xpath("//input[@id='dialogDeleteBtn']");
	By tbl_Search = By.xpath ("//table[@id='resultTable']/tbody/tr");


	//Metodo Validar que estas logueado
	public void validateLogged () {
		reporterLog("Validate that you have logged in successfully");
		takeScreenshot("ValidateMainPage");
		waitForElementPresent (link_admin, 10);
	}
	
	//Metodo ClicAdmin
	public void clickAdmin () {
		reporterLog ("Click Admin - Go to the admin page");
		click(link_admin, "Click to button Admin");
		implicitWait(10);
		takeScreenshot("AfterClickAdmin");
	}
	
	//Metodo SearchUser
	public void searchUser (String user, boolean clickSearch) {
		reporterLog ("Search username in field Username");
		type (txt_search_user, user, "Search field");
		takeScreenshot("AfterType  "+user );
		if (clickSearch) { //ponemos un IF para considerar que en este metodo se le puede o no dar clic por si despues  crece
			click(btn_search, "Button Search");
		}
		implicitWait(10);
	}
	
	//Metodo Verificar Resultados
	public void validateFromSearchTable (String row, String column, String expectedValue) {
		reporterLog ("Verify value in search table");
		String actualValue = getValueFromTable (row, column);
		assertEquals (actualValue, expectedValue);
		takeScreenshot("Results");
	}
	
	//Metodo para buscar en toda la tabla por fila
	public void searchInResultsTable (String column, String value, boolean expected_exists) {
		reporterLog ("Search in table Results");
		boolean result =  getValuesFromTable(tbl_Search, column, value);
		assertEquals(result, expected_exists);
		takeScreenshot("Results");
		implicitWait(10);
	}
	
	//Metodo Verificar  no resultados
	//@Sofia CORREGIR
	public void validateNoResultsSearchTable (String expectedValue) {
		reporterLog ("Verify value in search table");
		String actualValue = getText(tbl_firstColumnSerch);
		assertEquals (actualValue, expectedValue);
	}
	
	// Metodo ClickAdd
	public void clickAdd() {
		reporterLog("Click Add");
		click(link_add, "Add Button");
		implicitWait(10);
	}
	
	//Metodo Select From Table
	//No se puede seleccionar el checkbox
//	public void selectUserbyRowColumn(String row, String column) {
//		reporterLog("Select  User From Table");
//		By valueTable = getElementFromTable(row, column);
//		click(valueTable, "SelectUser");
//		takeScreenshot("Select User");
//	}
	
	//Metodo para seleccionar usuario de table
	public void selectUserTable () {
		reporterLog("Select User From Table");
		click(chbx_user,"Select user from table");
		takeScreenshot("Select User");
	}
	
	public void deleteUser () {
		reporterLog ("Click Delete user");
		click(btn_delete, "Select Delete button");
		waitForElementPresent (div_delete, 10);
		takeScreenshot("Pop up Delete");
	}
	//Metodo Verificar popup delete
	public void validateDeleteMessage (String expectedValue) {
		reporterLog ("Verify Popup Delete");
		String actualValue = getValueFromElement(class_delete);
		assertEquals (actualValue, expectedValue);
		takeScreenshot("Results");
	}
	
	//Metodo click Delete ok
	public void confirmDelete () {
		reporterLog("Click OK in Delete message");
		click(btn_ok_delete, "Confirm delete");
		implicitWait(10);
	}
	

	
	
			
}
