package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(driver);
    }

    public AdvancedSearchPage getAAdvancedSearchPage(){
        return new AdvancedSearchPage(driver);
    }

    public HelpPage getHelpPage() {return new HelpPage(driver);}


    public DealsPage getDealsPage(){
        return new DealsPage(driver);
    }

    public SellPage getSellPage(){
        return new SellPage(driver);
    }

    public ShoppingCartPage getShoppingCartPage(){
        return new ShoppingCartPage(driver);
    }

    public SignInPage getSignInPage (){
        return new SignInPage(driver);
    }

    public StoresPage getStoresPage(){
        return new StoresPage(driver);
    }


}
