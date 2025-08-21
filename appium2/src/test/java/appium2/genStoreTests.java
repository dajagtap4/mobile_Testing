package appium2;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.FormPage;
import pages.ProductCatalogue;
import utils.utility;

public class genStoreTests extends BaseTest {
	@Test
	public void verifyUserCanFillForm() throws IOException {

		// This test is data driven, we created data.properties file and with class
		// 'utility'
		// we are fetching that data and passing that values into pom methods like
		// formPage.setNameField(), formPage.setGender()extent.createTest("this is from
		// createTest() method");
		FormPage formPage = new FormPage(driver);
		formPage.setNameField(utility.fetchConfigProperty("name"));
		formPage.setGender(utility.fetchConfigProperty("gender"));
		formPage.setCountrySelection(utility.fetchConfigProperty("country"));

		// we are creating object of ProductCatalogue class inside FormPage class's
		// submitForm() method and return type is ProductCatalogue of that method.
		// catching that returned object in productCatalogue.
		ProductCatalogue productCatalogue = formPage.submitForm();
		String actualProductTitle = productCatalogue.getProductTitle();
		Assert.assertEquals(actualProductTitle, utility.fetchConfigProperty("expectedProductTitle"));
	}

	@Test(dataProvider = "getData")
	public void verifyUserCanAddMultipleItemsInCartAndCheckTotalOfAllCartItemsPriceAndMakeOrder(String name,
			String gender, String country) throws InterruptedException {

		// filling form
		FormPage formPage = new FormPage(driver);
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
		double displayedFormattedSum = cartPage.getFormattedTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayedFormattedSum);

		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Deepak jagtap", "male", "Antarctica" }, { "Rohit mughale", "female", "Angola" } };

	}
}
