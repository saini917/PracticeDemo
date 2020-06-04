package com.greenkart;

import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.utils.Base;
import com.utils.Excel_Reader;


public class ProductSearch extends Base{
	
	String path = "D:\\Workspace_NRDA\\e-commerce\\src\\java\\resource\\RealData.xlsx";
	Excel_Reader reader=new Excel_Reader(path);
			
			
	Logger log = Logger.getLogger("devpinoyLogger");
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 20);
	int height;
	int width;
	
	@FindBy(how = How.CSS, using = "input[class*='search']")
	private WebElement searchProd;

	public void searchEditBox() throws InterruptedException{
		
		wait.until(ExpectedConditions.visibilityOf(searchProd));
		Assert.assertTrue(searchProd.isDisplayed());
		HighlightOnElement(searchProd);
		Assert.assertTrue(searchProd.isEnabled());
		wait.until(ExpectedConditions.elementToBeClickable(searchProd));
		
		int rowCount=reader.getRowCount("Product_Name");
		System.out.println("Total number of rows: "+rowCount);
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++){
			String prodName = reader.getCellData("Product_Name", "ProductName", rowNum);
			searchProd.sendKeys(prodName);
			driver.findElement(By.cssSelector("button[type='submit']")).click();
			searchProd.clear();
			
		}
		
		height = searchProd.getRect().getDimension().getHeight();
		width = searchProd.getRect().getDimension().getWidth();
		
		System.out.println("Height of Product search  box: " + height);
		System.out.println("Width of Product search  box: " + width);
		System.out.println(driver.getTitle());
	}

}
