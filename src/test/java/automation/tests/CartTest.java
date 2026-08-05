package automation.tests;

import automation.base.BaseTest;
import automation.pages.CartPage;
import automation.pages.LoginPage;
import automation.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {
    private static final String CART_TITLE = "Your Cart";
    private static final String PRODUCT_NAME = "Sauce Labs Backpack";

    private ProductsPage productsPage;

    @BeforeEach
    public void setUp() {
        productsPage = login("standard_user", "secret_sauce");
    }

    @Test
    public void shouldAddProductToCart() {
        productsPage.addFirstProductToCart();

        CartPage cartPage = productsPage.goToCart();
        String actualTitle = cartPage.getTitle();
        String actualProductName = cartPage.getProductName();

        Assertions.assertEquals(PRODUCT_NAME, actualProductName);
        Assertions.assertEquals(CART_TITLE, actualTitle);
    }
}
