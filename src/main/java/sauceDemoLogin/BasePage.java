package sauceDemoLogin;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class BasePage<P> {

    Config config = Config.getInstance();

    @AfterEach
    public void afterEach() {
        Selenide.closeWebDriver();
    }

    @Step("Switch {driver} on {title}")
    public P switchTabSauceDemo(String title) {
        String nowPageTitle = Selenide.webdriver().driver().getWebDriver().getTitle();
        Set<String> pages = Selenide.webdriver().driver().getWebDriver().getWindowHandles();
        List<String> listOfPages = new ArrayList<>(pages);
        for (String page : listOfPages) {
            if (nowPageTitle.contains(title)) {
                Selenide.webdriver().driver().switchTo().window(page);
            }
        }
        return (P) this ;
    }

    @Step("Check part of URL")
    public P checkPartOfURL(String url){
        Assertions.assertTrue(Selenide.webdriver().driver().url().contains(url));
        return (P)this;
    }

    @Step("Check URL")
    public P checkURL(String url){
        Assertions.assertEquals(url,Selenide.webdriver().driver().url());
        return (P)this;
    }
}
