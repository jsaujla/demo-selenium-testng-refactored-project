package pages;

import org.openqa.selenium.By;
import selenium_wrapper.SeleniumWrapper;

/**
 * @author Jaspal
 *
 */
public class LoginSubmitPage {
	
	//**************SELENIUMWRAPPER INSTANTIATIONS**************
	private SeleniumWrapper seleniumWrapper = new SeleniumWrapper();
	
	
	//**************PAGE METHODS**************
	public String getCurrentUrl() {
		return seleniumWrapper.getCurrentUrl();
	}
	
	public void isErrorMessageDisplayed(String errorMessage) {
		seleniumWrapper.isElementDisplayed(By.xpath("//span[@id='session_password-login-error'][text()='"+errorMessage+"']"));
	}

}
