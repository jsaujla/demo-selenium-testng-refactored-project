package selenium_testng_demo;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Jaspal
 *
 */
public class VerifyLogin extends CommonSteps {
	
	@Test
	public void verifyLoginWithValidCredentials() {
		homePage.login("add valid email", "add valid password"); // add valid email and password
    	String actualUserName = userDashboardPage.getUserText();
    	String expectedUserName = "Welcome, Jaspal!"; // Change "Welcome, Jaspal!" to actual username (Welcome, Username!)
    	
    	//**************ASSERTION**************
    	Assert.assertEquals(actualUserName, expectedUserName);
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() {
		homePage.login("add valid email", "add invalid password"); // add valid email and invalid password
    	loginSubmitPage.isErrorMessageDisplayed("The password you provided must have at least 6 characters.");
    	String actualUrl = loginSubmitPage.getCurrentUrl();
    	String expectedUrl = "https://www.linkedin.com/uas/login-submit";
    	
    	//**************ASSERTION**************
    	Assert.assertEquals(actualUrl, expectedUrl);
	}
	
}
