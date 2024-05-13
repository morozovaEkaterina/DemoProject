package sauceDemo.steps;

import io.qameta.allure.Step;
import sauceDemo.BaseSteps;
import sauceDemo.page.CheckoutCompleteElements;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

public class CheckoutCompletePageSteps<P> extends BaseSteps<CheckoutCompletePageSteps<P>> {
    P parent;
    CheckoutCompleteElements completeElements = new CheckoutCompleteElements();

    public CheckoutCompletePageSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check all static  page on checkout complete page")
    public CheckoutCompletePageSteps<P> checkStaticElemsOnCheckoutCompletePage() {
        completeElements.appLogo.should(text("Swag Labs"));
        completeElements.pageTitle.should(text("Checkout: Complete!"));
        completeElements.menuBtn.should(exist);
        completeElements.shoppingCartLink.should(exist);
        completeElements.thankYouText.should(text("Thank you for your order!"));
        completeElements.completeText
                .should(text("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
        completeElements.backHomeBtn.should(text("Back Home"));
        return this;
    }

    @Step("Click on 'Back Home' button")
    public ProductsPageSteps clickOnBackHomePage() {
        completeElements.backHomeBtn.should(exist).click();
        return new ProductsPageSteps();
    }
}







