package com.greenkart;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.utils.Base;
import com.utils.BrowserVariable;
import com.utils.Constant;

public class NumberOfItemDecrementedTestPage extends Base {

	public WebDriver driver;

	@Test(priority = 1)
	public void decrementItemTest() throws IOException, InterruptedException {
		driver = initializeDriver(BrowserVariable.Chrome);
		driver.get(Constant.url);
		
		CompareItem compare = PageFactory.initElements(driver, CompareItem.class);
		compare.compareItemNumberEntered();

		NumberOfItemDecremented item_count_list = PageFactory.initElements(driver, NumberOfItemDecremented.class);
		item_count_list.ItemEnteredDecrement();

	}

}
