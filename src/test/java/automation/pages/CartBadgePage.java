package automation.pages;

import automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartBadgePage extends BasePage {

    private final By cartTitle = By.cssSelector(".title");
    private final By productName = By.className("inventory_item_name");
    private final By productPrice = By.className("inventory_item_price");
    private final By productQuantity = By.className("cart_quantity");

    public CartBadgePage (WebDriver driver){
        super(driver);
        waitForVisibility(cartTitle);
    }

    public boolean isOpened() {
        return waitForVisibility(cartTitle).isDisplayed();
    }

    public List<Double> getProductPrices() {
        waitForVisibility(productPrice);

        return driver.findElements(productPrice)
                .stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", ""))
                .map(Double::parseDouble)
                .toList();
    }

    public List<String> getProductsNames(){
        waitForVisibility(productName);

        return driver.findElements(productName)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public String getProductQuantity(){
        return getText(productQuantity);
    }

}
