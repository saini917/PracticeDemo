package com.greenkart;

import java.util.logging.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.utils.Base;

public class AddToCart extends Base {

	Logger log = Logger.getLogger("devpinoyLogger");
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 20);
	int height;
	int width;
	Boolean staleElement = true;

	// using + buttons
	@FindBy(how = How.CSS, using = "div.product-action>button")
	private WebElement cart;

	public void addToCart() throws InterruptedException {

				wait.until(ExpectedConditions.visibilityOf(cart));
				Assert.assertTrue(cart.isDisplayed());
				HighlightOnElement(cart);
				Assert.assertTrue(cart.isEnabled());
				wait.until(ExpectedConditions.elementToBeClickable(cart));

				cart.click();
				System.out.println(driver.getTitle());
				Thread.sleep(3000);
			
	}

}
