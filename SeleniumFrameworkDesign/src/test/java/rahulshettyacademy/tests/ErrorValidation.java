package rahulshettyacademy.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidation extends BaseTest{

	@Test(groups={"ErrorHandling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";
		
		landingPage.LoginApplication("chaima.simplon@gmail.com", "Ch@2022");
		Assert.assertEquals("Incorrect email  password.", landingPage.getErrorMessage());

		//.ng-tns-c4-2.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
		

	}
	
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";
		
		ProductCatalogue productCatalogue = landingPage.LoginApplication("rahulshetty@gmail.com", "Ch@@2022");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 3");
		Assert.assertFalse(match);
	

	}

}
