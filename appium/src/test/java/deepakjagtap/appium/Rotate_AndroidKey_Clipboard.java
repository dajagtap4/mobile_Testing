package deepakjagtap.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Rotate_AndroidKey_Clipboard extends BaseTest implements Locoators {

	@Test(enabled = true)
	public void miscellanousAppiumTest() {
		driver.findElement(AppiumBy.accessibilityId(PREFERENCE)).click();
		driver.findElement(AppiumBy.accessibilityId(PREFERENCE_DEPENDENCIES)).click();
		driver.findElement(By.id(CHECK_WIFI_CHECKBOX)).click();
		
		DeviceRotation rotate = new DeviceRotation(0,0,90);
		driver.rotate(rotate);
		
		driver.findElement(By.xpath(WIFI_SETTING)).click();

		Boolean WifiSettingText = driver.findElement(By.id(TEXT_WIFI_SETTING)).isDisplayed();

		if (WifiSettingText) {
			String actualText = driver.findElement(By.id(TEXT_WIFI_SETTING)).getText();
			Assert.assertEquals(actualText, Constants.EXPECTED_WIFI_SETTINGS,
					"The text does not match the expected \"WiFi settings\" text.");
		} else {
			System.out.println("'WiFi settings' is not displayed on the screen.");
		}

		driver.setClipboardText("abcd efgh ijkl");
		driver.findElement(By.id(INPUT_BOX)).sendKeys(driver.getClipboardText());
		driver.findElement(By.id(OK)).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}
