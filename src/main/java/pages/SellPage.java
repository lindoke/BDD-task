package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.Assert.assertTrue;

public class SellPage extends BasePage{
    public SellPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[contains(@class, 'textual-display')]/following-sibling::a[text()='List an item']")
    private WebElement listAnItemButton;

    @FindBy(xpath = "//input[contains(@aria-label, 'Tell us')]")
    private WebElement listingField;

    @FindBy(xpath = "//button[contains(@aria-label, 'Go to list')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class, 'se-panel-container__body')]")
    private WebElement categoryPopup;

    @FindBy(xpath = "//button[contains(@name, '29223')]")
    private WebElement categoryResult;

    @FindBy (xpath = "//button[text()='Continue without match']")
    private WebElement continueWithoutMatchButton;

    public void isListAnItemButtonVisible() {
        listAnItemButton.isDisplayed();
    }

    public WebElement getListAnItemButton() {
        return listAnItemButton;
    }


    public void clickListAnIemButton() {
        listAnItemButton.click();
    }

    public void enterTextToListingField(final String searchText) {
        listingField.clear();
        listingField.sendKeys(searchText);
    }

    public void isListingFieldVisible() {
        listingField.isDisplayed();
    }

    public WebElement getListingField() {
        return listingField;
    }

    public void clickListingField() {
        listingField.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public WebElement getCategoryPopup() {
        return categoryPopup;
    }


    public String getCategoryResult() {
        System.out.println(categoryResult.getText());
        return categoryResult.getText();
    }

    public void clickSearchedCategoryButton() {
        categoryResult.click();
    }

    public void clickContinueWithoutMatchButton() {
        continueWithoutMatchButton.click();
    }
}
