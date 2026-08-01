package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import automation.pages.ProductsPage;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public ProductsPage clickLogin() {
        driver.findElement(loginButton).click();
        return new ProductsPage(driver);
    }

    public String getUsernameValue() {
        return driver.findElement(usernameField).getAttribute("value");
    }

    public String getPasswordValue() {
        return driver.findElement(passwordField).getAttribute("value");
    }

}
