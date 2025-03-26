package deepakjagtap.appium;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableBiMap;

import io.appium.java_client.AppiumBy;

public class TestCases extends BaseTest implements Locoators {
	@Test
	public void VerifyUserCanDoWifiSettingAndEnterInput() throws MalformedURLException, URISyntaxException {
		driver.findElement(AppiumBy.accessibilityId(PREFERENCE)).click();
		driver.findElement(AppiumBy.accessibilityId(PREFERENCE_DEPENDENCIES)).click();
		driver.findElement(By.id(CHECK_WIFI_CHECKBOX)).click();
		driver.findElement(By.xpath(WIFI_SETTING)).click();

		String actualText = driver.findElement(By.id(TEXT_WIFI_SETTING)).getText();
		Assert.assertEquals(actualText, Constants.EXPECTED_WIFI_SETTINGS);

		driver.findElement(By.id(INPUT_BOX)).sendKeys("xyz");
		driver.findElement(By.id(OK)).click();
	}

	@Test
	public void longPress_Gesture() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();

		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

		((JavascriptExecutor) driver).executeScript("mobile:longClickGesture",
				ImmutableBiMap.of("elementId", ((RemoteWebElement) ele).getId(), "duration", 2000));
	}
}
