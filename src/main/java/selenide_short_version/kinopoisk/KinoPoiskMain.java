package selenide_short_version.kinopoisk;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class KinoPoiskMain {
    public static final String URL = "https://www.kinopoisk.ru/?";
    public SelenideElement title =
            $(xpath("//title[text()='Кинопоиск. Онлайн кинотеатр. Фильмы сериалы мультфильмы и энциклопедия']"));
    public ElementsCollection navigationMenu = $$(xpath("//nav[contains(@class,'styles_navigationMenu')]"));
    public SelenideElement seriesBtn = $(xpath("//div[contains(@class,'styles_sticky')]//nav//ul//li[@data-tid][4]"));
}
