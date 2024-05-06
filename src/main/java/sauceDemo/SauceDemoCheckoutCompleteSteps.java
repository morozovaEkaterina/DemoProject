package sauceDemo;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.elementsPackage.SauceDemoCheckoutCompleteElements;
import sauceDemo.methodsPackage.BasePage;

public class SauceDemoCheckoutCompleteSteps<P> extends BasePage<SauceDemoCheckoutCompleteSteps<P>> {
    P parent;
    SauceDemoCheckoutCompleteElements completeElements = new SauceDemoCheckoutCompleteElements();

    public SauceDemoCheckoutCompleteSteps(P parent) {
        this.parent = parent;
    }


    @Step("Check all static  elements on checkout complete page")
    public SauceDemoCheckoutCompleteSteps checkStaticElemsOnCheckoutCompletePage() {
        Assertions.assertEquals("Swag Labs", completeElements.appLogo.getText());
        Assertions.assertEquals("Checkout: Complete!", completeElements.pageTitle.getText());
        Assertions.assertTrue(completeElements.menuBtn.isDisplayed());
        Assertions.assertTrue(completeElements.shoppingCartLink.isDisplayed());
        Assertions.assertEquals("Thank you for your order!", completeElements.thankYouText.getText());
        Assertions.assertEquals(
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                completeElements.completeText.getText());
        Assertions.assertTrue(completeElements.backHomeBtn.isDisplayed() && completeElements.backHomeBtn.getText().contains("Back Home"));
        return this;
    }

    @Step("Click on 'Back Home' button")
    public SauceDemoProductsSteps clickOnBackHomePage() {
        completeElements.backHomeBtn.should(Condition.exist).click();
        return new SauceDemoProductsSteps();
    }
}







