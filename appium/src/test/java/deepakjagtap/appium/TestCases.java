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

		Boolean WifiSettingText = driver.findElement(By.id(TEXT_WIFI_SETTING)).isDisplayed();

		if (WifiSettingText) {
			String actualText = driver.findElement(By.id(TEXT_WIFI_SETTING)).getText();
			Assert.assertEquals(actualText, Constants.EXPECTED_WIFI_SETTINGS,
					"The text does not match the expected \"WiFi settings\" text.");
		} else {
			System.out.println("'WiFi settings' is not displayed on the screen.");
		}

		driver.findElement(By.id(INPUT_BOX)).sendKeys("xyz");
		driver.findElement(By.id(OK)).click();
	}

	@Test(enabled = true)
	public void longPress_Gesture() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId(VIEWS)).click();
		driver.findElement(AppiumBy.accessibilityId(EXPANDABLE_LISTS)).click();
		driver.findElement(AppiumBy.accessibilityId(CUSTOM_ADAPTER)).click();

		WebElement ele = driver.findElement(By.xpath(PEOPLE_NAMES));
		longPressAction(ele);

		Boolean sampleMenu = driver.findElement(By.xpath(SAMPLE_MENU)).isDisplayed();

		if (sampleMenu) {
			String actualText = driver.findElement(By.xpath(SAMPLE_MENU)).getText();
			Assert.assertEquals(actualText, Constants.EXPECTED_SAMPLE_MENU_TEXT,
					"The text does not match the expected \"Sample menu\" text.");
		} else {
			System.out.println("Sample menu is not displayed on the screen.");
		}

	}

	@Test(enabled = true)
	public void verifyUserCan_ScrollToDesiredText_WithGooglePlugin() {
		driver.findElement(AppiumBy.accessibilityId(VIEWS)).click();

		driver.findElement(AppiumBy.androidUIAutomator(ANDROID_UI_AUTOMATOR_WEB_VIEW)).click();

		Boolean VewView = driver.findElement(By.xpath(WEB_VIEW)).isDisplayed();

		if (VewView) {
			String actualText = driver.findElement(By.xpath(WEB_VIEW)).getText();
			Assert.assertEquals(actualText, Constants.EXPECTED_VIEW_WEBVIEW_TEXT,
					"The text does not match the expected \"Views/WebView\" text.");
		} else {
			System.out.println("'Views/WebView' is not displayed on the screen.");
		}

	}

	@Test(enabled = true)
	public void verifyUserCan_ScrollToEnd_WithJSExcecutor() {
		driver.findElement(AppiumBy.accessibilityId(VIEWS)).click();

		scrollToEnd();

		driver.findElement(AppiumBy.accessibilityId(VISIBILITY)).click();

		Boolean ViewVisibility = driver.findElement(By.xpath(VIEW_VISIBILITY)).isDisplayed();

		if (ViewVisibility) {
			String actualText = driver.findElement(By.xpath(VIEW_VISIBILITY)).getText();
			Assert.assertEquals(actualText, Constants.EXPECTED_VIEW_VISIBILITY_TEXT,
					"The text does not match the expected \"Views/Visibility\" text.");
		} else {
			System.out.println("'Views/Visibility' is not displayed on the screen.");
		}
	}
	
	@Test
	public void verifyUserCanSwipeImageSetToLeft() {
		driver.findElement(AppiumBy.accessibilityId(VIEWS)).click();
		driver.findElement(AppiumBy.accessibilityId(GALLERY)).click();
		driver.findElement(AppiumBy.accessibilityId(PHOTOS)).click();
		
		WebElement firstImage = driver.findElement(By.xpath(FIRST_IMAGE));
		
		Assert.assertEquals(firstImage.getAttribute(Constants.FOUSABLE_ATTRIBUTE),
				"true");

		swipeLeftAction(firstImage);

		Assert.assertEquals(firstImage.getAttribute(Constants.FOUSABLE_ATTRIBUTE),
				"false");
	}
}
