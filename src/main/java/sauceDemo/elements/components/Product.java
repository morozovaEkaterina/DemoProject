package sauceDemo.elements.components;

import com.codeborne.selenide.SelenideElement;

import static org.openqa.selenium.By.xpath;

public class Product {
    public SelenideElement container;

    public Product(SelenideElement container) {
        this.container = container;
    }

    public SelenideElement picture() {
        return container.$(xpath(".//div[@class='inventory_item']//a[contains(@id,'img')]"));
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

    public SelenideElement addRemoveBtn() {
        return container.$(xpath(".//button"));
    }
}
