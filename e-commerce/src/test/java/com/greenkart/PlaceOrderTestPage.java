package com.greenkart;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.utils.Base;
import com.utils.BrowserVariable;
import com.utils.Constant;

public class PlaceOrderTestPage extends Base {

	public WebDriver driver;

	@Test(priority = 1)
	public void placeOrderTestPage() throws IOException, InterruptedException {
		driver = initializeDriver(BrowserVariable.Chrome);
		driver.get(Constant.url);
		
		CompareItem compare = PageFactory.initElements(driver, CompareItem.class);
		compare.compareItemNumberEntered();
		
		NumberOfItemIncremented item_count = PageFactory.initElements(driver, NumberOfItemIncremented.class);
		item_count.ItemEnteredUsingPlus();		

		AddToCart cart=PageFactory.initElements(driver, AddToCart.class);
		cart.addToCart();
		
		CompareAddToCartValue cartValue=PageFactory.initElements(driver, CompareAddToCartValue.class);
		cartValue.getAddCartValue();
		cartValue.compareAddToCartValue();
		
		ProceedToCheckout checkout=PageFactory.initElements(driver, ProceedToCheckout.class);
		checkout.clickOnCheckout();
		
		PlaceOrder order=PageFactory.initElements(driver,PlaceOrder.class);
		order.onPlaceOrder();
		order.clickOnPlaceOrder();

	}
}
