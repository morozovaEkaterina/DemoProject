package sauceDemoLogin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoCheckoutCompletePage<P> extends BasePage<SauceDemoCheckoutCompletePage<P>> {
    P parent;

    public SauceDemoCheckoutCompletePage(P parent) {
        this.parent = parent;
    }

    public static final String URL = "https://www.saucedemo.com/checkout-complete.html";

    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement pageTitle = $(xpath("//span[text()='Checkout: Complete!']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public SelenideElement thankYouText = $(xpath("//h2"));
    public SelenideElement completeText = $(xpath("//div[@class='complete-text']"));
    public SelenideElement backHomeBtn = $(xpath("//button[text()='Back Home']"));

    @Step("Check all static elements on checkout complete page")
    public SauceDemoCheckoutCompletePage checkStaticElemsOnCheckoutCompletePage() {
        Assertions.assertEquals("Swag Labs", appLogo.getText());
        Assertions.assertEquals("Checkout: Complete!", pageTitle.getText());
        Assertions.assertTrue(menuBtn.isDisplayed());
        Assertions.assertTrue(shoppingCartLink.isDisplayed());
        Assertions.assertEquals("Thank you for your order!", thankYouText.getText());
        Assertions.assertEquals(
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                completeText.getText());
        Assertions.assertTrue(backHomeBtn.isDisplayed() && backHomeBtn.getText().contains("Back Home"));
        return this;
    }

    @Step("Click on 'Back Home' button")
    public SauceDemoProductsPage clickOnBackHomePage() {
        backHomeBtn.should(Condition.exist).click();
        return new SauceDemoProductsPage();
    }
}







