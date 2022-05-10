package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StoresPage extends BasePage{

    public StoresPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[text()='Find a Store']")
    private WebElement findAStoreButton;

    @FindBy(xpath = "//input[@placeholder='Store name or keyword']")
    private WebElement searchField;

    @FindBy(xpath = "//a[text() =\" Daily Deals\"]")
    private WebElement dealsButton;

    @FindBy(xpath = "//header")
    private WebElement header;


    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public WebElement getCountrySearchField() {
        return searchField;
    }

    public void clickFindAStoreButton() {
        findAStoreButton.click();
    }


    public void isFindStoreButtonVisible() {
        findAStoreButton.isDisplayed();
    }

    public void isDealsButtonVisible() {
        dealsButton.isDisplayed();
    }

    public void clickDailyDealsButton() {
        dealsButton.clear();
    }

    public void isHeaderVisible() {
        header.isDisplayed();
    }
}
