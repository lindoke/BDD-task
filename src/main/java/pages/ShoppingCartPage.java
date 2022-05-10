package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@data-test-id='cta-top']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[@data-test-id='cart-remove-item']")
    private WebElement removeProductFromCartButton;

    @FindBy(xpath = "//span[text()=\"You don't have any items in your cart.\"]")
    private WebElement absenceOfProductsInCartMessage;

    public void isCheckoutButtonVisible() {
        checkoutButton.isDisplayed();
    }

    public void clickRemoveProductFromCartButton() {
        removeProductFromCartButton.click();
    }

    public void isAbsenceOfProductsInCartMessageAppears() {
        absenceOfProductsInCartMessage.isDisplayed();
    }
}
