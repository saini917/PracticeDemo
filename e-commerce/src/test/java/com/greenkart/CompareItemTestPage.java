package com.greenkart;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.utils.Base;
import com.utils.BrowserVariable;
import com.utils.Constant;

public class CompareItemTestPage extends Base {

	public WebDriver driver;

	@Test(priority = 1)
	public void compareItemEnteredTest() throws IOException, InterruptedException {
		driver = initializeDriver(BrowserVariable.Chrome);
		driver.get(Constant.url);

		CompareItem item_count = PageFactory.initElements(driver,CompareItem.class);
		item_count.compareItemNumberEntered();

	}

}
