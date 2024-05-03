package sauceDemoLogin;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoItemPage<P> extends BasePage<SauceDemoItemPage<P>> {
    P parent;

    public SauceDemoItemPage(P parent) {
        this.parent = parent;
    }

    public SelenideElement mainTitle = $(xpath("//div[@class='app_logo']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement backBtn = $(xpath("//button[@name='back-to-products']"));
    public SelenideElement itemTitle = $(xpath("//div[contains(@class,'name')]"));
    public SelenideElement itemDescription = $(xpath("//div[contains(@class,'inventory_details_desc ')]"));
    public SelenideElement itemPrice = $(xpath("//div[contains(@class,'price')]"));
    public SelenideElement addToCart = $(xpath("//button[text()='Add to cart']"));
    public SelenideElement itemPhoto = $(xpath("//img[contains(@src,'jpg')]"));
    public SelenideElement menu = $(xpath("//button[contains(@id,'menu')]"));

    @Step("Check static elements and titles on inventory item")
    public SauceDemoItemPage checkStaticElemsOnCartPage() {
        Assertions.assertEquals("Add to cart", addToCart.getText());
        Assertions.assertEquals("Back to products", backBtn.getText());
        Assertions.assertEquals("Swag Labs", mainTitle.getText());
        Assertions.assertTrue(shoppingCartLink.is(exist));
        Assertions.assertTrue(itemDescription.isDisplayed());
        Assertions.assertTrue(itemPrice.isDisplayed() && itemPrice.getText().contains("$"));
        Assertions.assertTrue(itemPhoto.isDisplayed());
        Assertions.assertTrue(menu.isDisplayed());
        return this;
    }

    @Step("Back to the main page")
    public SauceDemoProductsPage clickOnBackBtn() {
        backBtn.should(exist);
        return new SauceDemoProductsPage();
    }
}
