package sauceDemoTest.sauceDemoLoginTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemoLogin.SauceDemoMainPage;

public class CancelButtonOnCheckoutSecondStepTest {

    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "error_user",
            "performance_glitch_user"})
    public void CheckInputInfoOnCheckoutPage(String username) {
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
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnOneCheckStepPage()
                .clickOnFirstNameArea()
                .setFirstNameArea("Masha")
                .clickOnLastNameArea()
                .setValueLastNameArea("Popova")
                .clickOnZipArea()
                .setValueZipArea("gbfb6464")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnCancelBtn()
                .checkURL("https://www.saucedemo.com/inventory.html");
    }
}
