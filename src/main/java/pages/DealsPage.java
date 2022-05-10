package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DealsPage extends BasePage{

    public DealsPage(WebDriver driver) {
        super(driver);
    }

    public WebDriver getDriver(){
        return driver;
    }

    @FindBy(xpath = "//a[@class='block-level-link topic-link']")
    private List<WebElement> numberOfTopics;

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchField;

    @FindBy(xpath = "//header")
    private WebElement header;

    public int getNumberOfTopics() {
       return numberOfTopics.size();
    }

    public void isSearchFieldVisible() {
        searchField.isDisplayed();
    }

    public WebElement getHeader() {
        return header;
    }
}
