package com.greenkart;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.utils.Base;
import com.utils.BrowserVariable;
import com.utils.Constant;

public class ProductNamesListTestPage extends Base {

	public WebDriver driver;

	@Test(priority = 1)
	public void productNamesTest() throws IOException, InterruptedException {
		driver = initializeDriver(BrowserVariable.Chrome);
		driver.get(Constant.url);
		ProductNameList prodname = PageFactory.initElements(driver, ProductNameList.class);
		prodname.getProductName();

	}

}
