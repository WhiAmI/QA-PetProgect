package automation.pages;

import automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By errorMessage = By.cssSelector("[data-test='error']");

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLogin(){
        click(loginButton);
    }

    public ProductsPage loginAs(String username, String password){
        open();

        enterUsername(username);
        enterPassword(password);

        clickLogin();

        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }


    public String getUsernameValue() {
        return getValue(usernameField);

    }

    public String getPasswordValue() {
        return getValue(passwordField);
    }

}
