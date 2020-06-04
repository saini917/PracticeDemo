package com.greenkart;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.utils.Base;
import com.utils.BrowserVariable;
import com.utils.Constant;

public class ProductSearchTestPage extends Base {
	ProductNamesListTestPage name=new ProductNamesListTestPage();

	public WebDriver driver;

	@Test(priority = 1)
	public void searchProductNameTest() throws IOException, InterruptedException {
		driver = initializeDriver(BrowserVariable.Chrome);
		driver.get(Constant.url);
		ProductSearch prodnameSearch = PageFactory.initElements(driver, ProductSearch.class);
		prodnameSearch.searchEditBox();

	}

}
