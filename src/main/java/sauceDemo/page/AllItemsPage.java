package sauceDemo.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import sauceDemo.page.components.ItemsInAllItemsPage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class AllItemsPage {

    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement productSort = $(xpath("//select[@class='product_sort_container']"));
    public ElementsCollection inventoryList = $$(xpath("//div[@class='inventory_item']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public ElementsCollection wrapMenuItems = $$(xpath("//div[@class='bm-menu']//a"));
    public ElementsCollection sortMenuCollection = $$(xpath("//option"));
    public SelenideElement closeWrapMenuBtn = $(xpath("//button[text()='Close Menu']"));
    public SelenideElement wrapMenuArea = $(xpath("//div[@class='bm-menu-wrap']"));

    public List<ItemsInAllItemsPage> elements() {
        List<ItemsInAllItemsPage> items = new ArrayList<>();
        $$x("//div[@class='inventory_item']")
                .asDynamicIterable().forEach(elem -> items.add(new ItemsInAllItemsPage(elem)));
        return items;
    }
}
