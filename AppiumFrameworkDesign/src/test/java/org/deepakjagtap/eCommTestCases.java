package org.deepakjagtap;

import org.deepakjagtap.pageObjects.android.CartPage;
import org.deepakjagtap.pageObjects.android.ProductCatalogue;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class eCommTestCases extends BaseTest {
	@Test(dataProvider = "getData")
	public void verifyUserCanAddMultipleItemsInCartAndCheckTotalOfAllCartItemsPriceAndMakeOrder(String name,
			String gender, String country) throws InterruptedException {

		// filling form
		formPage.setNameField(name);
		formPage.setGender(gender);
		formPage.setCountrySelection(country);
		ProductCatalogue productCatalogue = formPage.submitForm();

		// navigated to product catalogue list page
		productCatalogue.addItemsToCartByIndex(0);
		productCatalogue.addItemsToCartByIndex(0);
		CartPage cartPage = productCatalogue.goToCartPage();

		// navigated to cart page
		// Adding and asserting prices
		double totalSum = cartPage.getProductSum();
		double displayedFormattedSum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayedFormattedSum);

		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Deepak jagtap", "male", "Argentina" },{ "swati jagtap", "female", "India" } };

	}
}
