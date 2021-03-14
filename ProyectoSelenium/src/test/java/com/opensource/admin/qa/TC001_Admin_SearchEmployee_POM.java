package com.opensource.admin.qa;
import java.io.FileNotFoundException;

//Nivel 1
//Llamados
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.Login;
import com.opensource.admin.UserManagement;
import com.opensource.base.GlobalVariables;
import com.opensource.base.SeleniumWrapper;

public class TC001_Admin_SearchEmployee_POM {
//Cada Test Script tiene que tener su Driver sobre todo por Multithread
	WebDriver driver;
	SeleniumWrapper seleniumWrapper;
	Login login;
	UserManagement userManagement;
	String username;
	String password;
	
	
	@BeforeTest
	public void beforeTest() throws FileNotFoundException {
		//Clase SeleniumWrapper, Objeto seleniumWrapper, new para instanciar y constructor()
		seleniumWrapper = new SeleniumWrapper(driver); //Instanciar. poner lo de constructor
		driver = seleniumWrapper.chromeDriverConnection();
		login = new Login(driver);
		userManagement = new UserManagement(driver);
		//Ya tenemos nuestros objetos
		
//		DatosEnDuro
//		username  ="Admin";
//		password  = "admin123";
		
		
//		EXCEL
//		this.username = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 0);
//		this.password = seleniumWrapper.getCellData(this.getClass().getSimpleName(), 1, 1);
		
//		JSON
		this.username = seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "username");
		this.password = seleniumWrapper.getJSONValue(this.getClass().getSimpleName(), "password");
	}

	@Test
	public void TC001_Admin_SearchEmployee_POM_TestScript() {

		
		//Step  1
		seleniumWrapper.launchBrowser(GlobalVariables.QA_URL);
		
		// Step 2
		login.loginOrange(username, password);
		
		//Step 3
		userManagement.validateLogged();
		
		//Step 4
		userManagement.clickAdmin();
		
		//Step 5  and Step 6
		userManagement.searchUser(username, true);
		
		//Step 7
		userManagement.validateFromSearchTable("1", "2", username);
		
		//Step 8
		login.logoutOrange();
		
	
	}

	@AfterTest
	public void afterTest() {
		//Metodo cerrar Ventana Pase lo quepase siempre tiene que cerrar el browser
		
		//Step 9
		seleniumWrapper.closeBrowser();
	}

}
