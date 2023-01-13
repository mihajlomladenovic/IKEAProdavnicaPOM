package packages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends  BasePage {
    @FindBy(xpath = "//li[@data-testid = 'product_name']")
    WebElement ShoppingCartProduct;

    public ShoppingCartPage(ChromeDriver driver) {
        super(driver);
    }

    public boolean isShoppingCartProductPresent() {
        print("isShoppingCartProductPresent");
        return isElementPresent(ShoppingCartProduct);
    }
}
