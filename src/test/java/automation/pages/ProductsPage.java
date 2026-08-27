package automation.pages;

import automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsPage extends BasePage {

    private final By productTitle = By.cssSelector(".title");
    private final By firstProductAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartButton = By.className("shopping_cart_link");
    private final By sortList = By.className("product_sort_container");
    private final By productPrices = By.className("inventory_item_price");
    private final By productName = By.className("inventory_item_name");
    private final By countCartBadge = By.className("shopping_cart_badge");
    private final By shoppingCart = By.className("shopping_cart_link");
    private final By addToCartButtons = By.cssSelector("button[data-test^='add-to-cart']");

    public ProductsPage(WebDriver driver) {
        super(driver);
        waitForVisibility(productTitle);
    }

    public boolean isOpened() {
        return waitForVisibility(productTitle).isDisplayed();
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

    public CartBadgePage goToCartBadge() {
        click(shoppingCart);
        return new CartBadgePage(driver);
    }

    public void sortByVisibleText(String text) {
        Select select = new Select(waitForVisibility(sortList));
        select.selectByVisibleText(text);
    }

    public void addAllProductsToCart() {

        while (!driver.findElements(addToCartButtons).isEmpty()) {

            driver.findElements(addToCartButtons)
                    .get(0)
                    .click();
        }
    }

    public List<Double> getProductPrices() {
        waitForVisibility(productPrices);

        return driver.findElements(productPrices)
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

    public boolean isCartBadgeDisplayed() {
        return !driver.findElements(countCartBadge).isEmpty();
    }

    public int getCartBadgeCount() {
        if (driver.findElements(countCartBadge).isEmpty()) {
            return 0;
        }

        String badgeText = getText(countCartBadge);
        return Integer.parseInt(badgeText);
    }

}