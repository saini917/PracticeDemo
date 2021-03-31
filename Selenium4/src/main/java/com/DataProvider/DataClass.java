package com.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Parameterization.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataClass {
	public static WebDriver driver;
	public static WebDriverManager manager;

	String path = "D:\\Workspace_NRDA\\Selenium4\\src\\java\\resource\\testdata.xlsx";

	Xls_Reader reader = new Xls_Reader(path);

	@SuppressWarnings("static-access")

	@BeforeMethod
	public void setUp() {
		manager.chromedriver().arch32().version("72.0").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://www.edstaging.hp.gov.in/");
	}

	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtils.getDataFromExcel();
		return testData.iterator();
	}

	@Test(dataProvider="getTestData")
	public void test(String username, String password) {

		driver.findElement(By.cssSelector("#Header_lblLogin")).click();

		driver.findElement(By.cssSelector("#txtUserName")).clear();
		driver.findElement(By.cssSelector("#txtUserName")).sendKeys(username);

		driver.findElement(By.cssSelector("#txtPassword")).clear();
		driver.findElement(By.cssSelector("#txtPassword")).sendKeys(password);

	}

	@AfterMethod
	public void tesrDown() {
		driver.close();
	}

}