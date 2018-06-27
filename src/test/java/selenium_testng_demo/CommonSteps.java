package selenium_testng_demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import pages.LoginSubmitPage;
import pages.UserDashboardPage;
import selenium_wrapper.SeleniumWrapper;

/**
 * @author Jaspal
 *
 */
public class CommonSteps {
	
	//**************VARIABLE/OBJECT DECLARATION**************
	protected String browserName;
	protected String baseUrl;
	protected int waitTime;
	
	protected Properties propertyFile;
	protected FileInputStream fileInputStream;
	
	protected SeleniumWrapper seleniumWrapper;
	
	//**************PAGE DECLARATION**************
	protected HomePage homePage;
	protected UserDashboardPage userDashboardPage;
	protected LoginSubmitPage loginSubmitPage;
	
	@BeforeMethod
	public void beforeTest() {
		//**************READ BROWSER, URL, WAIT INFORMATION FROM PROPERTIES FILE**************
		propertyFile = loadPropertiesFile(propertyFile, System.getProperty("user.dir") + "/src/test/resources/propertiesFile.properties");
		
		browserName = propertyFile.getProperty("browser");
		baseUrl = propertyFile.getProperty("baseUrl");
		waitTime = Integer.parseInt(propertyFile.getProperty("waitTime"));
		
		seleniumWrapper = new SeleniumWrapper();
		seleniumWrapper.launchBrowser(browserName);
		seleniumWrapper.setWebDriverWait(waitTime);
		
		//**************PAGE INSTANTIATIONS**************
    	homePage = new HomePage();
    	userDashboardPage = new UserDashboardPage();
    	loginSubmitPage = new LoginSubmitPage();
    	homePage.open(baseUrl);
	}
	
	@AfterMethod
	public void afterTest() {
		seleniumWrapper.deleteCookies();
		seleniumWrapper.quitBrowser();
	}
	
	private Properties loadPropertiesFile(Properties propertiesObject, String filePath) {
        try {
        	propertiesObject = new Properties();
            fileInputStream = new FileInputStream(filePath);
            propertiesObject.load(fileInputStream);
            return propertiesObject;
        }
        catch (IOException io) {
            io.printStackTrace();
            return null;
        }
        finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }
                catch (IOException io) {
                    io.printStackTrace();
                }
            }
        }
    }
	
}
