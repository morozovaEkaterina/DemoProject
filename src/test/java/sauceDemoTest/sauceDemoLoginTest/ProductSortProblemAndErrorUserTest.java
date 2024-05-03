package sauceDemoTest.sauceDemoLoginTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemoLogin.SauceDemoMainPage;

public class ProductSortProblemAndErrorUserTest {

    @ParameterizedTest
    @CsvSource(value = {"problem_user",
            "error_user",
    })
    public void checkSortProduct(String username) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        Configuration.browserCapabilities = chromeOptions;
        SauceDemoMainPage.open("https://www.saucedemo.com")
                .checkStaticElements()
                .clickOnUsernameArea()
                .setUsername(username)
                .clickOnPasswordArea()
                .setPassword("secret_sauce")
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnProductPage()
                .clickOnSortBtn()
                .checkSortMenu()
                .checkZANameForErrorAndProblemUser()
                .checkAZName()
                .checkPriceHighToLowForErrorAndProblemUser()
                .checkPriceLowToHighForErrorAndProblemUser();
    }
}
