package pages;

import org.openqa.selenium.By;
import selenium_wrapper.SeleniumWrapper;

/**
 * @author Jaspal
 *
 */
public class UserDashboardPage {
	
	//**************ELEMENT LOCATORS**************
	private By userIdentityWelcomeText = By.xpath("//a[@data-control-name='identity_welcome_message']");
	
	
	//**************SELENIUMWRAPPER INSTANTIATIONS**************
	private SeleniumWrapper seleniumWrapper = new SeleniumWrapper();
	
	
	//**************PAGE METHODS**************
	public String getUserText() {
		return seleniumWrapper.getText(userIdentityWelcomeText);
	}

}
