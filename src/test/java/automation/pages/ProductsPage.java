package automation.pages;

import automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private By productTitle = By.cssSelector(".title");

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    public String getProductTitleText(){
        return getText(productTitle);
    }
}
