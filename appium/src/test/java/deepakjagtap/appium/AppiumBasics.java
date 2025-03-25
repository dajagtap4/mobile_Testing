package deepakjagtap.appium;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest implements Locoators {
	@Test
	public void VerifyUserCanDoWifiSettingAndEnterInput() throws MalformedURLException, URISyntaxException {

		driver.findElement(AppiumBy.accessibilityId(PREFERENCE)).click();
		driver.findElement(AppiumBy.accessibilityId(PREFERENCE_DEPENDENCIES)).click();
		driver.findElement(By.id(CHECK_WIFI_CHECKBOX)).click();
		driver.findElement(By.xpath(WIFI_SETTING)).click();
		driver.findElement(By.id(INPUT_BOX)).sendKeys("xyz");
		driver.findElement(By.id(OK)).click();
	}
}
