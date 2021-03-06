package com.greenkart;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utils.Base;

public class ProceedToCheckout extends Base{

	Logger log = Logger.getLogger("devpinoyLogger");
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 20);
	int height;
	int width;

	@FindBy(how = How.CSS, using = "div.cart-preview>div.action-block>button")
	private WebElement checkout;
	
	public void clickOnCheckout() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOf(checkout));
		Assert.assertTrue(checkout.isDisplayed());
		HighlightOnElement(checkout);
		Assert.assertTrue(checkout.isEnabled());
		wait.until(ExpectedConditions.elementToBeClickable(checkout));
		checkout.click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
	}
	
	
}
