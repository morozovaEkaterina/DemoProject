package sauceDemoTests.checkoutPersonalInfoTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests on 'Continue' button and input fields on the personal info page")
public class CheckInputtingOnFieldsTest extends BaseTest {
    @DisplayName("Check 'Continue' button with full inputted info in the fields")
    @Test
    public void checkInputInfoOnCheckoutPersonPage() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .successfulPersonalInfoCheckout("Masha", "Ol", "dfk56")
                .clickOnContinueBtnSuccessful()
                .checkURL("https://www.saucedemo.com/checkout-step-two.html");
    }

    @DisplayName("Check 'Continue' button without inputted zip/postal code ")
    @Test
    public void checkContinueBtnWithoutZip() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .clickOnFirstNameArea()
                .setFirstName("Masha")
                .checkIsFirstNameInputted("Masha")
                .clickOnLastNameArea()
                .setLastName("Popova")
                .checkIsLastNameInputted("Popova")
                .clickOnContinueBtnWithoutZip()
                .checkClickOnContinueBtnWithoutZip()
                .checkErrorsElements()
                .checkURL("https://www.saucedemo.com/checkout-step-one.html");
    }

    @DisplayName("Check 'Continue' button without inputted first name or without inputted in the all fields")
    @Test
    public void checkContinueBtnWithoutFirstNameOrAllFields() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .clickOnContinueBtnWithoutFirstName()
                .checkClickOnContinueBtnWithoutFirstName()
                .checkErrorsElements()
                .checkURL("https://www.saucedemo.com/checkout-step-one.html");
    }

    @DisplayName("Check 'Continue' button without inputted last name")
    @Test
    public void checkContinueBtnWithoutLastName() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .clickOnCartBtn()
                .checkStaticElementsOnCartPage()
                .clickOnCheckoutBtn()
                .checkStaticElemsOnPersonalInfoPage()
                .clickOnFirstNameArea()
                .setFirstName("Masha")
                .checkIsFirstNameInputted("Masha")
                .clickOnZipArea()
                .setZip("cv784")
                .checkIsZipInputted("cv784")
                .clickOnContinueBtnWithoutLastName()
                .checkClickOnContinueBtnWithoutLastName()
                .checkErrorsElements()
                .checkURL("https://www.saucedemo.com/checkout-step-one.html");
    }
}


