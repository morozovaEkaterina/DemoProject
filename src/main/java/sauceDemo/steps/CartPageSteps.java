package sauceDemo.steps;

import io.qameta.allure.Step;
import sauceDemo.BaseSteps;
import sauceDemo.page.CartPageElements;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

public class CartPageSteps<P> extends BaseSteps<CartPageSteps<P>> {
    P parent;
    CartPageElements cartPage = new CartPageElements();

    public CartPageSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check static page on the page")
    public CartPageSteps<P> checkStaticElementsOnCartPage() {
        cartPage.appLogo.should(text("Swag Labs"));
        cartPage.pageTitle.should(text("Your Cart"));
        cartPage.QTYText.should(text("QTY"));
        cartPage.descriptionText.should(text("Description"));
        cartPage.menuBtn.should(exist);
        cartPage.continueShoppingBtn.should(text("Continue Shopping"));
        cartPage.checkoutBtn.should(text("Checkout"));
        cartPage.shoppingCartLink.should(exist);
        return this;
    }

    @Step("Click on 'continue shopping' button")
    public ProductsPageSteps clickOnContinueShoppingBtn() {
        cartPage.continueShoppingBtn.should(exist).click();
        return new ProductsPageSteps();
    }

    @Step("Click on 'Checkout' button")
    public CheckoutOneStepPageSteps<CartPageSteps<P>> clickOnCheckoutBtn() {
        cartPage.checkoutBtn.should(exist).click();
        return new CheckoutOneStepPageSteps<>(this);
    }
}
