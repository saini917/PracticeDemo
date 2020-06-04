package com.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Hphds_URL.Url;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Url implements ITestListener {
	ExtentReports extent = ExtentReporterNG.extentReporterGenerator(); 
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public int scc = 0;

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		// screenshot and attach to report
		extentTest.get().fail(result.getThrowable());
		Object testObject = result.getInstance();
		Class clazz = result.getTestClass().getRealClass();
		try {
			driver = (WebDriver) clazz.getDeclaredField("driver").get(testObject);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(getDateTimeStamp() + scc + result.getMethod().getMethodName(), driver),
					result.getMethod().getMethodName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getDateTimeStamp() {
		// creates a date time stamp that is Windows OS filename compatible
		return new SimpleDateFormat(" MMM dd   HH.mm.ss").format(Calendar.getInstance().getTime());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Successfully");
	}

	public void onFinish(ITestContext result) {
		extent.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
