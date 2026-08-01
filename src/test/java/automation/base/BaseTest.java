package automation.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver; //Для интерфейса абстрактное упр браузером
import org.openqa.selenium.chrome.ChromeDriver; // Конкретная реализация для Хром
import io.github.bonigarcia.wdm.WebDriverManager; //избавляет тебя от ручной установки драйверов
import org.openqa.selenium.firefox.FirefoxDriver;
//Сейчас эта библиотека сама ищет последнюю версию подходящего драйвера, сама его скачивает, сама его запускает

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
