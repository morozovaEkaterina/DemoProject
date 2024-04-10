import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
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
        Assertions.assertEquals(
                searchList.get(0).findElement(xpath(".//cite")).getText(),
                "https://www.youtube.com");

        WebElement youtubeLink = driver.findElement(xpath(" //h3[text()='YouTube: Home']"));
        Wait<WebDriver> wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait1.until(d -> youtubeLink.isDisplayed());
        youtubeLink.click();

        for (String w : driver.getWindowHandles()) {
            if (!w.equals(driver.getWindowHandle())) {
                driver.switchTo().window(w);
            }
        }
        Assertions.assertEquals("https://www.youtube.com/", driver.getCurrentUrl());
        WebElement youTubeSearch = driver.findElement(xpath("//input[@id='search']"));

        Wait<WebDriver> wait2 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait2.until(d -> youTubeSearch.isDisplayed());
        youTubeSearch.sendKeys("Nicki Minaj");

        WebElement clickNicki = driver.findElement(xpath("//button[@id = 'search-icon-legacy']"));

        Wait<WebDriver> wait3 = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait3.until(d -> clickNicki.isDisplayed());
        clickNicki.click();

        Wait<WebDriver> wait4 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Фильтры']")));


        Assertions.assertEquals("https://www.youtube.com/results?search_query=Nicki+Minaj", driver.getCurrentUrl(),
                "Expected:" + "https://www.youtube.com/results?search_query=Nicki+Minaj" + " actual: " +
                        driver.getCurrentUrl());

        WebElement submit = driver.findElement(xpath("//div[@id='subscribe-button'][contains(@class,'ytd-watch-metadata')]"));
        Assertions.assertTrue(driver.getCurrentUrl().contains(submit.getText()));
    }
}

