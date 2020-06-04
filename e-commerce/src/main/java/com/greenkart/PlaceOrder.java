package com.greenkart;


import java.util.logging.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utils.Base;

public class PlaceOrder extends Base {

	Logger log = Logger.getLogger("devpinoyLogger");
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 20);
	int height;
	int width;

	@FindBy(how = How.CSS, using = "div.products>div>div+b")
	private WebElement noOfItem;

	@FindBy(how = How.CSS, using = "div.products>div>span.totAmt")
	private WebElement totalAmt;

	@FindBy(how = How.CSS, using = "div.products>div>span.discountPerc")
	private WebElement discount;

	@FindBy(how = How.CSS, using = "div.products>div>span.discountAmt")
	private WebElement afterDiscount;

	public void onPlaceOrder() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(noOfItem));
		Assert.assertTrue(noOfItem.isDisplayed());
		HighlightOnElement(noOfItem);
		Assert.assertTrue(noOfItem.isEnabled());
		wait.until(ExpectedConditions.visibilityOf(noOfItem));
		System.out.println("Number of Item: " + noOfItem.getText());
		
		
		wait.until(ExpectedConditions.visibilityOf(totalAmt));
		Assert.assertTrue(totalAmt.isDisplayed());
		HighlightOnElement(totalAmt);
		Assert.assertTrue(totalAmt.isEnabled());
		wait.until(ExpectedConditions.visibilityOf(totalAmt));
		String TotalAmount = totalAmt.getText();
		System.out.println("Total Amount: " + TotalAmount);

		wait.until(ExpectedConditions.visibilityOf(discount));
		Assert.assertTrue(discount.isDisplayed());
		HighlightOnElement(discount);
		Assert.assertTrue(discount.isEnabled());
		wait.until(ExpectedConditions.visibilityOf(discount));
		String Discount = discount.getText();
		System.out.println("Discount: " + Discount);

		wait.until(ExpectedConditions.visibilityOf(afterDiscount));
		Assert.assertTrue(afterDiscount.isDisplayed());
		HighlightOnElement(afterDiscount);
		Assert.assertTrue(afterDiscount.isEnabled());
		wait.until(ExpectedConditions.visibilityOf(afterDiscount));
		String TotalAfterDiscount = afterDiscount.getText();
		System.out.println("Total After Discount: " + TotalAfterDiscount);

	}

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Place Order')]")
	private WebElement order;
	
	public void clickOnPlaceOrder(){
		wait.until(ExpectedConditions.visibilityOf(order));
		Assert.assertTrue(order.isDisplayed());
		HighlightOnElement(order);
		Assert.assertTrue(order.isEnabled());
		wait.until(ExpectedConditions.visibilityOf(order));
		order.click();
	}
	
}
