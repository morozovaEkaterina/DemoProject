package sauceDemo.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.BaseSteps;
import sauceDemo.elements.ItemElements;

import static com.codeborne.selenide.Condition.exist;

public class ItemPageSteps<P> extends BaseSteps<ItemPageSteps<P>> {
    P parent;
    ItemElements itemElements = new ItemElements();

    public ItemPageSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check static elements and titles on inventory item")
    public ItemPageSteps<P> checkStaticElemsOnCartPage() {
        Assertions.assertEquals("Add to cart", itemElements.addToCart.getText());
        Assertions.assertEquals("Back to products", itemElements.backBtn.getText());
        Assertions.assertEquals("Swag Labs", itemElements.mainTitle.getText());
        itemElements.shoppingCartLink.should(exist);
        Assertions.assertTrue(itemElements.itemPrice.getText().contains("$"));
        itemElements.itemPhoto.should(exist);
        itemElements.menu.should(exist);
        return this;
    }

    @Step("Back to the main page")
    public ProductsPageSteps clickOnBackBtn() {
        itemElements.backBtn.should(exist);
        return new ProductsPageSteps();
    }
}
