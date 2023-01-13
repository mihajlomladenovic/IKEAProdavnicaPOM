import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import packages.HomePage;

public class StoreMenuTest extends  BaseTest {
    /**
     * Test Store Menu items
     * Steps:
     * 1. Navigate to HomePage
     * 2. Click on menu
     * 3. Click on `Robna kuća i restoran`
     * 4. Check if all menu items are present
     *
     * Expected result:
     * 5. The following menu items should be present: `Robna kuća IKEA Beograd`, `Mesta za preuzimanje`, `Restoran i Bistro` , `Događaji`
     */
    @Test
    public void StoreMenuItemsTest() {
        ChromeDriver driver = openChromeDriver();
        try{
            HomePage homePage = new HomePage(driver);
            homePage.openMenu();
            homePage.goToStores();
            assert  homePage.storeCategoriesPreset() : "Not all store items are present";
        }finally {
            driver.quit();
        }
    }
}
