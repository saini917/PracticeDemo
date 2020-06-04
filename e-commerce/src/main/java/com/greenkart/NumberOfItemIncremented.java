package com.greenkart;

import java.util.logging.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.utils.Base;

public class NumberOfItemIncremented extends Base {

	Logger log = Logger.getLogger("devpinoyLogger");
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 20);
	int height;
	int width;

	// using + buttons
	@FindBy(how = How.CSS, using = "a.increment")
	private WebElement increment;

	public void ItemEnteredUsingPlus() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(increment));
		Assert.assertTrue(increment.isDisplayed());
		HighlightOnElement(increment);
		Assert.assertTrue(increment.isEnabled());
		wait.until(ExpectedConditions.elementToBeClickable(increment));

		for (int incr = 2; incr <= 4; incr++) {
			increment.click();
			Thread.sleep(3000);
		}
		System.out.println(driver.getTitle());

	}
}
