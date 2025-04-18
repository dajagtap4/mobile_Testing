package org.deepakjagtap.pages;

import java.util.List;

import org.deepakjagtap.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions {
	AndroidDriver driver;

	public ProductCatalogue(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
	private WebElement productTitle;

	public void addItemsToCartByIndex(int index) {
		addToCart.get(index).click();
	}

	public String getProductTitle() {
		return productTitle.getText();
	}

	public CartPage goToCartPage() throws InterruptedException {
		cart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
	}
}