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
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class TestCases extends BaseTest implements Locoators {

	@Test(enabled = true)
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

	@Test(enabled = false)
	public void longPress_Gesture() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId(VIEWS)).click();
		driver.findElement(AppiumBy.accessibilityId(EXPANDABLE_LISTS)).click();
		driver.findElement(AppiumBy.accessibilityId(CUSTOM_ADAPTER)).click();

		WebElement ele = driver.findElement(By.xpath(PEOPLE_NAMES));
		longPressAction(ele);

		Assert.assertTrue(driver.findElement(By.xpath(SAMPLE_MENU)).isDisplayed());
		String actualText = driver.findElement(By.xpath(SAMPLE_MENU)).getText();
		Assert.assertEquals(actualText, Constants.EXPECTED_SAMPLE_MENU_TEXT);

	}

	@Test(enabled = true)
	public void verifyUserCan_ScrollToDesiredText_WithGooglePlugin() {
		driver.findElement(AppiumBy.accessibilityId(VIEWS)).click();

		driver.findElement(AppiumBy.androidUIAutomator(ANDROID_UI_AUTOMATOR_WEB_VIEW)).click();

		String actualText = driver.findElement(By.xpath(WEB_VIEW)).getText();
		Assert.assertEquals(actualText, Constants.EXPECTED_VIEW_WEBVIEW_TEXT);
	}

	@Test(enabled = false)
	public void verifyUserCan_ScrollToEnd_WithJSExcecutor() {
		driver.findElement(AppiumBy.accessibilityId(VIEWS)).click();

		scrollToEnd();

		driver.findElement(AppiumBy.accessibilityId(VISIBILITY)).click();
		String actualText = driver.findElement(By.xpath(VIEW_VISIBILITY)).getText();
		Assert.assertEquals(actualText, Constants.EXPECTED_VIEW_VISIBILITY_TEXT);
	}
}
