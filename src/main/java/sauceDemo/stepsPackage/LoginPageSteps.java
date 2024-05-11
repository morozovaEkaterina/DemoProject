package sauceDemo.stepsPackage;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeOptions;
import sauceDemo.BaseSteps;
import sauceDemo.elementsPackage.MainPageElements;

import static com.codeborne.selenide.Condition.*;

public class LoginPageSteps extends BaseSteps<LoginPageSteps> {
    MainPageElements mainPageElements = new MainPageElements();

    public static final String URL = "https://www.saucedemo.com";

    @Step("Open page {URL} and check static elements")
    public static LoginPageSteps open(String URL) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest");
        Configuration.browserCapabilities = chromeOptions;
        Selenide.open(URL);
        return new LoginPageSteps();
    }

    @Step("Check static elements")
    public LoginPageSteps waitPageLoading() {
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
    public LoginPageSteps clickOnUsernameArea() {
        mainPageElements.inputAreaUserName.should(exist).click();
        return this;
    }

    @Step("Set username {username}")
    public LoginPageSteps setUsername(String username) {
        mainPageElements.inputAreaUserName.sendKeys(username);
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

    @Step("Successful log in. Inputted username:{username}, password:{password}")
    public LoginPageSteps successfulLogin(String username, String password) {
        clickOnUsernameArea();
        setUsername(username);
        clickOnPasswordArea();
        setPassword(password);
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

    @Step("Check elements in the case of locked out user ")
    public LoginPageSteps checkErrorElements() {
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", mainPageElements.errorText.getText());
        Assertions.assertTrue(mainPageElements.errorBtn.is(clickable));
        Assertions.assertEquals(2, mainPageElements.inputErrorForm.size());
        return this;
    }
}