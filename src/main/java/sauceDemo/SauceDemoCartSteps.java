package sauceDemo;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.elementsPackage.SauceDemoCartPageElements;
import sauceDemo.methodsPackage.BasePage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoCartSteps<P> extends BasePage<SauceDemoCartSteps<P>> {
    P parent;
    SauceDemoCartPageElements cartPage = new SauceDemoCartPageElements();

    public SauceDemoCartSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check static elements on the page")
    public SauceDemoCartSteps checkStaticElementsOnCartPage() {
        Assertions.assertEquals("Swag Labs", cartPage.appLogo.getText());
        Assertions.assertEquals("Your Cart", cartPage.pageTitle.getText());
        Assertions.assertEquals("QTY", cartPage.QTYText.getText());
        Assertions.assertEquals("Description", cartPage.descriptionText.getText());
        Assertions.assertTrue(cartPage.menuBtn.isDisplayed());
        Assertions.assertTrue(cartPage.continueShoppingBtn.isDisplayed() && cartPage.continueShoppingBtn.getText().contains("Continue Shopping"));
        Assertions.assertTrue(cartPage.checkoutBtn.isDisplayed() && cartPage.checkoutBtn.getText().contains("Checkout"));
        Assertions.assertTrue(cartPage.shoppingCartLink.isDisplayed());
        return this;
    }

    @Step("Check quantity items on the cart")
    public SauceDemoCartSteps checkQuantityItems() {
        Assertions.assertEquals($$(xpath("//div[@class='cart_item']")).size(), Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()));
        return this;
    }

    @Step("Click on 'remove' button")
    public SauceDemoCartSteps clickOnRemoveBtn(int index) {
        cartPage.removeBtns.get(index).should(exist).click();
        return this;
    }

    @Step("Click on 'continue shopping' button")
    public SauceDemoProductsSteps clickOnContinueShoppingBtn() {
        cartPage.continueShoppingBtn.should(exist).click();
        return new SauceDemoProductsSteps();
    }

    @Step("Click on 'Checkout' button")
    public SauceDemoCheckoutOneStepSteps<SauceDemoCartSteps> clickOnCheckoutBtn() {
        cartPage.checkoutBtn.should(exist).click();
        return new SauceDemoCheckoutOneStepSteps<>(this);
    }
}
