package sauceDemo;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.elementsPackage.SauceDemoCheckoutTwoElements;
import sauceDemo.methodsPackage.BasePage;

public class SauceDemoCheckoutTwoStepPage<P> extends BasePage<SauceDemoCheckoutTwoStepPage<P>> {
    P parent;
    SauceDemoCheckoutTwoElements checkoutTwo = new SauceDemoCheckoutTwoElements();

    public SauceDemoCheckoutTwoStepPage(P parent) {
        this.parent = parent;
    }

    @Step("Check all static elements on checkout overview page")
    public SauceDemoCheckoutTwoStepPage checkStaticElemsOnTwoCheckStepPage() {
        Assertions.assertEquals("Swag Labs", checkoutTwo.appLogo.getText());
        Assertions.assertEquals("Checkout: Overview", checkoutTwo.pageTitle.getText());
        Assertions.assertTrue(checkoutTwo.menuBtn.isDisplayed());
        Assertions.assertTrue(checkoutTwo.shoppingCartLink.isDisplayed());
        Assertions.assertTrue(checkoutTwo.cancelBtn.isDisplayed() && checkoutTwo.cancelBtn.getText().contains("Cancel"));
        Assertions.assertTrue(checkoutTwo.finishBtn.isDisplayed() && checkoutTwo.finishBtn.getText().contains("Finish"));
        Assertions.assertEquals("QTY", checkoutTwo.QTYText.getText());
        Assertions.assertEquals("Description", checkoutTwo.descriptionText.getText());
        Assertions.assertEquals("Payment Information:", checkoutTwo.infoLabels.get(0).getText());
        Assertions.assertEquals("Shipping Information:", checkoutTwo.infoLabels.get(1).getText());
        Assertions.assertEquals("Price Total", checkoutTwo.infoLabels.get(2).getText());
        Assertions.assertTrue(checkoutTwo.valueLabels.get(0).getText().contains("SauceCard"));
        Assertions.assertTrue(checkoutTwo.valueLabels.get(1).getText().contains("Free Pony Express Delivery!"));
        Assertions.assertTrue(checkoutTwo.subtotalLabel.getText().contains("Item total: $"));
        Assertions.assertTrue(checkoutTwo.taxLabel.getText().contains("Tax: $"));
        Assertions.assertTrue(checkoutTwo.totalLabel.getText().contains("Total: $"));
        return this;
    }

    @Step("Click on cancel button")
    public SauceDemoProductsSteps clickOnCancelBtn() {
        checkoutTwo.cancelBtn.should(Condition.exist).click();
        return new SauceDemoProductsSteps();
    }

    @Step("Successful click on finish button")
    public SauceDemoCheckoutCompleteSteps clickOnFinishBtnCompletePageSuccessful() {
        checkoutTwo.finishBtn.should(Condition.exist).click();
        return new SauceDemoCheckoutCompleteSteps<>(this);
    }

    @Step("Unsuccessful Click on finish button")
    public SauceDemoCheckoutTwoStepPage clickOnFinishBtnCompletePageUnsuccessful() {
        checkoutTwo.finishBtn.should(Condition.exist).click();
        return this;
    }

}
