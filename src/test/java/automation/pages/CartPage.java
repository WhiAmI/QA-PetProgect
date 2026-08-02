package automation.pages;

import automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By title = By.className("title");
    private final By checkout = By.id("checkout");
    private final By productName = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return getText(title);
    }

    public void clickCheckout(){
        click(checkout);
    }

    public String getProductName(){
        return getText(productName);

    }
}
