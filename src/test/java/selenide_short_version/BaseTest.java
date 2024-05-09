package selenide_short_version;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
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

    public void switchTab(WebDriver driver, String title) {
        String nowWindow = driver.getTitle();
        Set<String> pages = driver.getWindowHandles();
        List<String> pagesList = new ArrayList<>(pages);
        for (String p : pagesList) {
            if (nowWindow.contains(title)) {
                driver.switchTo().window(p);
            }
        }
    }
}
