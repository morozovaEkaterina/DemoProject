package sauceDemo.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class CheckoutTwoElements {

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
}
