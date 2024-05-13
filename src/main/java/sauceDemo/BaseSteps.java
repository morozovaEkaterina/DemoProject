package sauceDemo;

import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.sleep;

public abstract class BaseSteps<P> {

    public static final Config config = Config.getInstance();

    @AfterEach
    public void afterEachCloseBrowser() {
        Selenide.closeWebDriver();
    }

    @Step("Check URL {url}")
    public P checkURL(String url) {
        Assertions.assertEquals(url, Selenide.webdriver().driver().url());
        return (P) this;
    }
}
