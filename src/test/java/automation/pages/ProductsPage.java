package automation.pages;

import automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final By productTitle = By.cssSelector(".title");
    private final By firstProductAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartButton = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductTitleText() {
        return getText(productTitle);
    }

    public void addFirstProductToCart() {
        click(firstProductAddToCartButton);
    }

    public CartPage goToCart() {
        click(cartButton);
        return new CartPage(driver);
    }
}
