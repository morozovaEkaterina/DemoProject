package sauceDemo.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.BaseSteps;
import sauceDemo.elements.CheckoutOneStepElements;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;


public class CheckoutOneStepPageSteps<P> extends BaseSteps<CheckoutOneStepPageSteps<P>> {
    P parent;
    CheckoutOneStepElements oneStep = new CheckoutOneStepElements();

    public CheckoutOneStepPageSteps(P parent) {
        this.parent = parent;
    }


    @Step("Check all static elements on checkout page")
    public CheckoutOneStepPageSteps<P> checkStaticElemsOnOneCheckStepPage() {
        Assertions.assertEquals("Swag Labs", oneStep.appLogo.getText());
        Assertions.assertEquals("Checkout: Your Information", oneStep.pageTitle.getText());
        oneStep.menuBtn.should(exist);
        oneStep.shoppingCartLink.should(exist);
        Assertions.assertEquals("Cancel", oneStep.cancelBtn.getText());
        return this;
    }

    @Step("Click on first name area")
    public CheckoutOneStepPageSteps<P> clickOnFirstNameArea() {
        oneStep.firstNameInputArea.should(exist).click();
        return this;
    }

    @Step("Input first name {firstName} in the area")
    public CheckoutOneStepPageSteps<P> setFirstNameArea(String firstName) {
        oneStep.firstNameInputArea.sendKeys(firstName);
        return this;
    }

    @Step("Click on last name area")
    public CheckoutOneStepPageSteps<P> clickOnLastNameArea() {
        oneStep.lastNameInputArea.should(exist).click();
        return this;
    }

    @Step("Input last name {lastName} in the area")
    public CheckoutOneStepPageSteps<P> setValueLastNameArea(String lastName) {
        oneStep.lastNameInputArea.sendKeys(lastName);
        return this;
    }

    @Step("Click on zip/postal code area")
    public CheckoutOneStepPageSteps<P> clickOnZipArea() {
        oneStep.zipInputArea.should(exist).click();
        return this;
    }

    @Step("Input  zip/postal code {zip} in the area")
    public CheckoutOneStepPageSteps<P> setValueZipArea(String zip) {
        oneStep.zipInputArea.sendKeys(zip);
        return this;
    }

    @Step("Successful information checkout. Inputted first name: {firstName},last name: {lastName}, zip: {zip}")
    public CheckoutOneStepPageSteps<P> successfulInfoCheckout(String firstName, String lastName, String zip) {
        clickOnFirstNameArea();
        setFirstNameArea(firstName);
        clickOnLastNameArea();
        setValueLastNameArea(lastName);
        clickOnZipArea();
        setValueZipArea(zip);
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
        Assertions.assertEquals("Error: First Name is required", $(xpath("//h3")).getText());
        return this;
    }

    @Step("Click on 'Continue' button without inputted last name")
    public CheckoutOneStepPageSteps<P> clickOnContinueBtnWithoutLastName() {
        oneStep.continueBtn.should(exist).click();
        Assertions.assertEquals("Error: Last Name is required", $(xpath("//h3")).getText());
        return this;
    }

    @Step("Click on 'Continue' button without inputted zip/Postal Code")
    public CheckoutOneStepPageSteps<P> clickOnContinueBtnWithoutZip() {
        oneStep.continueBtn.should(exist).click();
        Assertions.assertEquals("Error: Postal Code is required", $(xpath("//h3")).getText());
        return this;
    }


    @Step("Check errors elements")
    public CheckoutOneStepPageSteps<P> checkErrorsElements() {
        oneStep.errorBtn.should(exist);
        oneStep.errorInputFields.get(0).should(exist);
        oneStep.errorInputFields.get(1).should(exist);
        oneStep.errorInputFields.get(2).should(exist);
        return this;
    }

    @Step("Click on 'Cancel' button")
    public CartPageSteps<P> clickOnCancelBtn() {
        oneStep.cancelBtn.should(exist).click();
        return new CartPageSteps(this);
    }
}
