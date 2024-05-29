package sauceDemo.steps;

import io.qameta.allure.Step;
import sauceDemo.BaseSteps;
import sauceDemo.page.CheckoutCompletePage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CheckoutCompleteSteps<P> extends BaseSteps<CheckoutCompleteSteps<P>> {
    P parent;
    CheckoutCompletePage completeElements = new CheckoutCompletePage();

    public CheckoutCompleteSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check all static elements  on checkout complete page")
    public CheckoutCompleteSteps<P> checkStaticElemsOnCheckoutCompletePage() {
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
    public AllItemsSteps clickOnBackHomePage() {
        completeElements.backHomeBtn.should(exist).click();
        return new AllItemsSteps();
    }

    @Step("Check is cart empty on the competed page")
    public CheckoutCompleteSteps<P> checkIsCartEmpty() {
        $(xpath("//span[contains(@class,'badge')]")).shouldNot(exist);
        return this;
    }

    @Step("Click on cart button")
    public CartSteps<CheckoutCompleteSteps<P>> clickOnCartBtn() {
        completeElements.shoppingCartLink.should(exist).click();
        return new CartSteps<>(this);
    }
}







