package org.deepakjagtap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_003_addToCart extends BaseTest{
	@Test(enabled=true)
	public void verifyUserCanAddProductInCart_TC_003() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Deepak jagtap qa");
		driver.hideKeyboard();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"))
				.click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		// scroll to desired item
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"))
				.click();

		// get size of items that visible on screen not all available items.
		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

		for (int i = 0; i < productCount; i++) {
			String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i)
					.getText();
			if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
				// clicking on 'add to cart' for "Jordan 6 Rings"
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}

		// Navigate to cart tab
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		// Asserting user navigated to CART and checking product is added in card
		Boolean isCartDisplayed = driver.findElement(By.xpath("(//android.widget.RelativeLayout)[1]")).isDisplayed();

		if (isCartDisplayed) {
			String actualText = driver.findElement(By.xpath("//android.widget.TextView[@text='Jordan 6 Rings']"))
					.getText();
			Assert.assertEquals(actualText, "Jordan 6 Rings");
		}

		System.out.println("Successfully added item in cart and validated...");
	}

}
