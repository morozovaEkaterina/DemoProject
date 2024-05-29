package sauceDemo.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import sauceDemo.BaseSteps;
import sauceDemo.page.AllItemsPage;
import sauceDemo.page.CartPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CartSteps<P> extends BaseSteps<CartSteps<P>> {
    P parent;
    CartPage itemsCartPage = new CartPage();
    AllItemsPage itemsAllItems = new AllItemsPage();

    public CartSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check static elements on the cart page")
    public CartSteps<P> checkStaticElementsOnCartPage() {
        itemsCartPage.appLogo.should(text("Swag Labs"));
        itemsCartPage.pageTitle.should(text("Your Cart"));
        itemsCartPage.QTYText.should(text("QTY"));
        itemsCartPage.descriptionText.should(text("Description"));
        itemsCartPage.menuBtn.should(exist);
        itemsCartPage.continueShoppingBtn.should(text("Continue Shopping"));
        itemsCartPage.checkoutBtn.should(text("Checkout"));
        itemsCartPage.shoppingCartLink.should(exist);
        return this;
    }

    @Step("Click on 'Continue shopping' button")
    public AllItemsSteps clickOnContinueShoppingBtn() {
        itemsCartPage.continueShoppingBtn.should(exist).click();
        return new AllItemsSteps();
    }

    @Step("Click on 'Checkout' button")
    public CheckoutPersonalSteps<CartSteps<P>> clickOnCheckoutBtn() {
        itemsCartPage.checkoutBtn.should(exist).click();
        return new CheckoutPersonalSteps<>(this);
    }

    @Step("Check is items added to cart the same")
    public CartSteps<P> checkIsItemsTheSame(String... titles) {
        for (String title : titles) {
            itemsAllItems.elements().stream()
                    .filter(e -> e.title().getText().equals(title))
                    .forEach(x -> x.price().should(text(itemsCartPage.itemPrice.getText())));
            itemsAllItems.elements().stream()
                    .filter(e -> e.title().getText().equals(title))
                    .forEach(x -> x.description().should(text(itemsCartPage.itemDescription.getText())));
            itemsAllItems.elements().stream()
                    .filter(e -> e.title().getText().equals(title))
                    .forEach(x -> x.title().should(text(itemsCartPage.itemTitle.getText())));
        }
        $(xpath("//span[contains(@class,'badge')]")).should(exist,text(String.valueOf(titles.length)));
        return this;
    }

    @Step("Click on 'Remove' button on the cart page")
    public CartSteps<P> clickOnRemoveBtn(String... titles) {
        for (String title : titles) {
            itemsCartPage.elems_CartPage().stream()
                    .filter(e -> e.title().getText().equals(title))
                    .toList()
                    .forEach(x -> x.removeBtn().should(text("Remove"), exist).click());
        }
        return this;
    }

    @Step("Check click on 'Remove' button on the cart page")
    public CartSteps<P> checkClickOnRemoveBtn(String...titles) {
        for(String title:titles) {
            Assert.assertEquals(itemsCartPage.elems_CartPage().size(),
                    Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()));
            itemsCartPage.elems_CartPage()
                    .forEach(e->e.title().shouldNot(text(title)));
            itemsAllItems.elements().stream()
                    .filter(e->e.title().getText().equals(title))
                    .forEach(x->x.addRemoveBtn().should(text("Add to cart")));
        }
        return this;
    }

    @Step("Click on item`s title")
    public IndividualItemSteps<CartSteps<P>> clickOnItemsTitle(String title) {
        itemsCartPage.itemTitle.should(exist,text(title)).click();
        return  new IndividualItemSteps<>(this);
    }

    @Step("Check is cart empty")
    public CartSteps<P> checkIsCartEmpty () {
        Assert.assertEquals(0, itemsCartPage.elems_CartPage().size());
        $(xpath("//span[contains(@class,'badge')]")).shouldNot(exist);
        return  this;
    }
}

