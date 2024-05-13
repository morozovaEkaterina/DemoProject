package sauceDemo.steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import sauceDemo.BaseSteps;
import sauceDemo.page.CheckoutTwoElements;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

public class CheckoutTwoPageSteps<P> extends BaseSteps<CheckoutTwoPageSteps<P>> {
    P parent;
    CheckoutTwoElements checkoutTwo = new CheckoutTwoElements();

    public CheckoutTwoPageSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check all static page on checkout overview page")
    public CheckoutTwoPageSteps<P> checkStaticElemsOnTwoCheckStepPage() {
        checkoutTwo.pageTitle.should(text("Checkout: Overview"));
        checkoutTwo.menuBtn.should(exist);
        checkoutTwo.shoppingCartLink.should(exist);
        checkoutTwo.cancelBtn.should(text("Cancel"));
        checkoutTwo.finishBtn.should(text("Finish"));
        checkoutTwo.infoLabels.get(0).should(text("Payment Information:"));
        checkoutTwo.infoLabels.get(1).should(text("Shipping Information:"));
        checkoutTwo.infoLabels.get(2).should(text("Price Total"));
        checkoutTwo.totalLabel.should(Condition.text("Total: $"));

        return this;
    }

    @Step("Click on cancel button")
    public ProductsPageSteps clickOnCancelBtn() {
        checkoutTwo.cancelBtn.should(exist).click();
        return new ProductsPageSteps();
    }

    @Step("Successful click on finish button")
    public CheckoutCompletePageSteps<CheckoutTwoPageSteps<P>> clickOnFinishBtnCompletePageSuccessful() {
        checkoutTwo.finishBtn.should(exist).click();
        return new CheckoutCompletePageSteps<>(this);
    }

    @Step("Unsuccessful Click on finish button")
    public CheckoutTwoPageSteps<P> clickOnFinishBtnCompletePageUnsuccessful() {
        checkoutTwo.finishBtn.should(exist).click();
        return this;
    }
}
