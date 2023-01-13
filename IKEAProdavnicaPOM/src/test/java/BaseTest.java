import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
//    ChromeDriver driver = null;
        public ChromeDriver openChromeDriver() {
            print("Openenig Chrome driver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[]{"--start-maximized"});
            options.addArguments(new String[]{"--ignore-certificate-errors"});
            options.addArguments(new String[]{"--disable-popup-blocking"});
            options.addArguments(new String[]{"--incognito"});
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            ChromeDriver driver = new ChromeDriver(options);
            driver.get("https://www.ikea.com/rs/sr/");
            return driver;
        }

        public static void print(String s) {
        System.out.println(s);
    }

        public boolean isCurrentURLEqualTo(ChromeDriver driver, String expectedUrl) {
            print("isCurrentURLEqualTo ( " + expectedUrl + " )");
            String currentUrl = driver.getCurrentUrl();
            print("User is on " + currentUrl);
            boolean b = currentUrl.equals(expectedUrl);
            return b;
        }

        public void sleep() {
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


