package sauceDemo.elementsPackage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoProductsPageElements {

    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement productSort = $(xpath("//select[@class='product_sort_container']"));
    public ElementsCollection inventoryList = $$(xpath("//div[@class='inventory_item']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public ElementsCollection wrapMenuItems = $$(xpath("//div[@class='bm-menu']//a"));
    public SelenideElement exitBtnOnWrapMenu = $(xpath("//button[@id='react-burger-cross-btn']"));
    public ElementsCollection sortMenuCollection = $$(xpath("//option"));
    public ElementsCollection itemsTitlesLink = $$(xpath("//div[@class='inventory_item']//a[contains(@id,'title')]"));
    public ElementsCollection itemsPictures = $$(xpath("//div[@class='inventory_item']//a[contains(@id,'img')]"));
    public ElementsCollection itemsDescriptions = $$(xpath("//div[@class='inventory_item_desc']"));
    public ElementsCollection itemsPrice = $$(xpath("//div[@class='inventory_item_price']"));
    public ElementsCollection addRemoveToCartBtns = $$(xpath("//button[contains(@class,'btn')]"));
    public SelenideElement closeWrapMenuBtn = $(xpath("//button[text()='Close Menu']"));
    public SelenideElement wrapMenuArea = $(xpath("//div[@class='bm-menu-wrap']"));
}
