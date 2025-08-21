package udemy_BasicPractice;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import appium2.BaseTest;
import io.appium.java_client.AppiumBy;

public class ScrollDemo extends BaseTest {
	@Test
	public void ScrollDemoGesture() throws MalformedURLException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))")
				);
		
		// alternate for scroll but untill end.
		// scrollToEndAction();

	}
}
