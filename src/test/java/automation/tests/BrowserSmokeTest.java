package automation.tests;

import automation.base.BaseTest;
import org.junit.jupiter.api.Test;

public class BrowserSmokeTest extends BaseTest {
    @Test
    public void openBrowserGoogle(){
        driver.get("https://google.com");
    }
}
