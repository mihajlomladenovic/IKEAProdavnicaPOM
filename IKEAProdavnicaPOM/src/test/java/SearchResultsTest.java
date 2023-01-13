import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import packages.HomePage;
import packages.SearchResultsPage;
import packages.Strings;

public class SearchResultsTest extends BaseTest {
    /**
     * Check for search results
     * Steps:
     * 1. Navigate to HomePage
     * 2. Check if search input exists
     * 3. Type 'police' in search input
     * 4. Check for a search results
     *
     * Expected result:
     * 5. Search result should exist
     */
    @Test
    public void SearchResultsTest() {
        ChromeDriver driver = openChromeDriver();
        try{
            HomePage homePage = new HomePage(driver);
            assert homePage.isSearchInputPresent() : "There is NO Search Input";
            homePage.searchAndSubmit("police");
            SearchResultsPage srPage = new SearchResultsPage(driver);
            assert srPage.isSearchResultPresent() : "There is NO Search Results";
        }finally {
            driver.quit();
        }
    }

    /**
     * Check for search results
     * Steps:
     * 1. Navigate to HomePage
     * 2. Check if search input exists
     * 3. Type 'nivea' in search input
     * 4. Check for a search results
     *
     * Expected result:
     * 5. Search result should not exist
     */
    @Test
    public void SearchNoResultsTest() {
        ChromeDriver driver = openChromeDriver();
        try{
            HomePage homePage = new HomePage(driver);
            assert homePage.isSearchInputPresent() : "There is NO Search Input";
            homePage.searchAndSubmit("nivea");
            SearchResultsPage srPage = new SearchResultsPage(driver);
            assert !srPage.isSearchResultPresent() : "There ARE Search Results present";
        }finally {
            driver.quit();
        }
    }
}