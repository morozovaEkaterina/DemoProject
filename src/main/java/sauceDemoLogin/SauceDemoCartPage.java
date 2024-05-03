package sauceDemoLogin;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoCartPage<P> extends BasePage<SauceDemoCartPage<P>> {
    P parent;

    public SauceDemoCartPage(P parent) {
        this.parent = parent;
    }

    public static final String URL = "https://www.saucedemo.com/cart.html";
    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement pageTitle = $(xpath("//span[@class='title']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public SelenideElement cartCounter = $(xpath("//span[@class='shopping_cart_badge']"));
    public SelenideElement continueShoppingBtn = $(xpath("//button[@name='continue-shopping']"));
    public SelenideElement checkoutBtn = $(xpath("//button[@name='checkout']"));
    public SelenideElement QTYText = $(xpath("//div[text()='QTY']"));
    public SelenideElement descriptionText = $(xpath("//div[text()='Description']"));
    public ElementsCollection removeBtns = $$(xpath("//button[text()='Remove']"));
    public ElementsCollection cartItemsList = $$(xpath("//div[@class='cart_item']"));
    public ElementsCollection inventoryName = $$(xpath("//div[@class='inventory_item_name']"));
    public ElementsCollection itemQty = $$(xpath("//div[@class='cart_quantity']"));

    @Step("Check static elements on the page")
    public SauceDemoCartPage checkStaticElementsOnCartPage() {
        Assertions.assertEquals("Swag Labs", appLogo.getText());
        Assertions.assertEquals("Your Cart", pageTitle.getText());
        Assertions.assertEquals("QTY", QTYText.getText());
        Assertions.assertEquals("Description", descriptionText.getText());
        Assertions.assertTrue(menuBtn.isDisplayed());
        Assertions.assertTrue(continueShoppingBtn.isDisplayed() && continueShoppingBtn.getText().contains("Continue Shopping"));
        Assertions.assertTrue(checkoutBtn.isDisplayed() && checkoutBtn.getText().contains("Checkout"));
        Assertions.assertTrue(shoppingCartLink.isDisplayed());
        return this;
    }

    @Step("Check quantity items on the cart")
    public SauceDemoCartPage checkQuantityItems() {
        Assertions.assertEquals($$(xpath("//div[@class='cart_item']")).size(), Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()));
        return this;
    }

    @Step("Click on 'remove' button")
    public SauceDemoCartPage clickOnRemoveBtn(int index) {
        removeBtns.get(index).should(exist).click();
        return this;
    }

    @Step("Click on 'continue shopping' button")
    public SauceDemoProductsPage clickOnContinueShoppingBtn() {
        continueShoppingBtn.should(exist).click();
        return new SauceDemoProductsPage();
    }

    @Step("Click on 'Checkout' button")
    public SauceDemoCheckoutOneStepPage<SauceDemoCartPage> clickOnCheckoutBtn() {
        checkoutBtn.should(exist).click();
        return new SauceDemoCheckoutOneStepPage<>(this);
    }
}
