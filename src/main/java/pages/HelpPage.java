package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HelpPage extends BasePage{
    public HelpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='search_input_element']")
    private WebElement ebayHelpField;

    @FindBy(xpath = "//div[@class='apology']")
    private WebElement errorMessage;

    public void isEBayHelpFieldVisible() {
        ebayHelpField.isDisplayed();
    }

    public WebElement getEbayHelpField(){
        return ebayHelpField;
    }

    public WebElement getErrorMessage(){
        return errorMessage;
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
