package sauceDemoLogin;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoMainPage extends BasePage<SauceDemoMainPage> {

    public static final String URL = "https://www.saucedemo.com";
    public SelenideElement loginLogo = $(xpath("//div[@id='root']/div/div[1]"));
    public SelenideElement inputAreaUserName = $(xpath("//input[@placeholder='Username']"));
    public SelenideElement inputAreaPassword = $(xpath("//input[@placeholder='Password']"));
    public SelenideElement loginBtn = $(xpath("//input[@type='submit']"));
    public ElementsCollection inputErrorForm = $$(xpath("//input[@class='input_error form_input error']"));
    public SelenideElement errorText = $(xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']"));
    public SelenideElement errorBtn =$(xpath("//button[@class='error-button']"));

    @Step
    public static SauceDemoMainPage open(String URL) {
        Selenide.open(URL);
        return new SauceDemoMainPage();
    }

    @Step("Check static elements on the page")
    public SauceDemoMainPage checkStaticElements() {
        Assertions.assertTrue(Selenide.webdriver().driver().getWebDriver().getCurrentUrl().contains(loginBtn.getText()));
        Assertions.assertTrue(Selenide.webdriver().driver().getWebDriver().getCurrentUrl().contains(inputAreaPassword.getText()));
        Assertions.assertTrue(Selenide.webdriver().driver().getWebDriver().getCurrentUrl().contains(inputAreaUserName.getText()));
        Assertions.assertEquals("Swag Labs", loginLogo.getText());
        return this;
    }

    @Step("Click on Username area")
    public SauceDemoMainPage clickOnUsernameArea() {
        inputAreaUserName.should(exist).click();
        return this;
    }

    @Step("Set username {username}")
    public SauceDemoMainPage setUsername(String username) {
        inputAreaUserName.sendKeys(username);
        return this;
    }

    @Step("Click on password area")
    public SauceDemoMainPage clickOnPasswordArea() {
        inputAreaPassword.should(exist).click();
        return this;
    }

    @Step("Set password {password} on password area")
    public SauceDemoMainPage setPassword(String password) {
        inputAreaPassword.sendKeys(password);
        return this;
    }

    @Step("Click on Login button")
    public SauceDemoProductsPage clickOnLoginBtnSuccessful() {
        loginBtn.should(exist).click();
        return new SauceDemoProductsPage();
    }

    @Step("Click on Login button")
    public SauceDemoMainPage clickOnLoginBtnUnsuccessful() {
        loginBtn.should(exist).click();
        return this;
    }

    @Step("Check elements in the case of locked out user ")
    public SauceDemoMainPage checkErrorElements(){
         Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", errorText.getText());
         Assertions.assertTrue(errorBtn.is(clickable));
         Assertions.assertEquals(2,inputErrorForm.size());
         return this;
    }
}