package com.greenkart;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;
import java.util.logging.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.utils.Base;
import com.utils.Excel_Reader;

public class SelectCountryAndProceed extends Base {

	Logger log = Logger.getLogger("devpinoyLogger");
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 20);
	int height;
	int width;

	String path = "D:\\Workspace_NRDA\\e-commerce\\src\\java\\resource\\RealData.xlsx";
	Excel_Reader reader = new Excel_Reader(path);
	int rowCount = reader.getRowCount("Product_Name");
	int rowNum;
	String countries;

	@FindBy(how = How.CSS, using = "div.wrapperTwo>div>select")
	private WebElement country;

	public void selectCountry() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(country));
		Assert.assertTrue(country.isDisplayed());
		HighlightOnElement(country);
		Assert.assertTrue(country.isEnabled());
		wait.until(ExpectedConditions.visibilityOf(country));
		int rowCount = reader.getRowCount("Product_Name");
		System.out.println(rowCount);

		try {
			for (rowNum = 2; rowNum <= rowCount; rowNum++) {

				countries = reader.getCellData("Product_Name", "Countries", rowNum);
				//System.out.println(countries);
				if (countries.contains("India")) {
					Select sel = new Select(country);
					sel.selectByVisibleText(countries);
					Thread.sleep(3000);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@FindBy(how = How.CSS, using = ".chkAgree")
	private WebElement agree;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Proceed')]")
	private WebElement proceed;
	
	public void clickOnProceed(){
		wait.until(ExpectedConditions.visibilityOf(agree));
		Assert.assertTrue(agree.isDisplayed());
		HighlightOnElement(agree);
		Assert.assertTrue(agree.isEnabled());
		wait.until(ExpectedConditions.visibilityOf(agree));
		
		agree.click();
		
		
		wait.until(ExpectedConditions.visibilityOf(proceed));
		Assert.assertTrue(proceed.isDisplayed());
		HighlightOnElement(proceed);
		Assert.assertTrue(proceed.isEnabled());
		wait.until(ExpectedConditions.elementToBeClickable(proceed));
		
		proceed.click();
	}

}
