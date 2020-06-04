package com.greenkart;

import java.util.logging.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.utils.Base;

public class NumberOfItemDecremented extends Base {
	Logger log = Logger.getLogger("devpinoyLogger");
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 20);
	int height;
	int width;

	// using + buttons
	@FindBy(how = How.CSS, using = "a.decrement")
	private WebElement decrement;

	public void ItemEnteredDecrement() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(decrement));
		Assert.assertTrue(decrement.isDisplayed());
		HighlightOnElement(decrement);
		Assert.assertTrue(decrement.isEnabled());
		wait.until(ExpectedConditions.elementToBeClickable(decrement));

		for (int dcr = 2; dcr <= 4; dcr++) {
			decrement.click();
			Thread.sleep(3000);
		}
		System.out.println(driver.getTitle());
	}

}
