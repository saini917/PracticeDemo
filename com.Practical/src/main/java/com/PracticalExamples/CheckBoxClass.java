package com.PracticalExamples;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxClass {
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
	public void testCheckBox() throws InterruptedException {

		List<WebElement> boxes = driver.findElements(By.cssSelector("[type='checkbox']"));
		int size = boxes.size();
		for (int i = 0; i < size; i++) {

			if (boxes.get(i).isDisplayed()) {
				if (boxes.get(i).isEnabled()) {
					for (int j = 0; j < size; j++) {
						if (boxes.get(i).isSelected()) {
							boxes.get(i).click();
						}
					}
				}
				boxes.get(i).click();
			}

		}
		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
