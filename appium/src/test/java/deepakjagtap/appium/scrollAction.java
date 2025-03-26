package deepakjagtap.appium;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;

public class scrollAction extends BaseTest{

	@Test
	public void scrollWithGooglePlugin() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))")).click();
	}
	
	@Test
	public void scrollWithJSExcecutor() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
	
		boolean canScrollMore;
		do
		{
			canScrollMore = (Boolean) ((JavascriptExecutor)driver).executeScript("mobile:scrollGesture", ImmutableMap.of(
					"left",100, "top",100, "width",200, "height",200,
					"direction","down",
					"percent",3.0
					
					));
		}while(canScrollMore);
		
		driver.findElement(AppiumBy.accessibilityId("Visibility")).click();
	}
}
