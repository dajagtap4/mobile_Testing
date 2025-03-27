package deepakjagtap.appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class MobileBrowserTestCases extends BrowserBaseTest {
	@Test
	public void browserTest() throws InterruptedException {
		driver.get("https://www.google.co.in/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("deepak jagtap QA");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);
	}

	@Test
	public void scrollAction() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a")).click();
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)","");
		driver.findElement(By.xpath("/html/body/app-root/app-product-details/div/div[2]/div/ul/div[3]/li/div/div/a")).click();
		Thread.sleep(2000);
	}
}
