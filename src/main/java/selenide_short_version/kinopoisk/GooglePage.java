package selenide_short_version.kinopoisk;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class GooglePage {
    public static final String URL = "https://www.google.ru/";
    public SelenideElement title = $(xpath("//title[text()='Google']"));
    public SelenideElement searchArea = $(xpath("//textarea"));
    public SelenideElement SearchBtn = $(xpath("//input[@value='Поиск в Google']"));
}
