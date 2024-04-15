import com.codeborne.selenide.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

/*2. Написать второй UI автотест, который заходит в Музыку (https://www.youtube.com/channel/UC-9-kyTW8ZkZNDHQJ6FgpwQ)
 и проверяет, что мы действительно туда зашли и основная статичная информация отображается корректно*/

public class MusicSelenide {
    SwitcherForMusic switcher = new SwitcherForMusic();


    @Test
    public void musicTest() {
        Configuration.pageLoadTimeout = 100000L;
        open("https://www.google.ru");
        SelenideElement search = $(xpath("//textarea"));
        search.sendKeys("YouTube");
        SelenideElement searchbtn = $(xpath("//input[@value='Поиск в Google']"));
        searchbtn.click();

        ElementsCollection listOFWEbs = $$(xpath("//div[@id='rso']/div/div"));

        int s = 0;
        for (int i = 0; i < listOFWEbs.size(); i++) {
            if (listOFWEbs.get(i).getText().contains("https://www.youtube.com")) {
                s = i;
            }
        }
        Assertions.assertEquals("https://www.youtube.com", listOFWEbs.get(s).findElement(xpath(".//cite")).getText());

        SelenideElement yt = $(xpath("//h3[text()='YouTube: Home']"));
        yt.click();
        switcher.switchPage(webdriver().driver().getWebDriver());
        Assertions.assertTrue(webdriver().driver().url().contains("https://www.youtube.com"));

        SelenideElement menu = $(xpath("//button[@aria-label ='Гид']"));
        menu.should(clickable, exist).click();
        SelenideElement musicBtn = $(xpath("//a[@title='Музыка']"));

        if (!musicBtn.is(hidden)) {
            musicBtn.click();
        } else {
            return;
        }

        switcher.switchPage(webdriver().driver().getWebDriver());

        Assertions.assertEquals("https://www.youtube.com/channel/UC-9-kyTW8ZkZNDHQJ6FgpwQ",
                webdriver().driver().url());

        Assertions.assertEquals("Музыка", $(xpath("//*[@id='text'][text()='Музыка']")).getText());
        Assertions.assertEquals("На этом канале собраны главные музыкальные новинки, а также видео и плейлисты популярных исполнителей. Подпишитесь и следите за музыкальными трендами во всем мире.",
                $(xpath("//div[@id='content' and @dir]")).getText());

        ElementsCollection listOfMainTitles = $$((xpath("//div[@role='tablist']/yt-tab-shape")));
        Assertions.assertEquals("Главная", listOfMainTitles.get(0).getText());
        Assertions.assertEquals("Сообщество", listOfMainTitles.get(1).getText());

        ElementsCollection listOfTitles = $$(xpath("//span[@id='title']"));
        Assertions.assertEquals("All The Hits", listOfTitles.get(0).getText());
        Assertions.assertEquals("Mood Music", listOfTitles.get(1).getText());
        Assertions.assertEquals("Unique Performances", listOfTitles.get(2).getText());
        Assertions.assertEquals("Хит-парады", listOfTitles.get(3).getText());
    }

    @AfterEach
    public void finish() {
        Selenide.closeWebDriver();
    }
}
