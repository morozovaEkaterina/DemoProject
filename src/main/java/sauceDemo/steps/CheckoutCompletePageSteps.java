package sauceDemo.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.BaseSteps;
import sauceDemo.elements.CheckoutCompleteElements;

import static com.codeborne.selenide.Condition.exist;

public class CheckoutCompletePageSteps<P> extends BaseSteps<CheckoutCompletePageSteps<P>> {
    P parent;
    CheckoutCompleteElements completeElements = new CheckoutCompleteElements();

    public CheckoutCompletePageSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check all static  elements on checkout complete page")
    public CheckoutCompletePageSteps<P> checkStaticElemsOnCheckoutCompletePage() {
        Assertions.assertEquals("Swag Labs", completeElements.appLogo.getText());
        Assertions.assertEquals("Checkout: Complete!", completeElements.pageTitle.getText());
        completeElements.menuBtn.should(exist);
        completeElements.shoppingCartLink.should(exist);
        Assertions.assertEquals("Thank you for your order!", completeElements.thankYouText.getText());
        Assertions.assertEquals(
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                completeElements.completeText.getText());
        Assertions.assertEquals("Back Home", completeElements.backHomeBtn.getText());
        return this;
    }

    @Step("Click on 'Back Home' button")
    public ProductsPageSteps clickOnBackHomePage() {
        completeElements.backHomeBtn.should(exist).click();
        return new ProductsPageSteps();
    }
}







