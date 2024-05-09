package selenide_short_version.kinopoisk;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SeriesPage {
    public static final String URL = "https://www.kinopoisk.ru/lists/categories/movies/3/";
    public ElementsCollection collectionOfLists = $$(xpath("//div[contains(@class,'styles_content')]//a"));
}
