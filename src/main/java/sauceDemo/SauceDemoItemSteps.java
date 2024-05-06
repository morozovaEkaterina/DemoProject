package sauceDemo;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.elementsPackage.SauceDemoItemElements;
import sauceDemo.methodsPackage.BasePage;

import static com.codeborne.selenide.Condition.exist;

public class SauceDemoItemSteps<P> extends BasePage<SauceDemoItemSteps<P>> {
    P parent;
    SauceDemoItemElements itemElements = new SauceDemoItemElements();

    public SauceDemoItemSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check static elements and titles on inventory item")
    public SauceDemoItemSteps checkStaticElemsOnCartPage() {
        Assertions.assertEquals("Add to cart", itemElements.addToCart.getText());
        Assertions.assertEquals("Back to products", itemElements.backBtn.getText());
        Assertions.assertEquals("Swag Labs", itemElements.mainTitle.getText());
        Assertions.assertTrue(itemElements.shoppingCartLink.is(exist));
        Assertions.assertTrue(itemElements.itemDescription.isDisplayed());
        Assertions.assertTrue(itemElements.itemPrice.isDisplayed() && itemElements.itemPrice.getText().contains("$"));
        Assertions.assertTrue(itemElements.itemPhoto.isDisplayed());
        Assertions.assertTrue(itemElements.menu.isDisplayed());
        return this;
    }

    @Step("Back to the main page")
    public SauceDemoProductsSteps clickOnBackBtn() {
        itemElements.backBtn.should(exist);
        return new SauceDemoProductsSteps();
    }
}
