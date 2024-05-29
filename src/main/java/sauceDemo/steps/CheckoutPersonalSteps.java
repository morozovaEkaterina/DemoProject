package sauceDemo.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.BaseSteps;
import sauceDemo.page.CheckoutPersonPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CheckoutPersonalSteps<P> extends BaseSteps<CheckoutPersonalSteps<P>> {
    P parent;
    CheckoutPersonPage personal = new CheckoutPersonPage();

    public CheckoutPersonalSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check all static elements on checkout page")
    public CheckoutPersonalSteps<P> checkStaticElemsOnPersonalInfoPage() {
        personal.appLogo.should(text("Swag Labs"));
        personal.pageTitle.should(text("Checkout: Your Information"));
        personal.menuBtn.should(exist);
        personal.shoppingCartLink.should(exist);
        personal.cancelBtn.should(text("Cancel"));
        return this;
    }

    @Step("Click on 'first name' area")
    public CheckoutPersonalSteps<P> clickOnFirstNameArea() {
        personal.firstNameInputArea.should(exist).click();
        return this;
    }

    @Step("Set first name {firstName} in the area")
    public CheckoutPersonalSteps<P> setFirstName(String firstName) {
        personal.firstNameInputArea.sendKeys(firstName);
        return this;
    }

    @Step("Check is first name {firstname} inputted in the area")
    public CheckoutPersonalSteps<P> checkIsFirstNameInputted(String firstname) {
        personal.firstNameInputArea.should(value(firstname));
        return this;
    }

    @Step("Click on 'Last name' area")
    public CheckoutPersonalSteps<P> clickOnLastNameArea() {
        personal.lastNameInputArea.should(exist).click();
        return this;
    }

    @Step("Set last name {lastName} in the area")
    public CheckoutPersonalSteps<P> setLastName(String lastName) {
        personal.lastNameInputArea.sendKeys(lastName);
        return this;
    }

    @Step("Check is last name {lastName} inputted successful in the area ")
    public CheckoutPersonalSteps<P> checkIsLastNameInputted(String lastName) {
        personal.lastNameInputArea.should(value(lastName));
        return this;
    }

    @Step("Click on zip/postal code area")
    public CheckoutPersonalSteps<P> clickOnZipArea() {
        personal.zipInputArea.should(exist).click();
        return this;
    }

    @Step("Set zip/postal code {zip} in the area")
    public CheckoutPersonalSteps<P> setZip(String zip) {
        personal.zipInputArea.sendKeys(zip);
        return this;
    }

    @Step("Check is zip {zip} inputted in the area")
    public CheckoutPersonalSteps<P> checkIsZipInputted(String zip) {
        personal.zipInputArea.should(value(zip));
        return this;
    }

    @Step("Successful information checkout. Inputted first name: {firstName},last name: {lastName}, zip: {zip}")
    public CheckoutPersonalSteps<P> successfulPersonalInfoCheckout(String firstName, String lastName, String zip) {
        clickOnFirstNameArea();
        setFirstName(firstName);
        checkIsFirstNameInputted(firstName);
        clickOnLastNameArea();
        setLastName(lastName);
        checkIsLastNameInputted(lastName);
        clickOnZipArea();
        setZip(zip);
        checkIsZipInputted(zip);
        return this;
    }

    @Step("Click on 'Continue' button")
    public CheckoutItemSteps<CheckoutPersonalSteps<P>> clickOnContinueBtnSuccessful() {
        personal.continueBtn.should(exist).click();
        return new CheckoutItemSteps<>(this);
    }


    @Step("Click on 'Continue' button without inputted 'first name'")
    public CheckoutPersonalSteps<P> clickOnContinueBtnWithoutFirstName() {
        personal.continueBtn.should(exist).click();
        return this;
    }

    @Step("Check click on 'Continue' button without inputted 'first name'")
    public CheckoutPersonalSteps<P> checkClickOnContinueBtnWithoutFirstName() {
        Assertions.assertEquals("Error: First Name is required", $(xpath("//h3")).getText());
        return this;
    }

    @Step("Click on 'Continue' button without inputted 'last name'")
    public CheckoutPersonalSteps<P> clickOnContinueBtnWithoutLastName() {
        personal.continueBtn.should(exist).click();
        return this;
    }

    @Step("Check click on 'Continue' button without inputted 'last name'")
    public CheckoutPersonalSteps<P> checkClickOnContinueBtnWithoutLastName() {
        Assertions.assertEquals("Error: Last Name is required", $(xpath("//h3")).getText());
        return this;
    }


    @Step("Click on 'Continue' button without inputted 'zip/Postal Code'")
    public CheckoutPersonalSteps<P> clickOnContinueBtnWithoutZip() {
        personal.continueBtn.should(exist).click();

        return this;
    }

    @Step("Check click on 'Continue' button without inputted 'zip/Postal Code'")
    public CheckoutPersonalSteps<P> checkClickOnContinueBtnWithoutZip() {
        personal.continueBtn.should(exist).click();
        Assertions.assertEquals("Error: Postal Code is required", $(xpath("//h3")).getText());
        return this;
    }

    @Step("Check errors page")
    public CheckoutPersonalSteps<P> checkErrorsElements() {
        personal.errorBtn.should(exist);
        personal.errorInputFields.get(0).should(exist);
        personal.errorInputFields.get(1).should(exist);
        personal.errorInputFields.get(2).should(exist);
        return this;
    }

    @Step("Click on 'Cancel' button")
    public CartSteps<CheckoutPersonalSteps<P>> clickOnCancelBtn() {
        personal.cancelBtn.should(exist).click();
        return new CartSteps<>(this);
    }
}
