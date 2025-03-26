package deepakjagtap.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.By;
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

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	AppiumDriverLocalService service;
	AndroidDriver driver;

	@BeforeSuite
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		service = new AppiumServiceBuilder().withAppiumJS(new File(Constants.MAIN_DOT_JS_PATH))
				.withIPAddress(Constants.SERVER_IP).usingPort(Constants.APPIUM_SERVER_PORT_NUMBER).build();

		service.start();

		System.out.println("******************************************");
		System.out.println( Constants.SERVER_STARTED + service.isRunning());
		System.out.println("******************************************");
	}

	@BeforeMethod
	public void driverInstance() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(Constants.DEVICE_NAME);
		options.setApp(Constants.API_DEMOS_APK);
		driver = new AndroidDriver(new URI(Constants.SERVER_ADDRESS).toURL(), options);

		if (driver == null) {
			System.out.println("Driver initialization failed.");
			Assert.fail("Driver initialization failed.");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@AfterSuite
	public void tearDownServer() {
		service.stop();
		System.out.println("******************************************");
		System.out.println(Constants.SERVER_STOPPED);
		System.out.println("******************************************");
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile:longClickGesture",
				ImmutableBiMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
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
