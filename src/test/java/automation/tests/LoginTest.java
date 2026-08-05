package automation.tests;

import automation.base.BaseTest;
import automation.pages.LoginPage;
import automation.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    private static final String PRODUCTS_TITLE = "Products";

    @Test
    public void shouldShowErrorWhenUsernameIsInvalid() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.enterUsername("standard_user1");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();

        Assertions.assertEquals(
                "Epic sadface: Username and password do not match any user in this service",
                actualErrorMessage
        );
    }

}
