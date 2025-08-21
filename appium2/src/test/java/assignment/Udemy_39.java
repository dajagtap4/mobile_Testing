package assignment;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import appium2.BaseTest;
import io.appium.java_client.AppiumBy;

public class Udemy_39 extends BaseTest {

	@Test
	public void okCancelDialogWithMessage() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		driver.findElement(By.id("io.appium.android.apis:id/two_buttons")).click();
		driver.findElement(By.id("android:id/button1")).click();

	}
}
