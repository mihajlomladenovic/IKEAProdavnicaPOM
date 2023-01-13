package packages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    @FindBy (xpath = "//a[data-tracking-label='ikea-logo']")
    WebElement logolocator;

    @FindBy (xpath = "//input[class = 'search-field__input']")
    WebElement searchinputlocator;

    @FindBy (xpath = "//button[id = 'search-box__visualsearch']")
    WebElement visualsearchbuttonlocator;

    ChromeDriver driver = null;

    public BasePage(ChromeDriver driver) {
        print("BasePage");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void print(String s) {
        System.out.println(s);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            boolean isPresent = element.isDisplayed();
            return true;
        } catch (Exception e) {
            print(e.getMessage());
            print("Element is not present on page");
            return  false;
        }
    }

    public void waitForElement(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForElementClickable(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}