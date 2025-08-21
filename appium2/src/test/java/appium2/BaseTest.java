package appium2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File(
						"C://Users//Administrator//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Android Device");// real device
		// options.setDeviceName("Pixel_4_API_36"); // this will work also
		options.setChromedriverExecutable(
				"C://Users//deepak.jagtap//Downloads//chromedriver-win64 (1)//chromedriver-win64//chromedriver.exe");
		options.setApp(
				// "C://Users//deepak.jagtap//eclipse-workspace2//appium2//src//test//java//resources//ApiDemos-debug.apk");
				 "C://Users//deepak.jagtap//eclipse-workspace2//appium2//src//test//java//resources//General-Store.apk");
				//"C://Users//deepak.jagtap//eclipse-workspace2//appium2//src//test//java//resources//org-simple-clinic-staging-9139-68193701-10c706082a0c7d23ccde3ec6a2c73160.apk");

		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void longPressAction(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(), "Duration", 2000));
	}

	public void scrollToEndAction() {
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap
					.of("left", 100, "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0

					));
		} while (canScrollMore);
	}

	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),

						"direction", direction, "percent", 0.75));

	}

	public void dragAndDropAction(WebElement source) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) source).getId(), "endX", 619, "endY", 560));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
