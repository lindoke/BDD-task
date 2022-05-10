package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='userid']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@id='signin-continue-btn']")
    private WebElement continueButton;

    @FindBy(xpath = "//input[@id='pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='sgnBt']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[@class='inline-notice__header']")
    private WebElement errorMessage;

    public WebDriver getDriver(){
        return driver;
    }

    public void enterTextToEmailField(final String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterTextToPasswordField(final String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void isEmailFieldVisible() {
        emailField.isDisplayed();
    }

    public void clickEmailField() {
        emailField.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void isPasswordFieldVisible() {
        passwordField.isDisplayed();
    }


    public void clickSignInButton() {
        signInButton.click();
    }

    public void isErrorMessageVisible() {
        errorMessage.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }
}
