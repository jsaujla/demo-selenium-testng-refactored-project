package selenium_wrapper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

/**
 * @author Jaspal
 *
 */
public class SeleniumWrapper {
	
	//**************OBJECT DECLARATION**************
	// Making below objects static to simplify the implementations, just to make the concept understanding easy.
	private static WebDriver driver;
	private static WebDriverWait webDriverWait;
	
	
	//**************LAUNCH BROWSER**************
	public void launchBrowser(String browserName) {
		if(browserName.toLowerCase().contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/browser-drivers/geckodriver.exe");	
        	driver = new FirefoxDriver();
		}
		else if(browserName.toLowerCase().contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browser-drivers/chromedriver.exe");
        	driver = new ChromeDriver();
		}
		else if(browserName.toLowerCase().contains("ie") || browserName.toLowerCase().contains("internet explorer")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	        capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
	        capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
        	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/browser-drivers/IEDriverServer.exe");
        	driver = new InternetExplorerDriver(capabilities);
		}
		else if(browserName.toLowerCase().contains("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/browser-drivers/MicrosoftWebDriver.exe");
        	driver = new EdgeDriver();
		}
	}
	
	
	//**************QUIT BROWSER**************
	public void quitBrowser() {
		driver.quit();
	}
	
	
	//**************DELETE ALL COOKIES**************
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
	}
	
	
	//**************SET WEBDRIVER WAIT TIME**************
	public void setWebDriverWait(int waitTime) {
		webDriverWait = new WebDriverWait(driver, waitTime);
	}
	
	
	//**************LAUNCH APPLICATION**************
	public void openUrl(String url) {
		driver.get(url);
	}
	
	
	//**************GET CURRENT PAGE URL**************
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	
	//**************CHECK IS ELEMENT DISPLAYED**************
	public void isElementDisplayed(By locator) {
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	//**************FILL VALUE**************
	public void fillValue(By locator, String value) {
		WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		webElement.sendKeys(value);
		Reporter.log("Value filled successfully in :" + locator);
	}
	
	
	//**************CLICK ON ELEMENT**************
	public void click(By locator) {
		WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
		webElement.click();
	}
	
	
	//**************GET TEXT FROM ELEMENT**************
	public String getText(By locator) {
		WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return webElement.getText();
	}

}
