package sauceDemo.elementsPackage;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class CheckoutCompleteElements {
    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement pageTitle = $(xpath("//span[text()='Checkout: Complete!']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public SelenideElement thankYouText = $(xpath("//h2"));
    public SelenideElement completeText = $(xpath("//div[@class='complete-text']"));
    public SelenideElement backHomeBtn = $(xpath("//button[text()='Back Home']"));
}
