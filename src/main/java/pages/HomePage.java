package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class HomePage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'gh-control ghn')]")
    private WebElement notificationButton;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchField;

    @FindBy(xpath = "//span[text()='Ship to']")
    private WebElement shippingButton;

    @FindBy(xpath = "//span[contains(@class, 'expand')]")
    private WebElement countriesDropDown;

    @FindBy(xpath = "//span[text()='Done']")
    private WebElement shippingPopupClose;

    @FindBy(xpath = "//h3[contains(translate(., 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'samsung')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;

    @FindBy(xpath = "//button[@id='gh-shop-a']")
    private WebElement shopByCategoryButton;

    @FindBy(xpath = "//h3[@class=\"gh-sbc-parent\"]/descendant::i[@class='chevron-right']")
    private List<WebElement> countOfCategory;

    @FindBy (xpath = "//span[text()='Hi! ']/a[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[text()=' Sell']")
    private WebElement sellButton;

    @FindBy(xpath = "//a[@aria-controls='gf-f']")
    private WebElement currentCountry;

    @FindBy(xpath = "//a[@aria-label='eBay Australia']")
    private WebElement countryButton;

    @FindBy(xpath = "//a[@href='https://www.ebayinc.com/stories/news/']")
    private WebElement newsButton;

    @FindBy(xpath = "(//a[text()='Help & Contact'])[1]")
    private WebElement helpButton;

    @FindBy(xpath = "//h3[text()='Sony']")
    private WebElement brandSony;

    @FindBy(xpath = "//a[text()='Stores']")
    private WebElement storesButton;

    @FindBy(xpath = "//a[text() =\" Daily Deals\"]")
    private WebElement dealsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public boolean isTitleEmpty() {
        return driver.getTitle().isEmpty();
    }


    public void isNotificationButtonVisible() {
        notificationButton.isDisplayed();
    }

    public void isSearchButtonVisible() {
        searchButton.isDisplayed();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }



    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void doSearchResultsContainInputWords(final String searchInput) {
        String[] inputWords = searchInput.split("\\W+");
        for (var i : searchResults) {
            for (var j : inputWords) {
                if (!i.toString().contains(j)) {
                    return;
                }
            }
        }
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }

    public void isFooterVisible(){
        footer.isDisplayed();
    }

    public void clickShopByCategoryButton() {
        shopByCategoryButton.click();
    }

    public String getCountOfCategory() {
        return Integer.toString(countOfCategory.size());
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickSellButton() { sellButton.click();}

    public String getCurrentCountry() {
        return currentCountry.getText();
    }

    public void clickCurrentCountry() {
        currentCountry.click();
    }

    public void clickCountryButton() {
        countryButton.click();
    }

    public void clickNewsButton() {
        newsButton.click();
    }

    public void clickHelpButton() {
        helpButton.click();
    }

    public WebElement getPopularBrand(String brand) {
        assertEquals(brandSony.getText(), brand);
        return brandSony;
    }

    public void clickStoreButton() {
        storesButton.click();
    }

    public void clickDailyDealsButton() {
        dealsButton.click();
    }

    public void clickPopularBrand() {
        brandSony.click();
    }
}
