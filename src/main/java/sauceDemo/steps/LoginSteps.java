package sauceDemo.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemo.BaseSteps;
import sauceDemo.page.LoginPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;

public class LoginSteps extends BaseSteps<LoginSteps> {
    LoginPage mainPageElements = new LoginPage();

    public static final String URL = "https://www.saucedemo.com";

    @Step("Open page {URL}")
    public static LoginSteps open(String URL) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        Configuration.browserCapabilities = chromeOptions;
        Selenide.open(URL);
        return new LoginSteps();
    }

    @Step("Check static elements on the login page")
    public LoginSteps waitPageLoading() {
        mainPageElements.loginBtn.should(value("Login"));
        mainPageElements.inputAreaPassword.should(exist);
        mainPageElements.inputAreaPassword.should(exist);
        mainPageElements.loginLogo.should(text("Swag Labs"));
        return this;
    }

    @Step("Click on username area")
    public LoginSteps clickOnUsernameArea() {
        mainPageElements.inputAreaUserName.should(exist).click();
        return this;
    }

    @Step("Set username {username}")
    public LoginSteps setUsername(String username) {
        mainPageElements.inputAreaUserName.sendKeys(username);
        return this;
    }

    @Step("Check is username inputted in the area")
    public LoginSteps checkIsUsernameInputted(String username) {
        mainPageElements.inputAreaUserName.should(value(username));
        return this;
    }

    @Step("Click on password area")
    public LoginSteps clickOnPasswordArea() {
        mainPageElements.inputAreaPassword.should(exist).click();
        return this;
    }

    @Step("Set password {password} on password area")
    public LoginSteps setPassword(String password) {
        mainPageElements.inputAreaPassword.sendKeys(password);
        return this;
    }

    @Step("Check is password inputted in the area")
    public LoginSteps checkIsPasswordInputted(String password) {
        mainPageElements.inputAreaPassword.should(value(password));
        return this;
    }

    @Step("Successful login. Was inputted username:{username}, password:{password}")
    public LoginSteps successfulLogin(String username, String password) {
        clickOnUsernameArea();
        setUsername(username);
        checkIsUsernameInputted(username);
        clickOnPasswordArea();
        setPassword(password);
        checkIsPasswordInputted(password);
        return this;
    }

    @Step("Click on 'LoginPage' button")
    public AllItemsSteps clickOnLoginBtnSuccessful() {
        mainPageElements.loginBtn.should(exist).click();
        return new AllItemsSteps();
    }

    @Step("Click on 'LoginPage' button")
    public LoginSteps clickOnLoginBtnUnsuccessful() {
        mainPageElements.loginBtn.should(exist).click();
        return this;
    }

    @Step("Check error elements on the page without inputted username ")
    public LoginSteps checkErrorElementsWithoutUsername() {
        mainPageElements.errorText.should(text("Epic sadface: Username is required"));
        mainPageElements.errorBtn.should(exist, clickable);
        mainPageElements.inputErrorForm.should(size(2));
        return this;
    }

    @Step("Check error elements on the page without inputted password ")
    public LoginSteps checkErrorElementsWithoutPassword() {
        mainPageElements.errorText.should(text("Epic sadface: Password is required"));
        mainPageElements.errorBtn.should(exist, clickable);
        mainPageElements.inputErrorForm.should(size(2));
        return this;
    }

    @Step("Check error elements on the page with wrong inputted password  or username")
    public LoginSteps checkErrorElementsWithWrongInputted() {
        mainPageElements.errorText.should(text("Epic sadface: Username and password do not match any user in this service"));
        mainPageElements.errorBtn.should(exist, clickable);
        mainPageElements.inputErrorForm.should(size(2));
        return this;
    }
}