package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.io.IOException;

import com.cumcumber.UITests.AmazonHomepage;
import com.selenium.helpers.SeleniumHelpers;

public class hooks {

	@Before
	public void beforeTest() {
		System.out.println("<-------------------------Start of Test Case-------------------------->");
	}

	@After
	public void afterTest() throws IOException {
		SeleniumHelpers.afterMethod(); // to close the browser
		System.out.println("<-------------------------End of Test Case---------------------------->");
	}

	

}
