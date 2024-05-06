package sauceDemo.elementsPackage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoMainPageElements {
    public SelenideElement loginLogo = $(xpath("//div[@id='root']/div/div[1]"));
    public SelenideElement inputAreaUserName = $(xpath("//input[@placeholder='Username']"));
    public SelenideElement inputAreaPassword = $(xpath("//input[@placeholder='Password']"));
    public SelenideElement loginBtn = $(xpath("//input[@type='submit']"));
    public ElementsCollection inputErrorForm = $$(xpath("//input[@class='input_error form_input error']"));
    public SelenideElement errorText = $(xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']"));
    public SelenideElement errorBtn = $(xpath("//button[@class='error-button']"));
}
