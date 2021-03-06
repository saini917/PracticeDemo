package com.PracticalExamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownClass {
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

	@Test(priority = 1)
	public void testDropdown() throws InterruptedException {

		WebElement drop = driver.findElement(By.cssSelector("#dropdown-class-example"));
		Select sel = new Select(drop);

		List<WebElement> dropi = sel.getOptions();
		int size = dropi.size();
		for (int i = 1; i < size; i++) {
			if (sel != null) {
				String value=dropi.get(i).getAttribute("value");
				System.out.println(value);
				sel.selectByIndex(i);
			}
		}
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
