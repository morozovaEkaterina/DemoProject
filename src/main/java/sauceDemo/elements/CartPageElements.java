package sauceDemo.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class CartPageElements {

    public static final String URL = "https://www.saucedemo.com/cart.html";
    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement pageTitle = $(xpath("//span[@class='title']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public SelenideElement continueShoppingBtn = $(xpath("//button[@name='continue-shopping']"));
    public SelenideElement checkoutBtn = $(xpath("//button[@name='checkout']"));
    public SelenideElement QTYText = $(xpath("//div[text()='QTY']"));
    public SelenideElement descriptionText = $(xpath("//div[text()='Description']"));
    public ElementsCollection removeBtns = $$(xpath("//button[text()='Remove']"));
}
