package sauceDemoTests.elementsCheckoutTwoPageTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemo.SauceDemoMainSteps;

public class FinishButtonOnTwoStepPageErrorUserTest {
    @ParameterizedTest
    @CsvSource(value = {
            "error_user"})
    public void checkClickOnFinishBtnTwoStepPage(String username) {
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
                .clickOnZipArea()
                .setValueZipArea("gbfb6464")
                .clickOnContinueBtnSuccessful()
                .checkStaticElemsOnTwoCheckStepPage()
                .clickOnFinishBtnCompletePageUnsuccessful()
                .checkURL("https://www.saucedemo.com/checkout-step-two.html");
    }
}


