package org.deepakjagtap.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReportsNG {
	static ExtentReports extent;

	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index1.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("setReportName()");
		reporter.config().setDocumentTitle("setDocumentTitle()");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "deepak jagtap");
		return extent;
	}
}
