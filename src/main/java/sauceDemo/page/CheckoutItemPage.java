package sauceDemo.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import sauceDemo.page.components.ItemsInCheckoutItemsPage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class CheckoutItemPage {

    public SelenideElement pageTitle = $(xpath("//span[text()='Checkout: Overview']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public ElementsCollection infoLabels = $$(xpath("//div[@class='summary_info_label']"));
    public SelenideElement subtotalLabel = $(xpath("//div[@class='summary_subtotal_label']"));
    public SelenideElement taxLabel = $(xpath("//div[@class='summary_tax_label']"));
    public SelenideElement totalLabel = $(xpath("//div[@class='summary_total_label']"));
    public SelenideElement cancelBtn = $(xpath("//button[@id='cancel']"));
    public SelenideElement finishBtn = $(xpath("//button[@id='finish']"));

    public List<ItemsInCheckoutItemsPage> elemsCheckoutItemPage() {
        List<ItemsInCheckoutItemsPage> items = new ArrayList<>();
        $$x("//div[@class='cart_item']")
                .asDynamicIterable().forEach(elem -> items.add(new ItemsInCheckoutItemsPage(elem)));
        return items;
    }
}
