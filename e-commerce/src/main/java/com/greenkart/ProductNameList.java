package com.greenkart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.utils.Base;

public class ProductNameList extends Base{

	int index_size, index_length, size;
	String prodName, temp;
	List<String> names = new ArrayList<String>();
 
 /*    @comments is given by deepak .saini
	  *index_size variable is used to iterate all the elements
	  *j is used to iterate all the product name to compare each product name with each other
	  *size variable is used to get the total number of product name count 
	  *prodName variable ios used to store all the product name
	  *temp variable is used to store temporary product name and compare
	  *List is used to store all the product names and if in future new item is added automatically its increses the size
 */
	
	
	
  /*
	 * @comments is given by deepak .saini
	 * This CSS selector is used to get all the product name that are available on the Webpage
 */
	@FindBy(how = How.CSS, using = ".product-name")
	private List<WebElement> productNames;

 

	public void getProductName() {

		for (index_size = 0; index_size < productNames.size(); index_size++) {
			prodName = productNames.get(index_size).getText();
			System.out.println(prodName);
			names.add(prodName);
		}
		

		String prod[] = new String[names.size()];
		for (index_length = 0; index_length < names.size(); index_length++) {
			prod[index_length] = names.get(index_length);
		}
		size = prod.length;

		for (index_size = 0; index_size < size - 1; index_size++) {
			for (index_length = index_size + 1; index_length < prod.length; index_length++) {
				if (prod[index_size].compareTo(prod[index_length]) > 0) {
					temp = prod[index_size];
					prod[index_size] = prod[index_length];
					prod[index_length] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(prod));
		System.out.println(driver.getTitle());
	}
}
