package com.PracticalExamples;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertExample {

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
	public void testAlertText() throws InterruptedException {
		WebElement names = driver.findElement(By.cssSelector("#name"));
		names.sendKeys("deepak saini");

		WebElement alert = driver.findElement(By.cssSelector("#alertbtn"));
		alert.click();

		String text = driver.switchTo().alert().getText();
		System.out.println("Alert text: " + text);

		assertEquals("Hello deepak saini, share this practice page and share your knowledge", text);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void testAlert() throws InterruptedException {
		WebElement namess = driver.findElement(By.cssSelector("#name"));
		namess.sendKeys("sia saini");

		WebElement confirm = driver.findElement(By.cssSelector("#confirmbtn"));
		confirm.click();

		String text = driver.switchTo().alert().getText();
		System.out.println("Alert text: " + text);

		if (text.equals("Hello sia saini, Are you sure you want to confirm?")) {
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
		} else {
			driver.switchTo().alert().dismiss();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
