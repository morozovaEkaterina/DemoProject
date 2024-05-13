package sauceDemo.steps;

import io.qameta.allure.Step;
import sauceDemo.BaseSteps;
import sauceDemo.page.ItemElements;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;

public class ItemPageSteps<P> extends BaseSteps<ItemPageSteps<P>> {
    P parent;
    ItemElements itemElements = new ItemElements();

    public ItemPageSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check static page and titles on inventory item")
    public ItemPageSteps<P> checkStaticElemsOnCartPage() {
        itemElements.addToCart.should(text("Add to cart"));
        itemElements.backBtn.should(text("Back to products"));
        itemElements.mainTitle.should(text("Swag Labs"));
        itemElements.shoppingCartLink.should(exist);
        itemElements.itemPrice.should(text("$"));
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
