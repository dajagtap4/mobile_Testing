package ord.deepakjagtap.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentsReportsNG {
	static ExtentReports extent;
	public static ExtentReports getReportObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("this is report name");
		reporter.config().setDocumentTitle("this is document title");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "deepak jagtap");
		return extent;
	}
}
