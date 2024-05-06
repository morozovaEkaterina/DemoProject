package sauceDemo;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import org.junit.jupiter.api.Assertions;
import sauceDemo.elementsPackage.SauceDemoMainPageElements;
import sauceDemo.methodsPackage.BasePage;

import static com.codeborne.selenide.Condition.*;

public class SauceDemoMainSteps extends BasePage<SauceDemoMainSteps> {
    SauceDemoMainPageElements mainPageElements = new SauceDemoMainPageElements();

    public static final String URL = "https://www.saucedemo.com";
    @Step
    public static SauceDemoMainSteps open(String URL) {
        Selenide.open(URL);
        return new SauceDemoMainSteps();
    }

    @Step("Check static elements on the page")
    public SauceDemoMainSteps checkStaticElements() {
        Assertions.assertTrue(Selenide.webdriver().driver().getWebDriver().getCurrentUrl()
                .contains(mainPageElements.loginBtn.getText()));
        Assertions.assertTrue(Selenide.webdriver().driver().getWebDriver().getCurrentUrl()
                .contains(mainPageElements.inputAreaPassword.getText()));
        Assertions.assertTrue(Selenide.webdriver().driver().getWebDriver().getCurrentUrl()
                .contains(mainPageElements.inputAreaUserName.getText()));
        Assertions.assertEquals("Swag Labs", mainPageElements.loginLogo.getText());
        return this;
    }

    @Step("Click on Username area")
    public SauceDemoMainSteps clickOnUsernameArea() {
        mainPageElements.inputAreaUserName.should(exist).click();
        return this;
    }

    @Step("Set username {username}")
    public SauceDemoMainSteps setUsername(String username) {
        mainPageElements.inputAreaUserName.sendKeys(username);
        return this;
    }

    @Step("Click on password area")
    public SauceDemoMainSteps clickOnPasswordArea() {
        mainPageElements.inputAreaPassword.should(exist).click();
        return this;
    }

    @Step("Set password {password} on password area")
    public SauceDemoMainSteps setPassword(String password) {
        mainPageElements.inputAreaPassword.sendKeys(password);
        return this;
    }

    @Step("Click on Login button")
    public SauceDemoProductsSteps clickOnLoginBtnSuccessful() {
        mainPageElements.loginBtn.should(exist).click();
        return new SauceDemoProductsSteps();
    }

    @Step("Click on Login button")
    public SauceDemoMainSteps clickOnLoginBtnUnsuccessful() {
        mainPageElements.loginBtn.should(exist).click();
        return this;
    }

    @Step("Check elements in the case of locked out user ")
    public SauceDemoMainSteps checkErrorElements() {
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", mainPageElements.errorText.getText());
        Assertions.assertTrue(mainPageElements.errorBtn.is(clickable));
        Assertions.assertEquals(2, mainPageElements.inputErrorForm.size());
        return this;
    }
}