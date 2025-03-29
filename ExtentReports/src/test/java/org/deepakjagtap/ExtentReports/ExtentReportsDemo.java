package org.deepakjagtap.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportsDemo {
	ExtentReports extent;

	@BeforeMethod
	public void config() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("this is report name");
		reporter.config().setDocumentTitle("this is document title");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "deepak jagtap");
	}

	@Test
	public void testDemoForExtentReports() {
		extent.createTest("this is from createTest()");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://chatgpt.com/");
		System.out.println(driver.getTitle());
		
		driver.close();
		//extent.flush();
	}
}
