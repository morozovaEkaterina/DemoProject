package sauceDemo.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.BaseSteps;
import sauceDemo.page.CheckoutOneStepElements;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CheckoutOneStepPageSteps<P> extends BaseSteps<CheckoutOneStepPageSteps<P>> {
    P parent;
    CheckoutOneStepElements oneStep = new CheckoutOneStepElements();

    public CheckoutOneStepPageSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check all static page on checkout page")
    public CheckoutOneStepPageSteps<P> checkStaticElemsOnOneCheckStepPage() {
        oneStep.appLogo.should(text("Swag Labs"));
        oneStep.pageTitle.should(text("Checkout: Your Information"));
        oneStep.menuBtn.should(exist);
        oneStep.shoppingCartLink.should(exist);
        oneStep.cancelBtn.should(text("Cancel"));
        return this;
    }

    @Step("Click on first name area")
    public CheckoutOneStepPageSteps<P> clickOnFirstNameArea() {
        oneStep.firstNameInputArea.should(exist).click();
        return this;
    }

    @Step("Set first name {firstName} in the area")
    public CheckoutOneStepPageSteps<P> setFirstName(String firstName) {
        oneStep.firstNameInputArea.sendKeys(firstName);
        return this;
    }

    @Step("Check is first name inputted in the area")
    public CheckoutOneStepPageSteps<P> checkIsFirstNameInputted(String firstname) {
        oneStep.firstNameInputArea.should(value(firstname));
        return this;
    }

    @Step("Click on last name area")
    public CheckoutOneStepPageSteps<P> clickOnLastNameArea() {
        oneStep.lastNameInputArea.should(exist).click();
        return this;
    }

    @Step("Set last name {lastName} in the area")
    public CheckoutOneStepPageSteps<P> setLastName(String lastName) {
        oneStep.lastNameInputArea.sendKeys(lastName);
        return this;
    }

    @Step("Check is last name {lastName} inputted successful in the area ")
    public CheckoutOneStepPageSteps<P> checkIsLastNameInputtedSuccessful(String lastName) {
        oneStep.lastNameInputArea.should(value(lastName));
        return this;
    }

    @Step("Check is last name {lastName} inputted unsuccessful in the area")
    public CheckoutOneStepPageSteps<P> checkIsLastNameInputtedUnsuccessful(String lastName) {
        oneStep.lastNameInputArea.shouldNotHave(value(lastName));
        return this;
    }

    @Step("Click on zip/postal code area")
    public CheckoutOneStepPageSteps<P> clickOnZipArea() {
        oneStep.zipInputArea.should(exist).click();
        return this;
    }

    @Step("Set zip/postal code {zip} in the area")
    public CheckoutOneStepPageSteps<P> setZip(String zip) {
        oneStep.zipInputArea.sendKeys(zip);
        return this;
    }

    @Step("Check is zip {zip} inputted in the area")
    public CheckoutOneStepPageSteps<P> checkIsZipInputted(String zip) {
        oneStep.zipInputArea.should(value(zip));
        return this;
    }

    @Step("Successful information checkout. Inputted first name: {firstName},last name: {lastName}, zip: {zip}")
    public CheckoutOneStepPageSteps<P> successfulInfoCheckout(String firstName, String lastName, String zip) {
        clickOnFirstNameArea();
        setFirstName(firstName);
        checkIsFirstNameInputted(firstName);
        clickOnLastNameArea();
        setLastName(lastName);
        checkIsLastNameInputtedSuccessful(lastName);
        clickOnZipArea();
        setZip(zip);
        checkIsZipInputted(zip);
        return this;
    }

    @Step("Unsuccessful information checkout for error user. Inputted first name: {firstName},last name: {lastName}, zip: {zip}")
    public CheckoutOneStepPageSteps<P> unSuccessfulInfoCheckoutForErrorUser(String firstName, String lastName, String zip) {
        clickOnFirstNameArea();
        setFirstName(firstName);
        checkIsFirstNameInputted(firstName);
        clickOnLastNameArea();
        setLastName(lastName);
        checkIsLastNameInputtedUnsuccessful(lastName);
        clickOnZipArea();
        setZip(zip);
        checkIsZipInputted(zip);
        return this;
    }

    @Step("Click on 'Continue' button")
    public CheckoutTwoPageSteps<CheckoutOneStepPageSteps<P>> clickOnContinueBtnSuccessful() {
        oneStep.continueBtn.should(exist).click();
        return new CheckoutTwoPageSteps<>(this);
    }

    @Step("Click on 'Continue' button for problem user")
    public CheckoutOneStepPageSteps<P> clickOnContinueBtnUnsuccessful() {
        oneStep.continueBtn.should(exist).click();
        oneStep.errorMessageProblemUser.should(exist);
        return this;
    }

    @Step("Click on 'Continue' button without inputted first name")
    public CheckoutOneStepPageSteps<P> clickOnContinueBtnWithoutFirstName() {
        oneStep.continueBtn.should(exist).click();
        return this;
    }

    @Step("Check click on 'Continue' button without inputted first name")
    public CheckoutOneStepPageSteps<P> checkClickOnContinueBtnWithoutFirstName() {
        Assertions.assertEquals("Error: First Name is required", $(xpath("//h3")).getText());
        return this;
    }

    @Step("Click on 'Continue' button without inputted last name")
    public CheckoutOneStepPageSteps<P> clickOnContinueBtnWithoutLastName() {
        oneStep.continueBtn.should(exist).click();
        return this;
    }

    @Step("Check click on 'Continue' button without inputted last name")
    public CheckoutOneStepPageSteps<P> checkClickOnContinueBtnWithoutLastName() {
        Assertions.assertEquals("Error: Last Name is required", $(xpath("//h3")).getText());
        return this;
    }

    @Step("Check click on 'Continue' button without inputted last name for error user")
    public CheckoutOneStepPageSteps<P> checkClickOnContinueBtnWithoutLastNameErrorUser() {
        Assertions.assertEquals("Error: Postal Code is required", $(xpath("//h3")).getText());
        return this;
    }

    @Step("Click on 'Continue' button without inputted zip/Postal Code")
    public CheckoutOneStepPageSteps<P> clickOnContinueBtnWithoutZip() {
        oneStep.continueBtn.should(exist).click();

        return this;
    }

    @Step("Check click on 'Continue' button without inputted zip")
    public CheckoutOneStepPageSteps<P> checkClickOnContinueBtnWithoutZip() {
        oneStep.continueBtn.should(exist).click();
        Assertions.assertEquals("Error: Postal Code is required", $(xpath("//h3")).getText());
        return this;
    }

    @Step("Check errors page")
    public CheckoutOneStepPageSteps<P> checkErrorsElements() {
        oneStep.errorBtn.should(exist);
        oneStep.errorInputFields.get(0).should(exist);
        oneStep.errorInputFields.get(1).should(exist);
        oneStep.errorInputFields.get(2).should(exist);
        return this;
    }

    @Step("Click on 'Cancel' button")
    public CartPageSteps<CheckoutOneStepPageSteps<P>> clickOnCancelBtn() {
        oneStep.cancelBtn.should(exist).click();
        return new CartPageSteps<>(this);
    }
}
