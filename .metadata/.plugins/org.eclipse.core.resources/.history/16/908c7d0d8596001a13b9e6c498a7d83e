package com.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base implements Constant{
	public static WebDriver driver;
	public static WebDriverManager manager;

	@SuppressWarnings("static-access")
	public static WebDriver initializeDriver(BrowserVariable browserName) {
			switch (browserName) {
			case Chrome:
				manager.chromedriver().arch32().version("72.0").setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			case firefox:
				manager.firefoxdriver().arch64().version("0.23.0").setup();
				driver = new FirefoxDriver();
				break;

			case ie:
				manager.iedriver().arch32().version("3.150").setup();
				driver = new InternetExplorerDriver();
				break;

			default:
				Reporter.log("incorrect browser name passed");
				break;
			}
			return driver;
		}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	
	public static String getScreenshotPath(String TestCaseName,WebDriver driver){
		String path= System.getProperty("user.dir")+ "\\reports\\"+ TestCaseName +" .png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	/****************************************************************************
	 * Purpose:Highlight the element to visible at time of Execution
	 * @Author:DEEPAK.SAINI
	 * @param:By element
	 ***************************************************************************/
	public static void HighlightOnElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
				"color: blue; border: 2px solid Magenta;");
	}
	

}
