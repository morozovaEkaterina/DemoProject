package sauceDemoTests.elementsCheckoutOnePageTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemo.SauceDemoMainSteps;

public class ContinueBtnWithoutInputtedZipTest {
    @ParameterizedTest
    @CsvSource(value = {"standard_user",
            "visual_user",
            "error_user",
            "performance_glitch_user"})
    public void checkContinueBtnWithoutZip(String username) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        Configuration.browserCapabilities = chromeOptions;
        SauceDemoMainSteps.open("https://www.saucedemo.com")
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
                .clickOnContinueBtnWithoutZip()
                .checkErrorsElements()
                .checkURL("https://www.saucedemo.com/checkout-step-one.html");
    }
}
