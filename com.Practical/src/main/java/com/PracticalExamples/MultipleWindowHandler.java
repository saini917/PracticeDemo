package com.PracticalExamples;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandler {

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
	public void testOpenMultipleWindow() throws InterruptedException {
		WebElement openBrowser = driver.findElement(By.cssSelector("#openwindow"));
		openBrowser.click();
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String parent = itr.next();
			System.out.println("Parent window: " + parent);

			String child = itr.next();
			System.out.println("Child window: " + child);

			if (child != parent) {
				driver.switchTo().window(child);
				System.out.println("child window url: " + driver.getCurrentUrl());
				System.out.println("child window title: " + driver.getTitle());
				driver.close();
			}
			driver.switchTo().window(parent);
			System.out.println("parent window url: " + driver.getCurrentUrl());
			System.out.println("parent window title: " + driver.getTitle());
			WebElement drop = driver.findElement(By.cssSelector("#dropdown-class-example"));
			Select sel = new Select(drop);

			List<WebElement> dropi = sel.getOptions();
			int size = dropi.size();
			for (int i = 1; i < size; i++) {
				if (sel != null) {
					String value = dropi.get(i).getAttribute("value");
					System.out.println(value);
					sel.selectByIndex(i);
				}
			}
			Thread.sleep(3000);
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
