package sauceDemo;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.steps.WrapMenuSteps;

public abstract class BaseSteps<P> extends WrapMenuSteps<P> {

    public static final Config config = Config.getInstance();

    @Step("Check URL {url}")
    public P checkURL(String url) {
        Assertions.assertEquals(url, Selenide.webdriver().driver().url());
        return (P) this;
    }
}
