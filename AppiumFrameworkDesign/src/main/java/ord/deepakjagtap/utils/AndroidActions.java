package ord.deepakjagtap.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	AndroidDriver driver;

	public AndroidActions(AndroidDriver driver) {
		this.driver = driver;
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

	public void scrollToText(String text) {
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"))"));
	}
	
	public String getScreenShot(String testCaseName, AppiumDriver driver) throws IOException {
		File source = driver.getScreenshotAs(OutputType.FILE);
		String fileDesti = System.getProperty("user.dir") + "\\reports"+testCaseName+".png";
		//if below line give error, uncomment ExtentReports 0.0.1-SNAPSHOT dependancy.
		FileUtils.copyFile(source,new File(fileDesti));
		return fileDesti;
	}
}
