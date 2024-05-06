package sauceDemo;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.elementsPackage.SauceDemoCheckoutOneStepElements;
import sauceDemo.methodsPackage.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;


public class SauceDemoCheckoutOneStepSteps<P> extends BasePage<SauceDemoCheckoutOneStepSteps<P>> {
    P parent;
    SauceDemoCheckoutOneStepElements oneStep = new SauceDemoCheckoutOneStepElements();

    public SauceDemoCheckoutOneStepSteps(P parent) {
        this.parent = parent;
    }


    @Step("Check all static elements on checkout page")
    public SauceDemoCheckoutOneStepSteps checkStaticElemsOnOneCheckStepPage() {
        Assertions.assertEquals("Swag Labs", oneStep.appLogo.getText());
        Assertions.assertEquals("Checkout: Your Information", oneStep.pageTitle.getText());
        Assertions.assertTrue(oneStep.menuBtn.isDisplayed());
        Assertions.assertTrue(oneStep.shoppingCartLink.isDisplayed());
        Assertions.assertTrue(oneStep.continueBtn.isDisplayed());
        Assertions.assertTrue(oneStep.cancelBtn.isDisplayed() && oneStep.cancelBtn.getText().contains("Cancel"));
        Assertions.assertTrue(oneStep.firstNameInputArea.isDisplayed());
        Assertions.assertTrue(oneStep.lastNameInputArea.isDisplayed());
        Assertions.assertTrue(oneStep.zipInputArea.isDisplayed());
        return this;
    }

    @Step("Click on first name area")
    public SauceDemoCheckoutOneStepSteps clickOnFirstNameArea() {
        oneStep.firstNameInputArea.should(Condition.exist).click();
        return this;
    }

    @Step("Input first name {firstName} in the area")
    public SauceDemoCheckoutOneStepSteps setFirstNameArea(String firstName) {
        oneStep.firstNameInputArea.sendKeys(firstName);
        return this;
    }

    @Step("Click on last name area")
    public SauceDemoCheckoutOneStepSteps clickOnLastNameArea() {
        oneStep.lastNameInputArea.should(Condition.exist).click();
        return this;
    }

    @Step("Input last name {lastName} in the area")
    public SauceDemoCheckoutOneStepSteps setValueLastNameArea(String lastName) {
        oneStep.lastNameInputArea.sendKeys(lastName);
        return this;
    }

    @Step("Click on zip/postal code area")
    public SauceDemoCheckoutOneStepSteps clickOnZipArea() {
        oneStep.zipInputArea.should(Condition.exist).click();
        return this;
    }

    @Step("Input  zip/postal code {zip} in the area")
    public SauceDemoCheckoutOneStepSteps setValueZipArea(String zip) {
        oneStep.zipInputArea.sendKeys(zip);
        return this;
    }

    @Step("Click on 'Continue' button")
    public SauceDemoCheckoutTwoStepPage<SauceDemoCheckoutOneStepSteps> clickOnContinueBtnSuccessful() {
        oneStep.continueBtn.should(Condition.exist).click();
        return new SauceDemoCheckoutTwoStepPage<>(this);
    }

    @Step("Click on 'Continue' button for problem user")
    public SauceDemoCheckoutOneStepSteps clickOnContinueBtnUnsuccessful() {
        oneStep.continueBtn.should(Condition.exist).click();
        Assertions.assertTrue(oneStep.errorMessageProblemUser.isDisplayed());
        return this;
    }
    @Step("Click on 'Continue' button without inputted first name")
    public SauceDemoCheckoutOneStepSteps clickOnContinueBtnWithoutFirstName() {
        oneStep.continueBtn.should(Condition.exist).click();
        Assertions.assertEquals("Error: First Name is required",$(xpath("//h3")).getText());
        return this;
    }
    @Step("Click on 'Continue' button without inputted last name")
    public SauceDemoCheckoutOneStepSteps clickOnContinueBtnWithoutLastName() {
        oneStep.continueBtn.should(Condition.exist).click();
        Assertions.assertEquals("Error: Last Name is required",$(xpath("//h3")).getText());
        return this;
    }
    @Step("Click on 'Continue' button without inputted zip/Postal Code")
    public SauceDemoCheckoutOneStepSteps clickOnContinueBtnWithoutZip() {
        oneStep.continueBtn.should(Condition.exist).click();
        Assertions.assertEquals("Error: Postal Code is required",$(xpath("//h3")).getText());
        return this;
    }


    @Step("Check errors elements")
    public SauceDemoCheckoutOneStepSteps checkErrorsElements(){
        Assertions.assertTrue(oneStep.errorBtn.isDisplayed());
        Assertions.assertTrue(oneStep.errorInputFields.get(0).isDisplayed());
        Assertions.assertTrue(oneStep.errorInputFields.get(1).isDisplayed());
        Assertions.assertTrue(oneStep.errorInputFields.get(2).isDisplayed());
        return this;
    }

    @Step("Click on 'Cancel' button")
    public SauceDemoCartSteps clickOnCancelBtn() {
        oneStep.cancelBtn.should(Condition.exist).click();
        return new SauceDemoCartSteps(this);
    }
}
