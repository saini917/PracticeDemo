package com.seleniumnewfeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
import java.util.Iterator;
import java.util.Set;

//https://www.youtube.com/watch?v=AwCcs1XqwfI

//Invoke multiple windows and tabs using one driver instance
public class MultipleWindowsTabs {
	WebDriverManager manager;
	WebDriver driver;

	@SuppressWarnings("static-access")
	@Test
	public void test() throws InterruptedException {
		manager.chromedriver().arch32().version("72.0").setup();
		driver = new ChromeDriver();
		
		/*manager.firefoxdriver().arch64().version("0.23.0").setup();
		driver = new FirefoxDriver();*/
		
		/*manager.iedriver().arch32().version("3.150").setup();
		driver = new InternetExplorerDriver();*/
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.TAB);

		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		String parentID = it.next();
		String childID = it.next();
		driver.switchTo().window(childID);
		driver.get("https://rahulshettyacademy.com/");
		driver.quit();
		driver.switchTo().window(parentID);
		WebElement nameEditbox = driver.findElement(By.cssSelector("[name='name']"));
		nameEditbox.sendKeys("deepak");
		System.out.println(driver.findElement(withTagName("label").above(nameEditbox)).getText());

	}

}
