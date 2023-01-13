package packages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy (xpath = "//img[@class = 'pip-image']")
    WebElement SearchResultImage;

    @FindBy (xpath = "//button[@class = 'pip-btn pip-btn--small pip-btn--icon-emphasised pip-product-compact__add-to-cart-button']")
    WebElement AddToCartButton;

    @FindBy (xpath = "//a[@data-tracking-label = 'shopping-bag']")
    WebElement ShoppingCartButton;

    @FindBy (xpath = "//div[@class = 'hnf-toast hnf-toast--show']")
    WebElement ShoppingCartToast;

    @FindBy (xpath = "//button[@class = 'hnf-btn hnf-btn--small hnf-btn--plain hnf-toast__action-message']")
    WebElement ShoppingCartToastOkButton;

    public SearchResultsPage(ChromeDriver driver) {
        super(driver);
    }
    public boolean isSearchResultPresent() {
        print("isSearchResultPresent");
        return isElementPresent(SearchResultImage);
    }

    public boolean isShoppingCartToastPresent() {
        print("isShoppingCartToastPresent");
        waitForElement(ShoppingCartToast, 3);
        return isElementPresent(ShoppingCartToast);
    }

    public void addToCart() {
        print("clickAddToCartButton");
        AddToCartButton.click();
    }

    public void goToCart() {
        print("goToCart");
        ShoppingCartToastOkButton.click();
    }
}
