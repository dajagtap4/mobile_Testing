package org.deepakjagtap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.deepakjagtap.pageObjects.android.FormPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	AppiumDriverLocalService service;
	AndroidDriver driver;
	FormPage formPage;

	@BeforeSuite
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C://Users//Administrator//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		System.out.println("******************************************");
		System.out.println("Appium Server Started:" + service.isRunning());
		System.out.println("******************************************");

	}

	@BeforeMethod
	public void driverInstance() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3a");
		options.setChromedriverExecutable(
				"C://Users//deepak.jagtap//Downloads//chromedriver-win64 (1)//chromedriver-win64//chromedriver.exe");
		options.setApp(
				"C://Users//deepak.jagtap//eclipse-workspace//appium//src//test//java//resources//General-Store.apk");
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
		formPage = new FormPage(driver);

		if (driver == null) {
			System.out.println("Driver initialization failed.");
			Assert.fail("Driver initialization failed.");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
//	@BeforeMethod
//	public void navigateToStartingPage() throws MalformedURLException, URISyntaxException {
//		((JavascriptExecutor) driver).executeScript("mobile:startActivity", ImmutableMap.of("intent",
//				"com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
//	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@AfterSuite
	public void tearDownServer() {
		service.stop();
		System.out.println("******************************************");
		System.out.println("Appium Server Stopped....");
		System.out.println("******************************************");
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile:longClickGesture",
				ImmutableBiMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}

	public void swipeLeftAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile:swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "direction", "left", "percent", 0.75

				));
	}

	public void scrollToEnd() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile:scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0

					));
		} while (canScrollMore);
	}

//	 public void click(String loc) {
//	        try {
//	            WebElement element = driver.findElement(AppiumBy.accessibilityId(loc));
//	            element.click();
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	            Assert.fail("Failed to click on element [" + loc + "]");
//	        }
//	    }

}
