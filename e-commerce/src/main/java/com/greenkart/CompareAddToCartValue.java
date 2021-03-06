package com.greenkart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utils.Base;

public class CompareAddToCartValue extends Base {
	
	@SuppressWarnings("deprecation")
	static WebDriverWait wait = new WebDriverWait(driver, 20);
	StringBuffer sb = new StringBuffer();
	
	
	@FindBy(how = How.CSS, using = "input.quantity")
	private WebElement numberOfItem;

	public StringBuffer addCartValue() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(numberOfItem));
		Assert.assertTrue(numberOfItem.isDisplayed());
		HighlightOnElement(numberOfItem);
		Assert.assertTrue(numberOfItem.isEnabled());
		numberOfItem.click();
		String count = numberOfItem.getAttribute("value");

		sb.append(count);
		return sb;

	}

	@FindBy(how = How.CSS, using = ".cart-icon>img")
	private WebElement cartBox;

	@FindBy(how = How.CSS, using = "a+div>div>div>ul.cart-items>li>div.product-total>p.quantity")
	private WebElement quantity;

	public StringBuffer getAddCartValue() {
		wait.until(ExpectedConditions.visibilityOf(cartBox));
		Assert.assertTrue(cartBox.isDisplayed());
		HighlightOnElement(cartBox);
		Assert.assertTrue(cartBox.isEnabled());
		cartBox.click();

		wait.until(ExpectedConditions.visibilityOf(quantity));
		Assert.assertTrue(quantity.isDisplayed());
		HighlightOnElement(quantity);
		Assert.assertTrue(quantity.isEnabled());
		String count = quantity.getText();
		
		for (int strlength = 0; strlength < count.length(); strlength++) {
			if (Character.isDigit(count.charAt(strlength)))
				sb.append(count.charAt(strlength));
		}
		 return sb;
	}

	public void compareAddToCartValue() throws InterruptedException {

		if (addCartValue() == getAddCartValue()) {
			System.out.println("true");
		} 
		else {
			System.out.println("false");
		}
	}

}
