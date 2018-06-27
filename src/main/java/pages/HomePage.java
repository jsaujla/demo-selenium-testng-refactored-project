package pages;

import org.openqa.selenium.By;
import selenium_wrapper.SeleniumWrapper;

/**
 * @author Jaspal
 *
 */
public class HomePage {	
	
	//**************ELEMENT LOCATORS**************
	private By emailTextbox = By.id("login-email");
	private By passwordTextbox = By.id("login-password");
	private By signInButton = By.id("login-submit");
	
	
	//**************SELENIUMWRAPPER INSTANTIATIONS**************
	private SeleniumWrapper seleniumWrapper = new SeleniumWrapper();
	
	
	//**************PAGE METHODS**************
	public void open(String baseUrl) {
		seleniumWrapper.openUrl(baseUrl);
	}
	
	public void login(String email, String password) {
		seleniumWrapper.fillValue(emailTextbox, email);
		seleniumWrapper.fillValue(passwordTextbox, password);
		seleniumWrapper.click(signInButton);
	}

}
