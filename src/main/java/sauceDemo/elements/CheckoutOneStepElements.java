package sauceDemo.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class CheckoutOneStepElements {

    public static final String URL = "https://www.saucedemo.com/checkout-step-one.html";
    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement pageTitle = $(xpath("//span[text()='Checkout: Your Information']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public SelenideElement cancelBtn = $(xpath("//button[@id='cancel']"));
    public SelenideElement continueBtn = $(xpath("//input[@name='continue']"));
    public SelenideElement firstNameInputArea = $(xpath("//input[@name='firstName']"));
    public SelenideElement lastNameInputArea = $(xpath("//input[@name='lastName']"));
    public SelenideElement zipInputArea = $(xpath("//input[@name='postalCode']"));
    public SelenideElement errorMessageProblemUser = $(xpath("//h3"));
    public ElementsCollection errorInputFields = $$(xpath("//input[contains(@class,'error')]"));
    public SelenideElement errorBtn = $(xpath("//button[@class='error-button']"));


}
