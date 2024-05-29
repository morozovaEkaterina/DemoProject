package sauceDemo.steps;

import io.qameta.allure.Step;
import sauceDemo.BaseSteps;
import sauceDemo.page.AllItemsPage;
import sauceDemo.page.IndividualItemPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class IndividualItemSteps<P> extends BaseSteps<IndividualItemSteps<P>> {
    P parent;
    IndividualItemPage itemIndivItemP = new IndividualItemPage();
    AllItemsPage items = new AllItemsPage();

    public IndividualItemSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check static elements on the individual item page")
    public IndividualItemSteps<P> checkStaticElemsOnIndividualItemPage() {
        itemIndivItemP.addToCartBtn.should(text("Remove").or(text("Add to cart")));
        itemIndivItemP.backBtn.should(text("Back to products"));
        itemIndivItemP.mainTitle.should(text("Swag Labs"));
        itemIndivItemP.shoppingCartLink.should(exist);
        itemIndivItemP.itemPrice.should(text("$"));
        itemIndivItemP.itemPhoto.should(exist);
        itemIndivItemP.menu.should(exist);
        return this;
    }

    @Step("Back to all items page")
    public AllItemsSteps clickOnBackBtn() {
        itemIndivItemP.backBtn.should(exist).click();
        return new AllItemsSteps();
    }

    @Step("Click on 'Add to cart' button")
    public IndividualItemSteps<P> clickOnAddToCartBtn() {
        itemIndivItemP.addToCartBtn.should(text("Add to cart"), exist).click();
        return this;
    }

    @Step("Check click on 'Add to cart' button")
    public IndividualItemSteps<P> checkClickOnAddToCartBtn() {
        itemIndivItemP.addToCartBtn.should(text("Remove"));
        $(xpath("//span[contains(@class,'badge')]")).should(exist);
        return this;
    }

    @Step("Click on 'Remove' button")
    public IndividualItemSteps<P> clickOnRemoveBtn() {
        itemIndivItemP.addToCartBtn.should(text("Remove"), exist).click();
        return this;
    }

    @Step("Check click on 'Remove' button")
    public IndividualItemSteps<P> checkClickOnRemoveBtn() {
        itemIndivItemP.addToCartBtn.should(text("Add to cart").or(text("Remove")));
        return this;
    }

    @Step("Check is item {title} the same")
    public IndividualItemSteps<P> checkIsItemTheSame(String title) {
        items.elements().stream()
                .filter(e -> e.title().getText().equals(title))
                .forEach(x -> x.price().should(text(itemIndivItemP.itemPrice.getText())));
        items.elements().stream()
                .filter(e -> e.title().getText().equals(title))
                .forEach(x -> x.description().should(text(itemIndivItemP.itemDescription.getText())));
        items.elements().stream()
                .filter(e -> e.title().getText().equals(title))
                .forEach(x -> x.title().should(text(itemIndivItemP.itemTitle.getText())));
        return this;
    }
}
