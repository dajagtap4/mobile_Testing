package deepakjagtap.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class ActivityDemo extends BaseTest implements Locoators {
	@Test
	public void activityToStartDirectlyToDesiredPage() {

		((JavascriptExecutor) driver).executeScript("mobile:startActivity", ImmutableMap.of("intent",
				"io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

		driver.findElement(By.id(CHECK_WIFI_CHECKBOX)).click();
		driver.findElement(By.xpath(WIFI_SETTING)).click();

		driver.findElement(By.id(INPUT_BOX)).sendKeys("xyz");
		driver.findElement(By.id(OK)).click();
	}
}
