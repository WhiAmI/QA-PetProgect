package automation.tests;

import automation.base.BaseTest;
import automation.pages.CartPage;
import automation.pages.LoginPage;
import automation.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    private static final String PRODUCTS_TITLE = "Products";

    private ProductsPage login(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        return loginPage.clickLogin();
    }

    @Test
    public void shouldLoginSuccessfully(){

        ProductsPage productsPage = login();

        String actualTitle = productsPage.getProductTitleText();

        Assertions.assertEquals(PRODUCTS_TITLE, actualTitle);
    }

    @Test
    public void shouldAddProductToCart(){
        ProductsPage productsPage = login();
        productsPage.addFirstProductToCart();

        CartPage cartPage = productsPage.goToCart();
        String expectedTitle = cartPage.getTitle();

        String expectedProductName = cartPage.getProductName();
        Assertions.assertEquals("Sauce Labs Backpack", expectedProductName);

        Assertions.assertEquals("Your Cart", expectedTitle);
    }
}
