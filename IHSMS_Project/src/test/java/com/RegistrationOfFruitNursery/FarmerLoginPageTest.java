package com.RegistrationOfFruitNursery;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.Hphds_URL.Url;


public class FarmerLoginPageTest extends Url {

	@Test(priority = 1)
	public void farmerLoginTest() throws IOException, InterruptedException {
		FarmerLoginPage loginpage = PageFactory.initElements(driver, FarmerLoginPage.class);
		loginpage.clcikOnLoginButton();
		loginpage.EnterFarmerLogin();

	}

	

	

	

}
