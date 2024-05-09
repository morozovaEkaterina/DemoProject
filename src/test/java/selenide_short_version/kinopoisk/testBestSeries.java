package selenide_short_version.kinopoisk;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenide_short_version.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;

//Зайти на Кинопоиске и проверить, что первый сериал в списке "250 лучших среиалов", Во все тяжкие

public class testBestSeries extends BaseTest {
    @Test
    public void check() {
        GooglePage googlePage = new GooglePage();
        ResultOfSearchPage resultOfSearchPage = new ResultOfSearchPage();
        KinoPoiskMain kinoPoiskMain = new KinoPoiskMain();
        SeriesPage seriesPage = new SeriesPage();
        SeriesTop250 top250Series = new SeriesTop250();

        open(GooglePage.URL);
        googlePage.searchArea.sendKeys("Кинопоиск");
        googlePage.SearchBtn.should(exist, clickable).click();
        Assertions.assertTrue(Selenide.webdriver().driver().url()
                .contains(ResultOfSearchPage.URL));

        Assertions.assertTrue(resultOfSearchPage.searchResultList.get(0).getText()
                .contains(resultOfSearchPage.URLonKinoPoisk.getText()));
        resultOfSearchPage.linkToKinoPoisk.should(exist).click();

        switchTab(Selenide.webdriver().driver().getWebDriver(), Selenide.webdriver().driver().getWebDriver().getTitle());
        Assertions.assertTrue(Selenide.webdriver().driver().url().contains(KinoPoiskMain.URL), "Actual URL: "
                + Selenide.webdriver().driver().url() + " contains part: " + KinoPoiskMain.URL);

        kinoPoiskMain.seriesBtn.should(exist, visible).click();
        Assertions.assertEquals(SeriesPage.URL, Selenide.webdriver().driver().url());
        seriesPage.collectionOfLists.get(1).should(exist).click();
        top250Series.fullListOfSeriesBtn.should(exist);
        Assertions.assertEquals(SeriesTop250.URL, Selenide.webdriver().driver().url());

        top250Series.fullListOfSeriesBtn.should(visible, clickable).click();
        Assertions.assertTrue(top250Series.listOfSiries.get(0).getText().contains("Во все тяжкие"),
                "Во все тяжкие on the first position");
    }
}
