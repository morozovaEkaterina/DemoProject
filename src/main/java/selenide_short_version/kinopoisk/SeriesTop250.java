package selenide_short_version.kinopoisk;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class SeriesTop250 {
    public static final String URL = "https://www.kinopoisk.ru/lists/movies/series-top250/";
    public SelenideElement fullListOfSeriesBtn = $(xpath("//main/div[2]/a[2]"));

    public SelenideElement position = $(xpath("//main/div[3]/div[1]/span"));
    public ElementsCollection listOfSiries = $$(xpath("//main/div[@class='styles_root__ti07r']"));
}
