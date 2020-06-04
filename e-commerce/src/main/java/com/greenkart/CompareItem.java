package com.greenkart;

import java.util.logging.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.Base;
import com.utils.Excel_Reader;

public class CompareItem extends Base {

	String path = "D:\\Workspace_NRDA\\e-commerce\\src\\java\\resource\\RealData.xlsx";
	Excel_Reader reader = new Excel_Reader(path);

	Logger log = Logger.getLogger("devpinoyLogger");
	@SuppressWarnings("deprecation")
	WebDriverWait wait = new WebDriverWait(driver, 20);
	int height;
	int width;

	@FindBy(how = How.CSS, using = "input[class*='search']")
	private WebElement searchProd;

	@FindBy(how = How.CSS, using = "input.quantity")
	private WebElement numberOfItem;

	int rowCount = reader.getRowCount("Product_Name");
	String prodName;
	int rowNum;
	int row;
	String prodcount;

	public void compareItemNumberEntered() throws InterruptedException {

		try {
			for (rowNum = 2; rowNum <= rowCount; rowNum++) {

				prodName = reader.getCellData("Product_Name", "ProductName", rowNum);
				if (prodName.contains("Apple - 1 Kg")) {
					searchProd.sendKeys(prodName);
					row = rowNum;
					Thread.sleep(2000);
				}

				if (row == rowNum) {
					for (int staleElementException = 0; staleElementException <= 2; staleElementException++) {
						prodcount = reader.getCellData("Product_Name", "Item_count_entered", row);
						numberOfItem.clear();
						numberOfItem.sendKeys(prodcount);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
