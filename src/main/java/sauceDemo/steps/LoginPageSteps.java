package sauceDemo.steps;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemo.BaseSteps;
import sauceDemo.page.MainPageElements;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

public class LoginPageSteps extends BaseSteps<LoginPageSteps> {
    MainPageElements mainPageElements = new MainPageElements();

    public static final String URL = "https://www.saucedemo.com";

    @Step("Open page {URL} and check static page")
    public static LoginPageSteps open(String URL) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        Configuration.browserCapabilities = chromeOptions;
        Selenide.open(URL);
        return new LoginPageSteps();
    }

    @Step("Check static page")
    public LoginPageSteps waitPageLoading() {
        mainPageElements.loginBtn.should(value("Login"));
        mainPageElements.inputAreaPassword.should(exist);
        mainPageElements.inputAreaPassword.should(exist);
        mainPageElements.loginLogo.should(text("Swag Labs"));
        return this;
    }

    @Step("Click on Username area")
    public LoginPageSteps clickOnUsernameArea() {
        mainPageElements.inputAreaUserName.should(exist).click();
        return this;
    }

    @Step("Set username {username}")
    public LoginPageSteps setUsername(String username) {
        mainPageElements.inputAreaUserName.sendKeys(username);
        return this;
    }

    @Step("Check is username inputted in the area")
    public LoginPageSteps checkIsUsernameInputted(String username) {
        mainPageElements.inputAreaUserName.should(value(username));
        return this;
    }

    @Step("Click on password area")
    public LoginPageSteps clickOnPasswordArea() {
        mainPageElements.inputAreaPassword.should(exist).click();
        return this;
    }

    @Step("Set password {password} on password area")
    public LoginPageSteps setPassword(String password) {
        mainPageElements.inputAreaPassword.sendKeys(password);
        return this;
    }

    @Step("Check is password inputted in the area")
    public LoginPageSteps checkIsPasswordInputted(String password) {
        mainPageElements.inputAreaPassword.should(value(password));
        return this;
    }

    @Step("Successful log in. Inputted username:{username}, password:{password}")
    public LoginPageSteps successfulLogin(String username, String password) {
        clickOnUsernameArea();
        setUsername(username);
        checkIsUsernameInputted(username);
        clickOnPasswordArea();
        setPassword(password);
        checkIsPasswordInputted(password);
        return this;
    }

    @Step("Click on Login button")
    public ProductsPageSteps clickOnLoginBtnSuccessful() {
        mainPageElements.loginBtn.should(exist).click();
        return new ProductsPageSteps();
    }

    @Step("Click on Login button")
    public LoginPageSteps clickOnLoginBtnUnsuccessful() {
        mainPageElements.loginBtn.should(exist).click();
        return this;
    }

    @Step("Check page in the case of locked out user ")
    public LoginPageSteps checkErrorElements() {
        mainPageElements.errorText.should(text("Epic sadface: Sorry, this user has been locked out."));
        mainPageElements.errorBtn.should(exist, clickable);
        mainPageElements.inputErrorForm.should(size(2));
        return this;
    }
}