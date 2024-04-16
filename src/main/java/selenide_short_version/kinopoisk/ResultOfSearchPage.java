package selenide_short_version.kinopoisk;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class ResultOfSearchPage {
    public static final String URL="https://www.google.ru/search?q=%D0%9A%D0%B8%D0%BD%D0%BE%D0%BF%D0%BE%D0%B8%D1%81%D0%BA";
    public ElementsCollection searchResultList = $$(xpath("//div[@id='rso']/div/div"));
    public SelenideElement URLonKinoPoisk = $(xpath("//cite[text()='https://www.kinopoisk.ru']"));
    public SelenideElement linkToKinoPoisk =
            $(xpath("//h3[text()='Кинопоиск. Онлайн кинотеатр. Фильмы сериалы ...']"));
}
