package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import static org.junit.Assert.assertFalse;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.*;

public class DefinitionsSteps {

    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    HelpPage helpPage;
    DealsPage dealsPage;
    SellPage sellPage;
    ShoppingCartPage shoppingCartPage;
    SignInPage signInPage;
    StoresPage storesPage;
    AdvancedSearchPage advancedSearchPage;
    PageFactoryManager pageFactoryManager;

    private static final long DEFAULT_TIMEOUT = 60;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens {string}page")
        public void openPage(final String url) {
            homePage = pageFactoryManager.getHomePage();
            homePage.openHomePage(url);
        }


    @After
    public void tearDown() {
        driver.close();
    }

    @And("User checks title emptiness")
    public void userChecksTitleEmptiness() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertFalse(homePage.isTitleEmpty());
    }


    @And("User checks notifications button visibility")
    public void userChecksNotificationsButtonVisibility() {
        homePage.isNotificationButtonVisible();
    }

    @And("User checks search button visibility")
    public void userChecksSearchButtonVisibility() {
        homePage.isSearchButtonVisible();
    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.isSearchFieldVisible();
    }

    @And("User types {string} in search field")
    public void userTypesSearchTextInSearchField(final String keyword) {
        homePage.enterTextToSearchField(keyword);
    }

    @When("User clicks search button")
    public void userClicksSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User checks all results contains {string}")
    public void userChecksAllResultsContainsSearchWords(final String text) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.doSearchResultsContainInputWords(text);

    }

    @And("User checks header visibility")
    public void userChecksHeaderVisibility() {
        homePage.isHeaderVisible();
    }

    @And("User checks footer visibility")
    public void userChecksFooterVisibility() {
        homePage.isFooterVisible();
    }

    @And("User clicks shop by category button")
    public void userClicksShopByCategoryButton() {
        homePage.clickShopByCategoryButton();
    }


    @And("User checks that number of categories equals to {string}")
    public void userChecksThatNumberOfCategoriesEqualsToCountOfCategories(String countOfCategory) {
        assertEquals(homePage.getCountOfCategory(), countOfCategory);
    }

    @When("User clicks sign in link or check for captcha")
    public void userClicksSignInLink() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        if ((homePage.getDriver().getCurrentUrl().contains("captcha")))
            return;
        else
            homePage.clickSignInButton();
    }

    @Then("User checks email field is visible")
    public void userChecksEmailFieldIsVisible() {
        signInPage=pageFactoryManager.getSignInPage();
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getEmailField());
        signInPage.isEmailFieldVisible();
    }

    @And("User types wrong {string} in email field")
    public void userTypesWrongEmailInEmailField(String wrongEmail) {
        signInPage.clickEmailField();
        signInPage.enterTextToEmailField(wrongEmail);
    }


    @When("User clicks continue button")
    public void userClicksContinueButton() {
        signInPage.clickContinueButton();
    }

    @Then("User checks password field is visible or check for captcha")
    public void userChecksPasswordFieldIsVisibleOrCheckForCaptcha() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        if ((signInPage.getDriver().getCurrentUrl().contains("captcha")))
            return;
        else
            signInPage.isPasswordFieldVisible();
    }


    @And("User types {string} in password field")
    public void userTypesPasswordInPasswordField(String password) {
        signInPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, signInPage.getPasswordField());
        signInPage.enterTextToPasswordField(password);
    }


    @When("User clicks sign in button or check for the captcha")
    public void userClicksSignInButtonOrCheckForTheCaptcha() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        if ((signInPage.getDriver().getCurrentUrl().contains("captcha")))
            return;
        else
            signInPage.clickSignInButton();
    }

    @Then("User checks for error or check for the captcha")
    public void userChecksForErrorOrCheckForTheCaptcha() {
        signInPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        if ((signInPage.getDriver().getCurrentUrl().contains("captcha")))
            return;
        else
            signInPage.isErrorMessageVisible();
    }


    @Then("User checks error message is correct")
    public void userChecksErrorMessageIsCorrect() {
        assertEquals(signInPage.getErrorMessage(), "Oops, that`s not a match.");
    }

    @And("User clicks Sell button")
    public void userClicksSellButton() {
        homePage.clickSellButton();
    }


    @And("User checks URL contains {string}")
    public void userChecksURLContainsSell(String sell) {
        assertTrue(driver.getCurrentUrl().contains(sell));
    }

    @And("User checks List an item button is visible")
    public void userChecksListAnItemButtonIsVisible() {
        sellPage=pageFactoryManager.getSellPage();
        sellPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, sellPage.getListAnItemButton());
        sellPage.isListAnItemButtonVisible();
    }

    @And("User clicks List an item button")
    public void userClicksListAnItemButton() {
        sellPage.clickListAnIemButton();
    }

    @And("User checks listing field is visible")
    public void userChecksListingFieldIsVisible() {
        sellPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sellPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, sellPage.getListingField());
        sellPage.isListingFieldVisible();
    }

    @And("User types {string} in listing field")
    public void userTypesCategoryInListingField(String category) {
        sellPage.clickListingField();
        sellPage.enterTextToListingField(category);
    }

    @When("User clicks search")
    public void userClicksSearch() {
        sellPage.clickSearchButton();
    }

    @And("User checks category popup contains {string}")
    public void userChecksCategoryPopupContainsCategory(String category) {
        sellPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, sellPage.getCategoryPopup());
        String[] categorySplit = sellPage.getCategoryResult().split("\\W+");
        for (var i: categorySplit){
            if (i.equalsIgnoreCase(category))
                return;
        }
    }


    @And("User clicks searched category")
    public void userClicksSearchedCategory() {
        sellPage.clickSearchedCategoryButton();
    }

    @And("User clicks continue without match button")
    public void userClicksContinueWithoutMatchButton() {
        sellPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        sellPage.clickContinueWithoutMatchButton();
    }


    @And("User checks URL contains signin")
    public void userChecksURLContainsSignin(String text) {
        sellPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(text));
    }


    @And("User click AdvancedSearch button")
    public void userClickAdvancedSearchButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        advancedSearchPage=pageFactoryManager.getAAdvancedSearchPage();
        advancedSearchPage.clickAdvancedSearchButton();
    }

    @And("User checks search field is visible")
    public void userChecksSearchFieldIsVisible() {
        advancedSearchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        advancedSearchPage.isSearchFieldVisible();
    }

    @And("User checks dropdown field with keyoptions is visible")
    public void userChecksDropdownFieldWithKeyOptionsIsVisible() {
        advancedSearchPage.isKeyOptionsVisible();
    }

    @And("User checks excluded words field visibility")
    public void userChecksExcludedWordsFieldVisibility() {
        advancedSearchPage.isExcludedWordsFieldVisible();
    }

    @And("User types {string} in searchfield")
    public void userTypesTextInSearchfield(String text) {
        advancedSearchPage.enterTextToSearchField(text);

    }

    @And("User types {string} in excluded words field")
    public void userTypesExcludedInExcludedWordsField(String text) {
        advancedSearchPage.enterTextToExcludedWordsField(text);
    }

    @When("User clicks dropdown field")
    public void userClicksDropdownField() {
        advancedSearchPage.clickKeyOptions();
    }


    @Then("User selects Any words any order option")
    public void userSelectsAnyWordsAnyOrderOption() {
        advancedSearchPage.clickAnyWordsAnyOrder();
    }

    @When("User clicks Search button")
    public void userClicksSearchButtonAdvancedPage() {
        advancedSearchPage.clickSearchButton();
    }

    @Then("User checks results does not contain {string} word")
    public void userChecksResultsDoesNotContainExcludedWord(String excluded) {
        assertTrue(advancedSearchPage.doSearchResultsNotContainsExcludedWord(excluded));
    }

    @And("User checks selected country is United States")
    public void userChecksSelectedCountryIsUnitedStates() {
        assertEquals(homePage.getCurrentCountry(), "United States");
    }

    @And("User clicks dropdown with list of countries")
    public void userClicksDropdownWithListOfCountries() {
        homePage.clickCurrentCountry();
    }


    @And("User clicks country button")
    public void userClicksCountryButton() {
        homePage.clickCountryButton();
    }


    @And("User checks URL contains {string} in it")
    public void userChecksURLContainsCountryAbbreviationInIt(String abbreviation) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(abbreviation));
    }



    @And("User checks search stories field visibility")
    public void userChecksSearchStoriesFieldVisibility() {
        dealsPage.isSearchFieldVisible();
    }

    @And("User makes search by {string}")
    public void userMakesSearchByKeyword(String keyword) {
        homePage.enterTextToSearchField(keyword);
    }


    @And("User clicks Help button")
    public void userClicksHelpButton() {
        homePage.clickHelpButton();
    }

    @And("User search eBay help field visibility")
    public void userSearchEBayHelpFieldVisibility() {
        helpPage = pageFactoryManager.getHelpPage();
        helpPage.isEBayHelpFieldVisible();
    }

    @And("User types {string}")
    public void userTypesWrongInput(String wrongInput) {
        helpPage.getEbayHelpField().clear();
        helpPage.getEbayHelpField().sendKeys(wrongInput);
    }

    @And("User checks error message")
    public void userChecksErrorMessage() {
        helpPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, helpPage.getErrorMessage());
        assertEquals(helpPage.getErrorMessageText(), "We're sorry, we couldn't find any results that match your search. Please try again.");
    }

    @And("User clicks {string} in popular brands list")
    public void userClicksBrandInPopularBrandsList(String brand) {
        homePage.clickPopularBrand();
    }

    @And("User checks URL contains brand {string}")
    public void userChecksURLContainBrand(String brand) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().contains(brand));
    }



    @And("User clicks Stores button")
    public void userClicksStoresButton() {
        homePage.clickStoreButton();
    }

    @And("User clicks Find a store button")
    public void userClicksFindAStoreButton() {
        storesPage = pageFactoryManager.getStoresPage();
        storesPage.clickFindAStoreButton();
    }

    @And("User types {string} in store search field")
    public void userTypesCountryInStoreSearchField(String country) {
        storesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        storesPage.getCountrySearchField().sendKeys(country);
    }

    @And("User checks Find a store button visibility")
    public void userChecksFindAStoreButtonVisibility() {
        storesPage.isFindStoreButtonVisible();
    }

    @And("User checks store search field visibility")
    public void userChecksStoreSearchFieldVisibility() {
        storesPage.isSearchFieldVisible();
    }

    @And("User clicks Daily Deals button")
    public void userClicksDailyDealsButton() {
        homePage.clickDailyDealsButton();
    }

    @And("User checks URL contains deals")
    public void userChecksURLContainsDeals() {
        String deals = "deals";
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        dealsPage = pageFactoryManager.getDealsPage();
        dealsPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, dealsPage.getHeader());
        assertTrue(driver.getCurrentUrl().contains(deals));

    }

    @And("User clicks condition button")
    public void userClicksConditionButton() {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultsPage.clickConditionButton();
    }

    @And("User selects Used option")
    public void userSelectsUsedOption() {
        searchResultsPage.clickUsedOption();
    }

    @And("User checks there is Used filter")
    public void userChecksThereIsUsedFilter() {
        searchResultsPage.checkThereIsUsedFilter();
    }

    @And("User checks header contains {string}")
    public void userChecksHeaderContainsBrand(String brand) {
        searchResultsPage = pageFactoryManager.getSearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(searchResultsPage.doesHeaderContainsBrand(brand));
    }

    @And("User checks header is visible;")
    public void userChecksHeaderIsVisible() {
        storesPage.isHeaderVisible();
    }
}
