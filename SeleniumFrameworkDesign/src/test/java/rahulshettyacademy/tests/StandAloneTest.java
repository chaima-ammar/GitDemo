package rahulshettyacademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StandAloneTest extends BaseTest {
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void StandAlone(HashMap<String, String> input) throws IOException, InterruptedException {

		ProductCatalogue productCatalogue = landingPage.LoginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessages();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

	// To verify ZARA COAT 3 is displayed in order page
	@Test(dependsOnMethods = { "StandAlone" })
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.LoginApplication("chaimaammar.simplon@gmail.com", "Ch@@2022");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
	}
	
	

	
	
	

	@DataProvider
	public  Object[][] getData() throws IOException{
	
List<HashMap<String,String>> data =getJsonDataToMap("//home//chaima//eclipse-workspace//SeleniumFrameworkDesign//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
		
return new Object [][] {{data.get(0)},{data.get(1) } };
		
	}}

// {HashMap<String,String> map =new HashMap<String,String>();
// map.put("email", "chaimaammar.simplon@gmail.com");
// map.put("password","Ch@@2022");
// map.put("productName", "ZARA COAT 3");

// {HashMap<String,String> map1 =new HashMap<String,String>();
// map1.put("email", "chaimaammar.simplon@gmail.com");
// map1.put("password","Ch@@2022");
// map1.put("productName", "ADIDAS ORIGINAL");
// return new Object [][] {{map},{map1}

// @DataProvider
// public Object[][] getData()
// {
// return new Object [][] {{"chaimaammar.simplon@gmail.com","Ch@@2022","ZARA
// COAT 3"},{"chaimaammar.simplon@gmail.com","Ch@@2022","ADIDAS ORIGINAL"}};
// }
