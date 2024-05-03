package sauceDemoLogin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoCheckoutTwoStepPage<P> extends BasePage<SauceDemoCheckoutTwoStepPage<P>> {
    P parent;

    public SauceDemoCheckoutTwoStepPage(P parent) {
        this.parent = parent;
    }

    public static final String URL = "https://www.saucedemo.com/checkout-step-two.html";

    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement pageTitle = $(xpath("//span[text()='Checkout: Overview']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public SelenideElement QTYText = $(xpath("//div[text()='QTY']"));
    public SelenideElement descriptionText = $(xpath("//div[text()='Description']"));
    public ElementsCollection infoLabels = $$(xpath("//div[@class='summary_info_label']"));
    public ElementsCollection valueLabels = $$(xpath("//div[@class='summary_value_label']"));
    public SelenideElement subtotalLabel = $(xpath("//div[@class='summary_subtotal_label']"));
    public SelenideElement taxLabel = $(xpath("//div[@class='summary_tax_label']"));
    public SelenideElement totalLabel = $(xpath("//div[@class='summary_total_label']"));
    public SelenideElement cancelBtn = $(xpath("//button[@id='cancel']"));
    public SelenideElement finishBtn = $(xpath("//button[@id='finish']"));


    @Step("Check all static elements on checkout overview page")
    public SauceDemoCheckoutTwoStepPage checkStaticElemsOnTwoCheckStepPage() {
        Assertions.assertEquals("Swag Labs", appLogo.getText());
        Assertions.assertEquals("Checkout: Overview", pageTitle.getText());
        Assertions.assertTrue(menuBtn.isDisplayed());
        Assertions.assertTrue(shoppingCartLink.isDisplayed());
        Assertions.assertTrue(cancelBtn.isDisplayed() && cancelBtn.getText().contains("Cancel"));
        Assertions.assertTrue(finishBtn.isDisplayed() && finishBtn.getText().contains("Finish"));
        Assertions.assertEquals("QTY", QTYText.getText());
        Assertions.assertEquals("Description", descriptionText.getText());
        Assertions.assertEquals("Payment Information:", infoLabels.get(0).getText());
        Assertions.assertEquals("Shipping Information:", infoLabels.get(1).getText());
        Assertions.assertEquals("Price Total", infoLabels.get(2).getText());
        Assertions.assertTrue(valueLabels.get(0).getText().contains("SauceCard"));
        Assertions.assertTrue(valueLabels.get(1).getText().contains("Free Pony Express Delivery!"));
        Assertions.assertTrue(subtotalLabel.getText().contains("Item total: $"));
        Assertions.assertTrue(taxLabel.getText().contains("Tax: $"));
        Assertions.assertTrue(totalLabel.getText().contains("Total: $"));
        return this;
    }

    @Step("Click on cancel button")
    public SauceDemoProductsPage clickOnCancelBtn() {
        cancelBtn.should(Condition.exist).click();
        return new SauceDemoProductsPage();
    }

    @Step("Click on finish button")
    public SauceDemoCheckoutCompletePage clickOnFinishBtnCompletePage() {
        finishBtn.should(Condition.exist).click();
        return new SauceDemoCheckoutCompletePage<>(this);
    }
}
