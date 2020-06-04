package com.Parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterizeTest {

	public static WebDriver driver;
	public static WebDriverManager manager;
	
	String path = "D:\\Workspace_NRDA\\Selenium4\\src\\java\\resource\\testdata.xlsx";
	Xls_Reader reader = new Xls_Reader(path);
	
	@SuppressWarnings("static-access")
	@Test
	public void test1(){
		manager.chromedriver().arch32().version("72.0").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		int rowCount=reader.getRowCount("Product_Name");
		System.out.println("Total number of rows: "+rowCount);
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++){
			String prodName = reader.getCellData("Product_Name", "ProductName", rowNum);
			
			/*WebElement prods=driver.findElement(By.cssSelector("input[class*='search']"));
			prods.sendKeys(prodName);*/
			
			if(prodName.contains("Brinjal - 1 Kg")){
				WebElement prods=driver.findElement(By.cssSelector("input[class*='search']"));
				prods.sendKeys(prodName);
			}
			
			/*driver.findElement(By.cssSelector("button[type='submit']")).click();
			prods.clear();*/
			
		}

		
	}
}
