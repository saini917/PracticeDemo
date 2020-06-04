package com.PracticalExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTableExample {
	WebDriver driver;
	WebDriverManager manager;

	@SuppressWarnings("static-access")
	@BeforeMethod
	public void setUp() {
		manager.chromedriver().arch32().version("72.0").setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
	}

	// table[@id='product']/tbody/tr[2]/td
	// table[@id='product']/tbody/tr[3]/td

	String before_xpath = "//table[@id='product']/tbody/tr[";
	String after_xpath = "]/td[2]";

	// method-1
	@Test(priority = 1)
	public void testWebtable() throws InterruptedException {
		for (int i = 2; i <= 11; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains("WebServices / REST API Testing with SoapUI")) {
				String names = driver.findElement(By.xpath("//table[@id='product']/tbody/tr[" + i + "]/td[3]"))
						.getText();
				System.out.println(names);
				break;
			}
		}

	}

	// method-2(customize xpath)
	@Test(priority = 2)
	public void testWebtable1() throws InterruptedException {
		String name = driver.findElement(By.xpath("//td[contains(text(),'QA Expert Course :Software Testing + Bugzilla + SQL + Agile')]/following-sibling::td")).getText();
		System.out.println(name);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
