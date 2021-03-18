package steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.cumcumber.UITests.AmazonCartSubTotal;
import com.cumcumber.UITests.AmazonHomepage;
import com.cumcumber.UITests.AmazonItemCheckOutPage;
import com.cumcumber.UITests.AmazonProductDetailsPage;
import com.cumcumber.UITests.AmazonSearchResultPage;
import com.cumcumber.UITests.AmazonSignIn;
import com.cumcumber.UITests.SelectAddressAndPaymentMethod;
import com.selenium.helpers.SeleniumHelpers;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AssignmentUITest {

	private String browser;
	private String url;

	@Given("^I open Amazon\\.com website$")
	public void i_open_Amazon_com_website() throws Throwable {
		url = System.getProperty("amazon_homepage"); // get amazon url from env var
		browser = System.getProperty("browser"); // get browser name from env var
		SeleniumHelpers.openAndLoadBrowser(browser, url); // open amazon.com in a browser
	}

	@Given("^I click on Sign In option$")
	public void i_click_on_Sign_In_option() throws Throwable {
		AmazonHomepage.clickSignIn(); // Click on sign in
	}

	@Given("^I enter username \"([^\"]*)\" on login page$")
	public void i_enter_username_on_login_page(String username) throws Throwable {
		AmazonSignIn.enterUserName(username); // enter email/username on sign in page
	}

	@Given("^I click on continue on login page$")
	public void i_click_on_continue_on_login_page() throws Throwable {
		AmazonSignIn.clickContinueButton(); // click on continue button sign in page
	}

	@Given("^I enter password \"([^\"]*)\" on login page$")
	public void i_enter_password_on_login_page(String password) throws Throwable {
		AmazonSignIn.enterPassword(password); // enter password on sign in page
	}

	@Given("^I click on Sign In Button$")
	public void i_click_on_Sign_In_Button() throws Throwable {
		AmazonSignIn.clickSignInButton(); // click on sign in button to sign in
	}

	@When("^I search for item \"([^\"]*)\"$")
	public void i_search_for_item(String searchString) throws Throwable {
		AmazonHomepage.enterSearchItem(searchString); // enter search string in homepage
		AmazonHomepage.clickSearchSubmitButton(); // click submit button for search string
	}

	@When("^I click on (\\d+) search result$")
	public void i_click_on_search_result(int searchResultItemNo) throws Throwable {
		AmazonSearchResultPage.setItemPrice(searchResultItemNo); // set item price for the 'x' number item found in
																	// results page
		AmazonSearchResultPage.clickOnSearchResultItem(searchResultItemNo); // click on item name for the 'x' number
																			// item found in results page
	}

	@Then("^I check price for search item$")
	public void i_check_price_for_search_item() throws Throwable {
		// verify that item price in product details page is same as item price in
		// search page
		assertThat(AmazonProductDetailsPage.getProductPrice()).isEqualTo(AmazonSearchResultPage.getItemPrice());
	}

	@Then("^I click on Add to Cart link$")
	public void i_click_on_Add_to_Cart_link() throws Throwable {
		AmazonProductDetailsPage.clickAddToCartButton(); // click on add to cart button
	}

	@Then("^I check price for added item in sub cart page$")
	public void i_check_price_for_added_item_in_sub_cart_page() throws Throwable {
		// verify that item price in sub cart page is same as item price in search page
		assertThat(AmazonCartSubTotal.getCartSubTotal()).isEqualTo(AmazonSearchResultPage.getItemPrice());
	}

	@Then("^I click on proceed to checkout button sub cart page$")
	public void i_click_on_proceed_to_checkout_button_sub_cart_page() throws Throwable {
		AmazonCartSubTotal.clickProceedToCheckOutButton(); // click proceed to checkout page
	}

	@Then("^I select address and payment methods$")
	public void i_select_address_and_payment_methods() throws Throwable {
		SelectAddressAndPaymentMethod.selectAddress(); // select most recent address
		SelectAddressAndPaymentMethod.clickContinueButton(); // click continue button on shipping options
		SelectAddressAndPaymentMethod.clickContinueButtonPayment(); // click continue on payment options page
	}

	@Then("^I verify the price on item checkout page$")
	public void i_verify_the_price_on_item_checkout_page() throws Throwable {
		// verify that item price in item checkout page is same as item price in search
		// page
		assertThat(AmazonItemCheckOutPage.getItemPrice()).isEqualTo(AmazonSearchResultPage.getItemPrice());
	}
}
