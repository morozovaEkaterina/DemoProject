package selenide_short_version;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import selenide_short_version.kinopoisk.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BaseTest {
    Config cnf = Config.getInstance();

    @AfterEach
    public void closeBrowser() {
        Selenide.closeWebDriver();
    }

    public void tabPage(WebDriver driver) {
        String nowWindow = driver.getWindowHandle();
        Set<String> pages = driver.getWindowHandles();
        List<String> pagesList = new ArrayList<>(pages);
        for (String p : pages) {
            if (!p.equals(nowWindow)) {
                driver.switchTo().window(p);
            }
        }
    }
}
