package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//span[(text()='Condition')]")
    private WebElement conditionButton;

    @FindBy(xpath = "//span[@class='filter-menu-button__text' and (text()='Used')]")
    private WebElement usedOption;

    @FindBy(xpath = "//div[text()='Used']")
    private WebElement usedFilter;

    @FindBy(xpath = "//h1//span[text()='Sony']")
    private WebElement brandHeader;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickConditionButton() {
        conditionButton.click();
    }

    public void clickUsedOption() {
        usedOption.click();
    }

    public void checkThereIsUsedFilter() {
        usedFilter.isDisplayed();
    }

    public boolean doesHeaderContainsBrand(String brand) {
        System.out.println(brandHeader.getText());
        return brandHeader.getText().contains(brand);
    }

}
