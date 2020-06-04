package com.Hphds_URL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.utils.Browser_Intialize;
import com.utils.ConstantVaribale;
import com.utils.EnumGlobalVariables;


public class Url extends Browser_Intialize {
	
	/*****************************************************************************************************************/
	/**
	 * BeforeMethod annotation is used to open Url of application
	 * 
	 * @author deepak.saini
	 * @throws InterruptedException
	 * @since 2017-08-03
	 */
	/****************************************************************************************************************/
	@BeforeMethod
	public void setUp() {
		Browser_Intialize.launchBrowser(EnumGlobalVariables.Chrome).navigate().to(ConstantVaribale.url);
	}

	
	 @AfterMethod public void closeBrowser() { 
		 driver.close(); 
		 }
	 

	

}
