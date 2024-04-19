package sauceDemoLogin;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoProductsPage extends BasePage<SauceDemoProductsPage> {

    public static final String URL = "https://www.saucedemo.com/inventory.html";
    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement productSort = $(xpath("//select[@class='product_sort_container']"));
    public ElementsCollection inventoryList = $$(xpath("//div[@class='inventory_item']"));

    @Step("Check static elements on the page")
    public void checkStaticElementsOnProductPage() {
        Assertions.assertEquals("Swag Labs", appLogo.getText());
        Assertions.assertTrue(productSort.isDisplayed());
        Assertions.assertTrue(shoppingCartLink.isDisplayed());
        Assertions.assertEquals(6, inventoryList.size());
    }
}
