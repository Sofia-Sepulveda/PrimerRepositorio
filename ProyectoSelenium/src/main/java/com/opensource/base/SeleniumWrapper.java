package com.opensource.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

//NIVEL 3
public class SeleniumWrapper {

	private WebDriver driver;

//	Constructor SeleniumWrapper
	public SeleniumWrapper(WebDriver driver) {
		this.driver = driver; // this para que tome la propiedad de arriba si no no va saber de donde

	}

// Metodo Chrome Driver Connection
	public WebDriver chromeDriverConnection() {
		System.setProperty(GlobalVariables.CHROME_DRIVER, GlobalVariables.PATH_CHROME_DRIVER);
		driver = new ChromeDriver();
		return driver;
	}

	// Metodo para el Launch Browser
//	@author  Sofia Sepulveda
//	@date
//	@param
//	@return
	public void launchBrowser(String url) { // Aqui lo mande como variable y no como el chromeDriverConnection para
											// poder reutilizar el metodo con otras URLs
		reporterLog("Launching... " + url);
		driver.get(url);
		driver.manage().window().maximize();
		takeScreenshot("OpenBrowser");
		implicitWait(5);
	}

//Metodo Reporter log
	public void reporterLog(String log) {
		Reporter.log(log);
	}

	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	// Metodo FindElement
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	// Metodo Type
	public void type(By locator, String inputText, String description) {
		System.out.println("Typing text: " + inputText + " " + description);
		driver.findElement(locator).sendKeys(inputText);
	}

	// Metodo del clic
	public void click(By locator, String description) {
		System.out.println("Clicking.. " + description);
		driver.findElement(locator).click();
	}

//Metodo Wait for element Present
	public void waitForElementPresent(By locator, int timeout) {
		try { // intenta esto si algo de aqui falla, vete a cath
			WebDriverWait espera = new WebDriverWait(driver, timeout);
			espera.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
		}
	}

//Metodo Get Text
	public String getText(By locator) {
		try {
			return driver.findElement(locator).getText();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

//Metodo Assertion
	public void assertEquals(String actualValue, String expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			Assert.fail("Not able to assert Actual value: " + actualValue + "Expected Value: " + expectedValue);
		}
	}

	// Metodo Assertion con Boolean
	// @Sofia
	public void assertEquals(boolean actualValue, boolean expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			Assert.fail("Not able to assert Actual value: " + actualValue + "Expected Value: " + expectedValue);
		}
	}

//Metodo CloseBrowser
	public void closeBrowser() {
		try {
			reporterLog("Close Browser");
			driver.close();
		} catch (NoSuchSessionException e) {
			Assert.fail("Not Able to Close Browser");
		}
	}

	// Metodo obtiene el valor de la tabla de seacrh user
	public String getValueFromTable(String row, String column) {
		reporterLog("Get value from table");
		String valueTable = driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[" + column + "]")).getText();
		return valueTable;
	}

	// Metodo para Buscar en toda la tabla por fila
	// @Sofia PODER JUNTAR EN UNA SOLA CON EL ANTERIOR
	public boolean getValuesFromTable(By locatorTable, String column, String wantedValue) {
		reporterLog("Validate in Table");
		List<WebElement> rowCount = driver.findElements(locatorTable);
		int totalRows = rowCount.size();
		boolean exists = true;
		int row = 1;
		String numRow = "1";
		do {
			String valueTable = getValueFromTable(numRow, column);
			if (valueTable.equals(wantedValue)) {
				exists = true;
			} else {
				exists = false;
				row++;
				numRow = String.valueOf(row);
			}
		} while (row <= totalRows && exists != true);

		return exists;

	}

	// Metodo obtiene el valor de elementos class
	// @Sofia
	public String getValueFromElement(By locator) {
		reporterLog("Get Value From Class");
		String valuePopUp = driver.findElement(locator).getText();
		return valuePopUp;
	}

	// Metodo Obtiene numero de filas de una tabla
	// @Sofia
	public int getRowsFromTable(String locator) {
		reporterLog("Get Rows From Table");
		List<WebElement> rowCount = driver.findElements(By.xpath(locator));
		int totalRows = rowCount.size();
		return totalRows;
	}

	// Seleccionar valor de lista
	public void selectValueFromList(By locator, String option) {
		reporterLog("Select Value from List");
		Select list = new Select(driver.findElement(locator));
		list.selectByVisibleText(option);
		System.out.println("Select from list the value " +option);
	}

//Metodo Cambiar al   popup
	// No se ha usado
//	public String switchtoPopUp () {
//		Alert alert = driver.switchTo().alert();
//		String textAlert   =alert.getText();
//		return  textAlert;
//	}

	// JSON VIEJITO

//		/**
//		 * Get Data from JSON file (1 Node)
//		 * 
//		 * @author Ricardo Avalos
//		 * @param jsonFile, jsonObjName, jsonKey
//		 * @return jsonValue
//		 * @throws FileNotFoundException
//		 */
//		public String getJSONValue(String jsonFile, String jsonObjName, String jsonKey) throws FileNotFoundException {
//			try {
//	 
//				// JSON Data
//				InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFile + ".json");
//				JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));
//	 
//				// Get Data
//				String jsonValue = (String) jsonObject.getJSONObject(jsonObjName).get(jsonKey);
//				return jsonValue;
//	 
//			} catch (FileNotFoundException e) {
//				Assert.fail("JSON file is not found");
//				return null;
//			}
//		}

	/*
	 * Get Value from Excel
	 * 
	 * @author Ricardo Avalos
	 * 
	 * @date 02/18/2021
	 */
	public String getCellData(String excelName, int row, int column) {
		try {
			// Reading Data
			FileInputStream fis = new FileInputStream(GlobalVariables.PATH_EXCEL_DATA + excelName + ".xlsx");
			// Constructs an XSSFWorkbook object
			@SuppressWarnings("resource")
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row rowObj = sheet.getRow(row);
			Cell cell = rowObj.getCell(column);
			String value = cell.getStringCellValue();
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
	}

	/**
	 * Get Data from JSON file (Directly)
	 * 
	 * @author Ricardo Avalos
	 * @param jsonFile, jsonKey
	 * @return jsonValue
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFileObj, String jsonKey) throws FileNotFoundException {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}

	/*
	 * Take screenshot
	 * 
	 * @author Ricardo Avalos
	 * 
	 * @throws IOException
	 */
	public void takeScreenshot(String fileName) {
		try {
			Screenshot screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(GlobalVariables.PATH_SCREENSHOTS + fileName + ".png"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
