import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import packages.HomePage;
import packages.Strings;

public class OffersTest extends  BaseTest {
    /**
     * Check for Offers page
     * Steps:
     * 1. Navigate to HomePage
     * 2. Click on menu
     * 3. Click on `Ponude`
     *
     * Expected result:
     * 4. Offers page should open
     */
    @Test
    public void OffersPageTest() {
        ChromeDriver driver = openChromeDriver();
        try{
            HomePage homePage = new HomePage(driver);
            homePage.openMenu();
            homePage.goToOffers();
            assert isCurrentURLEqualTo(driver, Strings.OffersPage_URL) : "Offers URL is not valid";
        }finally {
            driver.quit();
        }
    }
}
