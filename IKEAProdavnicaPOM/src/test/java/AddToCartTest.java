import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import packages.HomePage;
import packages.SearchResultsPage;
import packages.ShoppingCartPage;
import packages.Strings;

public class AddToCartTest extends  BaseTest {
    /**
     * Add product to cart
     * Steps:
     * 1. Navigate to HomePage
     * 2. Type 'police' in search input
     * 3. Add an item to shopping cart
     * 4. Check if success toast is presented
     * 5. Tap on `Prikaži` button on success toast
     *
     * Expected result:
     * 6. Shopping cart page should be presented
     * 7. Product should be added to shopping cart
     */
    @Test
    public void AddProductToCart() {
        ChromeDriver driver = openChromeDriver();
        try{
            HomePage homePage = new HomePage(driver);
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            homePage.searchAndSubmit("police");
            SearchResultsPage srPage = new SearchResultsPage(driver);
            srPage.addToCart();
            assert srPage.isShoppingCartToastPresent() : "There is NO Shopping Toast";
            srPage.goToCart();
            assert isCurrentURLEqualTo(driver, Strings.ShoppingCartPage_URL) : "Shopping Cart url is not correct";
            sleep();
            assert shoppingCartPage.isShoppingCartProductPresent() : "Shopping Cart Product is not present";
        }finally {
            driver.quit();
        }
    }

    /**
     * Check empty cart
     * Steps:
     * 1. Navigate to HomePage
     * 2. Navigate to shopping cart
     *
     * Expected result:
     * 6. Shopping cart page should be presented
     * 7. Shopping cart should be empty
     */
    @Test
    public void EmptyCardTest() {
        ChromeDriver driver = openChromeDriver();
        try{
            HomePage homePage = new HomePage(driver);
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            homePage.goToCart();
            sleep();
            assert !shoppingCartPage.isShoppingCartProductPresent() : "Shopping Cart is not empty";
        }finally {
            driver.quit();
        }
    }
}
