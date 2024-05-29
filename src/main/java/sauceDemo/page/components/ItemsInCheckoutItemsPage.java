package sauceDemo.page.components;

import com.codeborne.selenide.SelenideElement;

import static org.openqa.selenium.By.xpath;

public class ItemsInCheckoutItemsPage {
    public SelenideElement container;

    public ItemsInCheckoutItemsPage(SelenideElement container) {
        this.container = container;
    }

    public SelenideElement description() {

        return container.$(xpath(".//div[@class='inventory_item_desc']"));
    }

    public SelenideElement title() {
        return container.$(xpath(".//a[contains(@id,'title')]"));
    }

    public SelenideElement price() {
        return container.$(xpath(".//div[@class='inventory_item_price']"));
    }
}


