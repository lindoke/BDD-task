package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdvancedSearchPage extends BasePage{
    public AdvancedSearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='Advanced Search']")
    private WebElement advancedSearchButton;

    @FindBy(xpath = "//input[@placeholder='Enter keywords or item number']")
    private WebElement searchField;

    @FindBy(xpath = "//select[@name='_in_kw']")
    private WebElement keyOptions;

    @FindBy(xpath = "//input[@id='_ex_kw']")
    private WebElement excludedWordsField;

    @FindBy(xpath = "//option[@value='2']")
    private WebElement anyWordsAnyOrder;

    @FindBy(xpath = "//button[text()='Search' and not (@id)]")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@class='vip' and not (contains(text(), '12'))]")
    private List<WebElement> searchResults;

    public void clickAdvancedSearchButton() {
        advancedSearchButton.click();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText) {
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void isKeyOptionsVisible() {
        keyOptions.isDisplayed();
    }

    public void isExcludedWordsFieldVisible() {
        excludedWordsField.isDisplayed();
    }

    public void enterTextToExcludedWordsField(String text) {
        excludedWordsField.clear();
        excludedWordsField.sendKeys(text);
    }

    public void clickKeyOptions() {
        keyOptions.click();
    }

    public void clickAnyWordsAnyOrder() {
        anyWordsAnyOrder.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean doSearchResultsNotContainsExcludedWord(final String excluded) {
        for (var i : searchResults) {
            if (i.toString().contains(excluded)) {
                return true;
            }
        }
        return false;
    }
}
