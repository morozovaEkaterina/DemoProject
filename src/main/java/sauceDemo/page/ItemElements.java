package sauceDemo.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class ItemElements {

    public SelenideElement mainTitle = $(xpath("//div[@class='app_logo']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement backBtn = $(xpath("//button[@name='back-to-products']"));
    public SelenideElement itemTitle = $(xpath("//div[contains(@class,'name')]"));
    public SelenideElement itemDescription = $(xpath("//div[contains(@class,'inventory_details_desc ')]"));
    public SelenideElement itemPrice = $(xpath("//div[contains(@class,'price')]"));
    public SelenideElement addToCart = $(xpath("//button[text()='Add to cart']"));
    public SelenideElement itemPhoto = $(xpath("//img[contains(@src,'jpg')]"));
    public SelenideElement menu = $(xpath("//button[contains(@id,'menu')]"));
}
