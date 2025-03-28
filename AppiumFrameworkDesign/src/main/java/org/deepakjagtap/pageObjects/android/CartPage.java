package org.deepakjagtap.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import ord.deepakjagtap.utils.AndroidActions;

public class CartPage extends AndroidActions {
	AndroidDriver driver;

	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	private WebElement terms;

	@AndroidFindBy(id = "android:id/button1")
	private WebElement acceptButton;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;

	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")
	private WebElement checkBox;

	public List<WebElement> getProductList() {
		return productList;
	}

	public Double getProductSum() {
		int count = productList.size();
		double totalSum = 0;

		for (int i = 0; i < count; i++) {
			String amoutString = productList.get(i).getText();
			double price = Double.parseDouble(amoutString.substring(1));
			totalSum = totalSum + price;
		}
		return totalSum;
	}

	public Double getTotalAmountDisplayed() {
		return getFormattedAmount(totalAmount.getText());
	}

	public Double getFormattedAmount(String amount) {
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

	public void acceptTermsConditions() {
		longPressAction(terms);
		acceptButton.click();
	}

	public void submitOrder() {
		checkBox.click();
		proceed.click();
	}
}
