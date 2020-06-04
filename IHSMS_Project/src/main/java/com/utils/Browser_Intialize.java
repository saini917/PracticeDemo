package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Intialize  extends CommonLib  implements ConstantVaribale {

	public static WebDriverManager manager;

	/*
	 * @SuppressWarnings({ "static-access", "unused" }) public static WebDriver
	 * launchBrowser(GlobalVariables browserName) {
	 * 
	 * if (browserName == GlobalVariables.Chrome) {
	 * manager.chromedriver().arch32().version("72.0").setup(); driver = new
	 * ChromeDriver(); }
	 * 
	 * if (browserName == GlobalVariables.firefox) {
	 * manager.firefoxdriver().arch64().version("0.23.0").setup(); driver = new
	 * FirefoxDriver(); }
	 * 
	 * if (browserName == GlobalVariables.ie) {
	 * manager.iedriver().arch32().version("3.150").setup(); driver = new
	 * InternetExplorerDriver(); } else { System.out.println(
	 * "incorrect browser name passed!"); } return driver;
	 * 
	 * }
	 */

	@SuppressWarnings({ "static-access", "unused" })
	protected static WebDriver launchBrowser(EnumGlobalVariables browserName) 
		{
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
	}


