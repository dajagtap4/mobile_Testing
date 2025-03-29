	package deepakjagtap.appium;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_Native_And_Hybrid_APP extends BaseTest implements Locoators {
	@Test(groups= {"smoke"},priority=1)
	public void verifyUserCanFillFormAndSucessfullyNavigateToHomePage_TC_001() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("deepak jagtap qa");
		driver.hideKeyboard();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"))
				.click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		Thread.sleep(2000);
	}

	@Test(groups= {"smoke"},priority=2)
	public void verifyToastMessagesForErrorValidation_TC_002() throws InterruptedException {

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		String toastMes = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		Assert.assertEquals(toastMes, "Please enter your name");
	}

	@Test(enabled=false)
	public void verifyUserCanAddProductInCart_TC_003() throws InterruptedException {
		fillForm();

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

	@Test(groups= {"smoke"},priority=3)
	public void verifyUserCanAddProductInCartWithWebDriverWait_TC_004() throws InterruptedException {
		fillForm();

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
//		WebElement isCartDisplayed = driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title"));
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.attributeContains(isCartDisplayed, "text", "Cart"));

		// assert item in 'cart' that we selected in 'products'
		String actualText = driver.findElement(By.xpath("//android.widget.TextView[@text='Jordan 6 Rings']")).getText();
		Assert.assertEquals(actualText, "Jordan 6 Rings");
	}

	@Test(enabled=false)
	public void verifyUserCanAddMultipleItemsInCartAndCheckTotalOfAllCartItemsPriceAndMakeOrder_TC_005()
			throws InterruptedException {
		fillForm();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		// wait until focus goes to cart tab
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));

		// getting two items price 'totalSum', getting total price from UI
		// 'CartsTotalSum' and converting it to double 'displayFormattedAmount
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum = 0;

		for (int i = 0; i < count; i++) {
			String amoutString = productPrices.get(i).getText();
			double price = Double.parseDouble(amoutString.substring(1));
			totalSum = totalSum + price;
		}

		// asserting both sums and converting carts total price to double
		String CartsTotalSum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double displayFormattedAmount = Double.parseDouble(CartsTotalSum.substring(1));
		Assert.assertEquals(totalSum, displayFormattedAmount);

		// long press below teams and conditions tab/button
		WebElement tearmsAndConditions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(tearmsAndConditions);
		// close teams and conditions popup
		driver.findElement(By.id("android:id/button1")).click();
		// checkbox
		driver.findElement(By.xpath(
				"//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]"))
				.click();
		// make purchase button/submit
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

	}

	@Test(enabled=false)
	public void verifyUserCanHandleNativeAsWellWebApp_HybdridApp() throws InterruptedException {
		fillForm();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		// wait until focus goes to cart tab
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));

		// getting two items price 'totalSum', getting total price from UI
		// 'CartsTotalSum' and converting it to double 'displayFormattedAmount
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum = 0;

		for (int i = 0; i < count; i++) {
			String amoutString = productPrices.get(i).getText();
			double price = Double.parseDouble(amoutString.substring(1));
			totalSum = totalSum + price;
		}

		// asserting both sums and converting carts total price to double
		String CartsTotalSum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double displayFormattedAmount = Double.parseDouble(CartsTotalSum.substring(1));
		Assert.assertEquals(totalSum, displayFormattedAmount);

		// long press below teams and conditions tab/button
		WebElement tearmsAndConditions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(tearmsAndConditions);
		// close teams and conditions popup
		driver.findElement(By.id("android:id/button1")).click();
		// checkbox
		driver.findElement(By.xpath(
				"//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]"))
				.click();
		// make purchase button/submit
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		Thread.sleep(3000);

//		Set<String> contexts = driver.getContextHandles();
//		for (String contextName : contexts) {
//			System.out.println(contextName);
//		}

		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("deepak jagtap QA");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}
}
