package sauceDemo.page;

import com.codeborne.selenide.SelenideElement;
import sauceDemo.page.components.ItemsInCartPage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.xpath;

public class CartPage {

    public static final String URL = "https://www.saucedemo.com/cart.html";
    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement pageTitle = $(xpath("//span[@class='title']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public SelenideElement continueShoppingBtn = $(xpath("//button[@name='continue-shopping']"));
    public SelenideElement checkoutBtn = $(xpath("//button[@name='checkout']"));
    public SelenideElement QTYText = $(xpath("//div[text()='QTY']"));
    public SelenideElement descriptionText = $(xpath("//div[text()='Description']"));
    public SelenideElement itemTitle = $(xpath("//div[contains(@class,'name')]"));
    public SelenideElement itemDescription = $(xpath("//div[contains(@class,'inventory_details_desc ')]"));
    public SelenideElement itemPrice = $(xpath("//div[contains(@class,'price')]"));

    public List<ItemsInCartPage> elems_CartPage() {
        List<ItemsInCartPage> items = new ArrayList<>();
        $$x("//div[@class='cart_item']")
                .asDynamicIterable().forEach(elem -> items.add(new ItemsInCartPage(elem)));
        return items;
    }
}
