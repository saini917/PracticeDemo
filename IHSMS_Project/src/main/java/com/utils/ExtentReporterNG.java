package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentSparkReporter reporter;
	static ExtentReports extent;
	static String path = System.getProperty("user.dir") + "\\reports\\index.html";

	public static ExtentReports extentReporterGenerator() {
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("HPHDS/IHSMS Automation result");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Tester", "Deepak Saini");
		return extent;
	}

}
