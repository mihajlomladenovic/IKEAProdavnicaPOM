package packages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class
HomePage extends BasePage {
    //webelements
    @FindBy(xpath = "//button[@id = 'onetrust-accept-btn-handler']")
    WebElement acceptCookieButton;

    @FindBy (xpath = "//a[@class = 'hnf-btn hnf-leading-icon hnf-btn--small hnf-btn--icon-tertiary']")
    WebElement LoginTabLocator;

    @FindBy (xpath = "//span[@class = 'btn__inner']")
    WebElement LoginButton;

    @FindBy (xpath = "//input[@type = 'search']")
    WebElement SearchInput;

    @FindBy (xpath = "//button[@id = 'search-box__searchbutton']")
    WebElement SearchSubmitButton;

    @FindBy (xpath = "//a[@data-tracking-label = 'shopping-bag']")
    WebElement ShoppingCartButton;

    @FindBy (xpath = "//button[@class = 'hnf-btn--menu-label-button']")
    WebElement MenuButton;

    @FindBy (xpath = "//a[@data-tracking-label = 'offers']")
    WebElement OffersButton;

    @FindBy (xpath = "//a[@data-tracking-label = 'stores']")
    WebElement StoresButton;

    @FindBy (xpath = "//a[@data-tracking-label = 'stores']")
    WebElement StoresItem;

    @FindBy (xpath = "//a[@data-tracking-label = 'customer-service/services/click-collect']")
    WebElement ClickCollectItem;

    @FindBy (xpath = "//a[@data-tracking-label = 'stores/restaurant']")
    WebElement RestaurantItem;

    @FindBy (xpath = "//a[@data-tracking-label = 'dogadaji-u-robnoj-kuci-ikea-pub76577a70']")
    WebElement EventsItem;

    //constructor
    public HomePage(ChromeDriver driver) {
        super(driver);
        print("HomePage");
        clickConsentOnCookies();
    }

    public void clickConsentOnCookies() {
        print("clickConsentOnCookies()");
        waitForElement(acceptCookieButton,3);
        if(isElementPresent(acceptCookieButton)) {
            acceptCookieButton.click();
        }
    }

    public void clickLoginTabLocator() {
        print("clickLoginTabLocator");
        LoginTabLocator.click();
    }

    public boolean isLoginTabLocatorPresent() {
        print("isLoginTabLocatorPresent");
        return isElementPresent(LoginTabLocator);
    }

    public boolean isLoginButtonPresent() {
        print("isLoginButtonPresent");
        return isElementPresent(LoginButton);
    }

    public boolean isSearchInputPresent() {
        print("isSearchInputPresent");
        return isElementPresent(SearchInput);
    }

    public void enterTextIntoSearchField(String text) {
        print("enterTextIntoSearchField");
        waitForElement(SearchInput,1);
        SearchInput.click();
        waitForElement(SearchInput,1);
        SearchInput.sendKeys(text);
    }

    public void clickSearchAndSubmitButton() {
        print("clickSearchAndSubmitButton");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(SearchSubmitButton));
        waitForElement(SearchInput, 2);
        SearchSubmitButton.click();
    }

    public void searchAndSubmit(String text) {
        print("searchAndSubmit");
        enterTextIntoSearchField(text);
        clickSearchAndSubmitButton();
    }

    public void goToCart() {
        print("goToCart");
        ShoppingCartButton.click();
    }

    public void openMenu() {
        print("openMenu");
        MenuButton.click();
    }

    public void goToOffers() {
        print("goToOffers");
        OffersButton.click();
    }

    public void goToStores() {
        print("goToStores");
        StoresButton.click();
    }

    public boolean storeCategoriesPreset() {
        print("storeCategoriesPreset");
        return isElementPresent(StoresItem) &&
        isElementPresent(ClickCollectItem) &&
        isElementPresent(RestaurantItem) &&
        isElementPresent(EventsItem);
    }
}