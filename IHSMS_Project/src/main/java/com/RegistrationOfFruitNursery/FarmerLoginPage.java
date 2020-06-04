package com.RegistrationOfFruitNursery;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.utils.CommonLib;
import com.utils.Excelutils;

public class FarmerLoginPage extends CommonLib {
	Excelutils d = new Excelutils();
	ArrayList<String> data;
	Logger log = Logger.getLogger("devpinoyLogger");
	WebDriverWait wait = new WebDriverWait(driver, 20);
	int height;
	int width;

	@FindBy(xpath = "//a[@id='Header_btnLogin']/span")
	private WebElement loginmenu;

	public void clcikOnLoginButton() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(loginmenu));
		Assert.assertTrue(loginmenu.isDisplayed());
		HighlightOnElement(loginmenu);
		Assert.assertTrue(loginmenu.isEnabled());
		wait.until(ExpectedConditions.elementToBeClickable(loginmenu));
		loginmenu.click();
	}

	@FindBy(how = How.CSS, using = "#txtUserName")
	private WebElement username;

	@FindBy(how = How.CSS, using = "#txtPassword")
	private WebElement password;

	@FindBy(how = How.CSS, using = "input[name='btnSubmit']")
	private WebElement loginbtn;

	public void EnterFarmerLogin() throws IOException, InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(username));
		Assert.assertTrue(username.isDisplayed());
		HighlightOnElement(username);
		Assert.assertTrue(username.isEnabled());
		wait.until(ExpectedConditions.elementToBeClickable(username));
		data = d.getData("FarmerLogin");
		username.sendKeys(data.get(1));
		
		//Height and Width of username textbox
		height = username.getRect().getDimension().getHeight();
		width = username.getRect().getDimension().getWidth();
		System.out.println("Height of username: " + height);
		System.out.println("Width of username: " + width);

		wait.until(ExpectedConditions.visibilityOf(password));
		Assert.assertTrue(password.isDisplayed());
		HighlightOnElement(password);
		Assert.assertTrue(password.isEnabled());
		wait.until(ExpectedConditions.elementToBeClickable(password));
		data = d.getData("FarmerLogin");
		password.sendKeys(data.get(2));
		
		////Height and Width of Password textbox
		height = password.getRect().getDimension().getHeight();
		width = password.getRect().getDimension().getWidth();
		System.out.println("Height of password: " + height);
		System.out.println("Width of password: " + width);

		wait.until(ExpectedConditions.visibilityOf(loginbtn));
		Assert.assertTrue(loginbtn.isDisplayed());
		HighlightOnElement(loginbtn);
		Assert.assertTrue(loginbtn.isEnabled());
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();
	}

}
