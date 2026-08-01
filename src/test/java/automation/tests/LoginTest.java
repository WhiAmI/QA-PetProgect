package automation.tests;

import automation.base.BaseTest;
import automation.pages.LoginPage;
import automation.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    @Test
    public void shouldLoginSuccessfully(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        ProductsPage productsPage = loginPage.clickLogin();

        String actualTitle = productsPage.getProductTitleText();

        Assertions.assertEquals("Products", actualTitle);


    }
}
