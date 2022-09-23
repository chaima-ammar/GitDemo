package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SteupDefinitionImpl extends BaseTest {
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_username_and_password(String username, String password) {

		productCatalogue = landingPage.LoginApplication(username, password);
	}

	@When("^I add product (.+)to Cart$")
	public void i_add_product_to_Cart(String productName) throws InterruptedException {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);

	}

	@When("^checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) {
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
	    confirmationPage = checkoutPage.submitOrder();

	}
	
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmationPage(String string)
	{
		String confirmMessage = confirmationPage.getConfirmationMessages();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();

	}
	
	 @Then("^\"([^\"]*)\"message is displayed$")
	    public void somethingmessage_is_displayed(String strArg1) throws Throwable {
		 
		 Assert.assertEquals("Incorrect email  password.", landingPage.getErrorMessage());
		 driver.close();

	    }

}
