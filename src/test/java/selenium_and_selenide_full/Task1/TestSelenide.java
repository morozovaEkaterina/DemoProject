package selenium_and_selenide_full.Task1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class TestSelenide {

    Switcher switcher = new Switcher();
    private static final String URL = "https://www.youtube.com/results?search_query=";

    @ParameterizedTest
    @CsvSource(value = {"Mr.Beast",
            "Nicki Minaj"})
    public void testYoutube(String name) {
        Configuration.pageLoadTimeout = 100000L;
        open("https://www.google.ru");
        SelenideElement search = $(xpath("//textarea"));
        search.should(exist, visible, clickable).click();
        search.sendKeys("YouTube");

        SelenideElement click = $(xpath("//div[@jsname]//center/input[1]"));
        click.should(exist, visible, clickable).click();
        Assertions.assertTrue(Selenide.webdriver().driver().getWebDriver().getCurrentUrl()
                .contains("https://www.google.ru/search?q=YouTube"));

        ElementsCollection list = $$(xpath("//div[@jscontroller and @lang and @data-hveid]"));
        Assertions.assertEquals("https://www.youtube.com",
                list.get(0).findElement(xpath(".//cite")).getText());
        SelenideElement youTubeLink = $(xpath("//h3[text()='YouTube: Home']"));
        youTubeLink.should(exist, visible, clickable).click();

        switcher.switchOnNewPage(Selenide.webdriver().driver().getWebDriver());

        SelenideElement ytSearcher = $(xpath("//input[@id='search']"));
        ytSearcher.should(exist, visible, clickable).sendKeys(name);
        SelenideElement button = $(xpath("//button[@id = 'search-icon-legacy']"));
        button.should(exist, visible, clickable).click();

        String newName;
        if (name.contains(" ")) {
            newName = name.replace(" ", "+");
        } else {
            return;
        }

        Assertions.assertEquals(URL + newName, Selenide.webdriver().driver().url(),
                "Expected:" + URL + newName + " actual: " +
                        Selenide.webdriver().driver().url());

        SelenideElement submit = $(xpath("//div[@id='subscribe-button'][contains(@class,'ytd-watch-metadata')]"));
        Assertions.assertTrue(Selenide.webdriver().driver().getWebDriver().getCurrentUrl()
                .contains(submit.getText()), "Contains button submit");
    }

    @AfterEach
    public void finish() {
        Selenide.closeWebDriver();
    }
}
