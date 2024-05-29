package sauceDemo.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
import sauceDemo.BaseSteps;
import sauceDemo.page.CartPage;
import sauceDemo.page.CheckoutItemPage;
import sauceDemo.page.components.ItemsInCheckoutItemsPage;

import java.util.List;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CheckoutItemSteps<P> extends BaseSteps<CheckoutItemSteps<P>> {
    P parent;
    CheckoutItemPage checkoutItem = new CheckoutItemPage();
    CartPage cart = new CartPage();

    public CheckoutItemSteps(P parent) {
        this.parent = parent;
    }

    @Step("Check all static elements on checkout overview page")
    public CheckoutItemSteps<P> checkStaticElemsOnTwoCheckStepPage() {
        checkoutItem.pageTitle.should(text("Checkout: Overview"));
        checkoutItem.menuBtn.should(exist);
        checkoutItem.shoppingCartLink.should(exist);
        checkoutItem.cancelBtn.should(text("Cancel"));
        checkoutItem.finishBtn.should(text("Finish"));
        checkoutItem.infoLabels.get(0).should(text("Payment Information:"));
        checkoutItem.infoLabels.get(1).should(text("Shipping Information:"));
        checkoutItem.infoLabels.get(2).should(text("Price Total"));
        checkoutItem.totalLabel.should(Condition.text("Total: $"));
        return this;
    }

    @Step("Click on 'Cancel' button")
    public AllItemsSteps clickOnCancelBtn() {
        checkoutItem.cancelBtn.should(exist).click();
        return new AllItemsSteps();
    }

    @Step("Successful click on 'Finish' button")
    public CheckoutCompleteSteps<CheckoutItemSteps<P>> clickOnFinishBtnCompletePage() {
        checkoutItem.finishBtn.should(exist).click();
        return new CheckoutCompleteSteps<>(this);
    }

    @Step("Check info about items")
    public CheckoutItemSteps<P> checkItemInfo() {
        Assert.assertEquals(cart.elems_CartPage().stream().map(e -> e.title().getText()).toList()
                , checkoutItem.elemsCheckoutItemPage().stream().map(e -> e.title().getText()).toList());
        Assert.assertEquals(cart.elems_CartPage().stream().map(e -> e.price().getText()).toList(),
                checkoutItem.elemsCheckoutItemPage().stream().map(e -> e.price().getText()).toList());
        Assert.assertEquals(cart.elems_CartPage().stream().map(e -> e.description().getText()).toList()
                , checkoutItem.elemsCheckoutItemPage().stream().map(e -> e.description().getText()).toList());
        Assert.assertEquals(cart.elems_CartPage().size(),
                Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()));
        return this;
    }

    @Step("Click on item`s title")
    public IndividualItemSteps<CheckoutItemSteps<P>> clickOnItemsTitle(String title) {
        checkoutItem.elemsCheckoutItemPage().forEach(e->e.title().should(text(title)).click());
        return new IndividualItemSteps<>(this);
    }

    @Step("Check 'item total' price")
    public CheckoutItemSteps<P> checkItemTotalPrice() {
        checkoutItem.subtotalLabel.should(text("Item total: $"));
        List<String> itemPrices = checkoutItem.elemsCheckoutItemPage().stream()
                .map(e -> e.price().getText().replace("$", "")).toList();
        double expectedItemTotalItemPrice = itemPrices.stream().mapToDouble(Double::parseDouble).sum();
        double actualItemTotalPrice = Double.parseDouble(checkoutItem.subtotalLabel.getText().replaceAll("[a-zA-Z$:\\s]", ""));
        Assert.assertEquals(expectedItemTotalItemPrice, actualItemTotalPrice, 0.001);
        return this;
    }

    @Step("Check 'total' price")
    public CheckoutItemSteps<P> checkTotalPrice() {
        checkoutItem.totalLabel.should(text("Total: $"));
        List<String> itemsPrice = checkoutItem.elemsCheckoutItemPage().stream()
                .map(e -> e.price().getText().replace("$", "")).toList();
        double expectedTotalPrice = itemsPrice.stream().mapToDouble(Double::parseDouble).sum();
        double actualTotalPrice = Double.parseDouble(checkoutItem.totalLabel.getText().replaceAll("[a-zA-Z$:\\s]", ""));
        checkoutItem.taxLabel.should(text("Tax: $"));
        double tax = Double.parseDouble(checkoutItem.taxLabel.getText().replaceAll("[a-zA-Z:$\\s]", ""));
        Assert.assertEquals(expectedTotalPrice + tax, actualTotalPrice, 0.01);
        return this;
    }
}
