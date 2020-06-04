package com.PracticalExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionBox {

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

	@Test(priority=1)
	public void testRadioButton() throws InterruptedException {

		WebElement suggestion = driver.findElement(By.cssSelector("input[id='autocomplete'][class='inputs ui-autocomplete-input']"));
		suggestion.sendKeys("deepaksaini");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}

}
