package sauceDemo.stepsPackage;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.BaseSteps;
import sauceDemo.elementsPackage.CheckoutTwoElements;

import static com.codeborne.selenide.Condition.exist;

public class CheckoutTwoPageSteps<P> extends BaseSteps<CheckoutTwoPageSteps<P>> {
    P parent;
    CheckoutTwoElements checkoutTwo = new CheckoutTwoElements();

    public CheckoutTwoPageSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check all static elements on checkout overview page")
    public CheckoutTwoPageSteps<P> checkStaticElemsOnTwoCheckStepPage() {
        Assertions.assertEquals("Checkout: Overview", checkoutTwo.pageTitle.getText());
        checkoutTwo.menuBtn.should(exist);
        checkoutTwo.shoppingCartLink.should(exist);
        Assertions.assertEquals("Cancel", checkoutTwo.cancelBtn.getText());
        Assertions.assertEquals("Finish", checkoutTwo.finishBtn.getText());
        Assertions.assertEquals("Payment Information:", checkoutTwo.infoLabels.get(0).getText());
        Assertions.assertEquals("Shipping Information:", checkoutTwo.infoLabels.get(1).getText());
        Assertions.assertEquals("Price Total", checkoutTwo.infoLabels.get(2).getText());
        Assertions.assertTrue(checkoutTwo.totalLabel.getText().contains("Total: $"));
        return this;
    }

    @Step("Click on cancel button")
    public ProductsPageSteps clickOnCancelBtn() {
        checkoutTwo.cancelBtn.should(exist).click();
        return new ProductsPageSteps();
    }

    @Step("Successful click on finish button")
    public CheckoutCompletePageSteps<P> clickOnFinishBtnCompletePageSuccessful() {
        checkoutTwo.finishBtn.should(exist).click();
        return new CheckoutCompletePageSteps(this);
    }

    @Step("Unsuccessful Click on finish button")
    public CheckoutTwoPageSteps<P> clickOnFinishBtnCompletePageUnsuccessful() {
        checkoutTwo.finishBtn.should(exist).click();
        return this;
    }
}
