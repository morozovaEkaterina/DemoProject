package sauceDemo.page.components;

import com.codeborne.selenide.SelenideElement;

import static org.openqa.selenium.By.xpath;

public class ItemsInCartPage {

    public SelenideElement container;

    public ItemsInCartPage(SelenideElement container) {
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

    public SelenideElement removeBtn() {
        return container.$(xpath(".//button"));
    }
}
