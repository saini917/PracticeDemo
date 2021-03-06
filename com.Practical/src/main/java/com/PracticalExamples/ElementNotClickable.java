package com.PracticalExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementNotClickable {
	WebDriver driver;
	WebDriverManager manager;
	String baseUrl = "https://www.crmpro.com/index.html?e=1";

	@SuppressWarnings("static-access")
	@BeforeMethod
	public void setUp() {
		manager.chromedriver().arch32().version("72.0").setup();
		driver = new ChromeDriver();
		driver.navigate().to(baseUrl);
		// driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void testClickable() throws InterruptedException {
		WebElement username = driver.findElement(By.cssSelector("[name='username']"));
		username.sendKeys("deepak");

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		/*WebElement loginbtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='submit']")));
		loginbtn.click();*/
		
		/*boolean invisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("preloader")));
		if (invisible) {
			WebElement loginbtn = driver.findElement(By.cssSelector("input[type='submit']"));
			loginbtn.click();
		}*/
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement loginbtn = driver.findElement(By.cssSelector("input[type='submit']"));
		js.executeScript("arguments[0].click()",loginbtn );
		
		

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
