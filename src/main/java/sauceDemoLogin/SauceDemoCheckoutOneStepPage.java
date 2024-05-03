package sauceDemoLogin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoCheckoutOneStepPage<P> extends BasePage<SauceDemoCheckoutOneStepPage<P>> {
    P parent;

    public SauceDemoCheckoutOneStepPage(P parent) {
        this.parent = parent;
    }

    public static final String URL = "https://www.saucedemo.com/checkout-step-one.html";
    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement pageTitle = $(xpath("//span[text()='Checkout: Your Information']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public SelenideElement cancelBtn = $(xpath("//button[@id='cancel']"));
    public SelenideElement continueBtn = $(xpath("//input[@name='continue']"));
    public SelenideElement firstNameInputArea = $(xpath("//input[@name='firstName']"));
    public SelenideElement lastNameInputArea = $(xpath("//input[@name='lastName']"));
    public SelenideElement zipInputArea = $(xpath("//input[@name='postalCode']"));
    public SelenideElement errorMessageProblemUser = $(xpath("//h3"));

    @Step("Check all static elements on checkout page")
    public SauceDemoCheckoutOneStepPage checkStaticElemsOnOneCheckStepPage() {
        Assertions.assertEquals("Swag Labs", appLogo.getText());
        Assertions.assertEquals("Checkout: Your Information", pageTitle.getText());
        Assertions.assertTrue(menuBtn.isDisplayed());
        Assertions.assertTrue(shoppingCartLink.isDisplayed());
        Assertions.assertTrue(continueBtn.isDisplayed());
        Assertions.assertTrue(cancelBtn.isDisplayed() && cancelBtn.getText().contains("Cancel"));
        Assertions.assertTrue(firstNameInputArea.isDisplayed());
        Assertions.assertTrue(lastNameInputArea.isDisplayed());
        Assertions.assertTrue(zipInputArea.isDisplayed());
        return this;
    }

    @Step("Click on first name area")
    public SauceDemoCheckoutOneStepPage clickOnFirstNameArea() {
        firstNameInputArea.should(Condition.exist).click();
        return this;
    }

    @Step("Input first name {firstName} in the area")
    public SauceDemoCheckoutOneStepPage setFirstNameArea(String firstName) {
        firstNameInputArea.sendKeys(firstName);
        return this;
    }

    @Step("Click on last name area")
    public SauceDemoCheckoutOneStepPage clickOnLastNameArea() {
        lastNameInputArea.should(Condition.exist).click();
        return this;
    }

    @Step("Input last name {lastName} in the area")
    public SauceDemoCheckoutOneStepPage setValueLastNameArea(String lastName) {
        lastNameInputArea.sendKeys(lastName);
        return this;
    }

    @Step("Click on zip/postal code area")
    public SauceDemoCheckoutOneStepPage clickOnZipArea() {
        zipInputArea.should(Condition.exist).click();
        return this;
    }

    @Step("Input  zip/postal code {zip} in the area")
    public SauceDemoCheckoutOneStepPage setValueZipArea(String zip) {
        zipInputArea.sendKeys(zip);
        return this;
    }

    @Step("Click on 'Continue' button")
    public SauceDemoCheckoutTwoStepPage<SauceDemoCheckoutOneStepPage> clickOnContinueBtnSuccessful() {
        continueBtn.should(Condition.exist).click();
        return new SauceDemoCheckoutTwoStepPage<>(this);
    }

    @Step("Click on 'Continue' button for problem user")
    public SauceDemoCheckoutOneStepPage clickOnContinueBtnUnsuccessful() {
        continueBtn.should(Condition.exist).click();
        Assertions.assertTrue(errorMessageProblemUser.isDisplayed());
        return this;
    }

    @Step("Click on 'Cancel' button")
    public SauceDemoCartPage clickOnCancelBtn() {
        cancelBtn.should(Condition.exist).click();
        return new SauceDemoCartPage(this);
    }
}
