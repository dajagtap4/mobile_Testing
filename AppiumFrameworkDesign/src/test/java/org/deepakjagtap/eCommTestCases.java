package org.deepakjagtap;

import java.time.Duration;
import java.util.List;

import org.deepakjagtap.pageObjects.android.CartPage;
import org.deepakjagtap.pageObjects.android.FormPage;
import org.deepakjagtap.pageObjects.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommTestCases extends BaseTest {
	@Test
	public void verifyUserCanAddMultipleItemsInCartAndCheckTotalOfAllCartItemsPriceAndMakeOrder()
			throws InterruptedException {

		formPage.setNameField("Deepak jagtap");
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");

		ProductCatalogue productCatalogue = formPage.submitForm();
		productCatalogue.addItemsToCartByIndex(0);
		productCatalogue.addItemsToCartByIndex(0);
		CartPage cartPage = productCatalogue.goToCartPage();
		double totalSum = cartPage.getProductSum();
		double displayedFormattedSum = cartPage.getTotalAmountDisplayed();

		Assert.assertEquals(totalSum, displayedFormattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	}
}
