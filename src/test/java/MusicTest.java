import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.By.xpath;

/*2. Написать второй UI автотест, который заходит в Музыку (https://www.youtube.com/channel/UC-9-kyTW8ZkZNDHQJ6FgpwQ)
 и проверяет, что мы действительно туда зашли и основная статичная информация отображается корректно*/
public class MusicTest {

    WebDriver driver = new ChromeDriver();
    SwitcherForMusic switcher = new SwitcherForMusic();

    @Test
    public void testMusic() {
        driver.get("https://www.google.ru");
        WebElement search = driver.findElement(xpath("//textarea"));
        search.sendKeys("YouTube");

        WebElement button = driver.findElement(xpath("//input[@value='Поиск в Google']"));

        Wait<WebDriver> waitClick = new WebDriverWait(driver, Duration.ofSeconds(2));
        waitClick.until(d -> button.isDisplayed());
        button.click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.google.ru/search?q=YouTube"));

        List<WebElement> listOFWEbs = driver
                .findElements(xpath("//div[@id='rso']/div/div"));

        int s = 0;
        for (int i = 0; i < listOFWEbs.size(); i++) {
            if (listOFWEbs.get(i).getText().contains("https://www.youtube.com")) {
                s = i;
            }
        }
        Assertions.assertEquals("https://www.youtube.com", listOFWEbs.get(s).findElement(xpath(".//cite")).getText());

        WebElement youtube = driver.findElement(xpath("//h3[text()='YouTube: Home']"));
        Wait<WebDriver> waitYT = new WebDriverWait(driver, Duration.ofSeconds(2));
        waitYT.until(d -> youtube.isDisplayed());
        youtube.click();

        switcher.switchPage(driver);

        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.youtube.com"));

        WebElement menu = driver.findElement(xpath(" //button[@aria-label ='Гид']"));
        Wait<WebDriver> waitMenu = new WebDriverWait(driver, Duration.ofSeconds(2));
        waitMenu.until(d -> menu.isDisplayed());
        menu.click();

        WebElement music = driver.findElement(xpath("//a[@title='Музыка']"));
        Wait<WebDriver> waitMusic = new WebDriverWait(driver, Duration.ofSeconds(2));
        waitMusic.until(d -> music.isDisplayed());
        music.click();

        switcher.switchPage(driver);

        Assertions.assertEquals("https://www.youtube.com/channel/UC-9-kyTW8ZkZNDHQJ6FgpwQ",
                driver.getCurrentUrl());

        WebElement name = driver.findElement(xpath("//*[@id='text'][text()='Музыка']"));
        Assertions.assertEquals("Музыка", name.getText());

        WebElement text = driver.findElement(xpath("//div[@id='content' and @dir]"));
        Assertions.assertEquals("На этом канале собраны главные музыкальные новинки, а также видео и плейлисты популярных исполнителей. Подпишитесь и следите за музыкальными трендами во всем мире.",
                text.getText());

        List<WebElement> listOfMainTitles = driver.findElements(xpath("//div[@role='tablist']/yt-tab-shape"));
        Assertions.assertEquals("Главная", listOfMainTitles.get(0).getText());
        Assertions.assertEquals("Сообщество", listOfMainTitles.get(1).getText());

        List<WebElement> listOfTitles = driver.findElements(xpath("//span[@id='title']"));
        Assertions.assertEquals("All The Hits", listOfTitles.get(0).getText());
        Assertions.assertEquals("Mood Music", listOfTitles.get(1).getText());
        Assertions.assertEquals("Unique Performances", listOfTitles.get(2).getText());
        Assertions.assertEquals("Хит-парады", listOfTitles.get(3).getText());
    }

    @AfterEach
    public void finish() {
        driver.quit();
    }
}
