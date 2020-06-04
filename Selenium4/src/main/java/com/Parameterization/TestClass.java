package com.Parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;     
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {
	public static WebDriver driver;
	public static WebDriverManager manager;

	String path = "D:\\Workspace_NRDA\\Selenium4\\src\\java\\resource\\testdata.xlsx";

	Xls_Reader reader = new Xls_Reader(path);

	@SuppressWarnings("static-access")
	@Test
	public void test() {

		manager.chromedriver().arch32().version("72.0").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String prodName = reader.getCellData("Product_Name", "ProductName", 2);

		driver.findElement(By.cssSelector("input[class*='search']")).sendKeys(prodName);

	}
}
