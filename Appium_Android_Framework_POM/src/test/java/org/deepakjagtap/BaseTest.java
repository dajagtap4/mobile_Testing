package org.deepakjagtap;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import org.deepakjagtap.pages.FormPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	AppiumDriverLocalService service;
	AndroidDriver driver;
	FormPage formPage;

	@BeforeSuite
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException, InterruptedException {
		// To start appium without code,
		// -> open cmd -> install appium -> "npm install -g appium" (appium will start )
		// below code is used to start an Appium server programmatically
		
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C://Users//Administrator//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.usingPort(4723).withIPAddress("127.0.0.1").build();

		service.start();

		System.out.println("Appium Server Started:" + service.isRunning());
	}

	@BeforeMethod
	public void driverInstance() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel 3a");
		options.setApp(
				"C://Users//deepak.jagtap//eclipse-workspace//appium//src//test//java//resources//General-Store.apk");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
		formPage = new FormPage(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@AfterSuite
	public void tearDownServer() {
		if (service != null) {
			service.stop();
		}
	}
}
