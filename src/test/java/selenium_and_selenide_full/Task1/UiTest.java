package selenium_and_selenide_full.Task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.By.xpath;


public class UiTest {

    WebDriver driver = new ChromeDriver();
    Switcher switcher = new Switcher();
    private static final String URL = "https://www.youtube.com/results?search_query=";


    @ParameterizedTest
    @CsvSource(value = {"Mr.Beast",
            "Nicki Minaj"})
    public void test(String name) {
        driver.get("https://www.google.ru");
        WebElement finder = driver.findElement(By.xpath("//textarea"));
        finder.sendKeys("YouTube");
        WebElement search = driver.findElement(By.xpath("//div[@jsname]//center/input[1]"));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> search.isDisplayed());

        search.click();

        Assertions.assertTrue(driver.getCurrentUrl().contains("https://www.google.ru/search?q=YouTube"));

        List<WebElement> searchList = driver.findElements(
                By.xpath("//div[@jscontroller and @lang and @data-hveid]"));
        Assertions.assertEquals("https://www.youtube.com",
                searchList.get(0).findElement(xpath(".//cite")).getText());

        WebElement youtubeLink = driver.findElement(xpath("//h3[text()='YouTube: Home']"));
        Wait<WebDriver> wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait1.until(d -> youtubeLink.isDisplayed());
        youtubeLink.click();

        switcher.switchOnNewPage(driver);

        Assertions.assertEquals("https://www.youtube.com/", driver.getCurrentUrl());
        WebElement youTubeSearch = driver.findElement(xpath("//input[@id='search']"));

        Wait<WebDriver> wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait2.until(d -> youTubeSearch.isDisplayed());
        youTubeSearch.sendKeys(name);

        WebElement clickNicki = driver.findElement(xpath("//button[@id = 'search-icon-legacy']"));

        Wait<WebDriver> wait3 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait3.until(d -> clickNicki.isDisplayed());
        clickNicki.click();

        Wait<WebDriver> wait4 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Фильтры']")));

        String newName;
        if (name.contains(" ")) {
            newName = name.replace(" ", "+");
        } else {
            return;
        }
        Assertions.assertEquals(URL + newName, driver.getCurrentUrl(),
                "Expected:" + URL + name + " actual: " +
                        driver.getCurrentUrl());

        WebElement submit = driver.findElement(xpath("//div[@id='subscribe-button'][contains(@class,'ytd-watch-metadata')]"));
        Assertions.assertTrue(driver.getCurrentUrl().contains(submit.getText()), "Contains button submit");
    }

    @AfterEach
    public void finish() {
        driver.quit();
    }
}

