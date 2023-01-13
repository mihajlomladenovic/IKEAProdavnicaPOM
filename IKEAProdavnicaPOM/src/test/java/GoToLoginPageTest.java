import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import packages.HomePage;

public class GoToLoginPageTest extends BaseTest {

    /**
     * Going to the Login Page
     * Steps:
     * 1. Navigate to HomePage
     * 2. Check if Login tab locator exists
     * 2. Click on Login tab locator
     * 3. Check if login button exists
     *
     * Expected result:
     * 4. Login tab locator exists
     * 5. Login button exists
     */

    @Test
    public void NavigatingtoLoginPageTest (){
        ChromeDriver driver = openChromeDriver();
        try{
            HomePage homePage = new HomePage(driver);
            assert homePage.isLoginTabLocatorPresent() : "There is NO Login Tab Locator";
            homePage.clickLoginTabLocator();
            assert homePage.isLoginButtonPresent() : "There is NO Login Button";
        }finally {
            driver.quit();
        }
    }
}
