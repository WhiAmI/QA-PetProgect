package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    private By productTitle = By.cssSelector(".title");

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductTitleText(){
        return driver.findElement(productTitle).getText();
    }
}
