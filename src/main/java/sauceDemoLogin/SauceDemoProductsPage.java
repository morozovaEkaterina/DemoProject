package sauceDemoLogin;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoProductsPage extends BasePage<SauceDemoProductsPage> {

    public static final String URL = "https://www.saucedemo.com/inventory.html";
    public SelenideElement appLogo = $(xpath("//div[text()='Swag Labs']"));
    public SelenideElement shoppingCartLink = $(xpath("//a[@class='shopping_cart_link']"));
    public SelenideElement productSort = $(xpath("//select[@class='product_sort_container']"));
    public ElementsCollection inventoryList = $$(xpath("//div[@class='inventory_item']"));
    public SelenideElement menuBtn = $(xpath("//button[@id='react-burger-menu-btn']"));
    public SelenideElement wrapMenuArea = $(xpath("//div[@class='bm-menu-wrap']"));
    public ElementsCollection wrapMenuItems = $$(xpath("//nav[@class='bm-item-list']/a"));
    public SelenideElement exitBtnOnWrapMenu = $(xpath("//button[@id='react-burger-cross-btn']"));
    public ElementsCollection sortMenuCollection = $$(xpath("//option"));
    public ElementsCollection itemsTitlesLink = $$(xpath("//div[@class='inventory_item']//a[contains(@id,'title')]"));
    public ElementsCollection itemsPictures = $$(xpath("//div[@class='inventory_item']//a[contains(@id,'img')]"));
    public ElementsCollection itemsDescriptions = $$(xpath("//div[@class='inventory_item_desc']"));
    public ElementsCollection itemsPrice = $$(xpath("//div[@class='inventory_item_price']"));
    public ElementsCollection addRemoveToCartBtns = $$(xpath("//button[contains(@class,'btn')]"));


    @Step("Open URL {URL}")
    public static SauceDemoProductsPage open() {
        Selenide.open(URL);
        return new SauceDemoProductsPage();
    }

    @Step("Check static elements on the page")
    public SauceDemoProductsPage checkStaticElementsOnProductPage() {
        Assertions.assertEquals("Swag Labs", appLogo.getText());
        Assertions.assertTrue(productSort.isDisplayed());
        Assertions.assertTrue(shoppingCartLink.isDisplayed());
        Assertions.assertEquals(6, inventoryList.size());
        return this;
    }

    @Step("Click on menu button and open wrap menu")
    public SauceDemoProductsPage clickOnWrapMenu() {
        if (wrapMenuArea.isDisplayed())
            menuBtn.should(exist, clickable).click();
        return this;
    }

    @Step("Check all positions:'All Items','About','Logout','Reset App State'")
    public SauceDemoProductsPage checkAllPositionsInWrapMenu() {
        Assertions.assertEquals(4, wrapMenuItems.size());
        Assertions.assertEquals("All Items", wrapMenuItems.get(0).getText());
        Assertions.assertEquals("About", wrapMenuItems.get(1).getText());
        Assertions.assertEquals("Logout", wrapMenuItems.get(2).getText());
        Assertions.assertEquals("Reset App State", wrapMenuItems.get(3).getText());
        Assertions.assertTrue(exitBtnOnWrapMenu.isDisplayed());
        return this;
    }

    @Step("Click on button logout")
    public SauceDemoProductsPage clickOnLogoutBtn(int index) {
        wrapMenuItems.get(index).should(exist).click();
        return this;
    }

    @Step("Click on sort button")
    public SauceDemoProductsPage clickOnSortBtn() {
        productSort.should(exist).click();
        return this;
    }

    @Step("Check elements on products cards")
    public SauceDemoProductsPage checkElemsOnProductsCards() {
        for (int i = 0; i < inventoryList.size(); i++) {
            Assertions.assertFalse(inventoryList.isEmpty());
            Assertions.assertTrue(itemsPrice.get(i).getText().contains("$"));
            Assertions.assertTrue(Integer.parseInt(itemsPrice.get(i).getText().replaceAll("[^\\d]", "")) >= 0);
            Assertions.assertTrue(itemsPictures.get(i).isDisplayed());
            Assertions.assertTrue(itemsDescriptions.get(i).is(visible));
            Assertions.assertEquals("Add to cart", addRemoveToCartBtns.get(i).getText());
            Assertions.assertTrue(addRemoveToCartBtns.get(i).is(clickable));
        }
        return this;
    }

    @Step("Click on product title")
    public SauceDemoItemPage clickOnProductTitle(int index) {
        itemsTitlesLink.get(index).should(exist).click();
        return new SauceDemoItemPage<>(this);
    }

    @Step("Check sort menu")
    public SauceDemoProductsPage checkSortMenu() {
        Assertions.assertEquals("Name (A to Z)", sortMenuCollection.get(0).getText());
        Assertions.assertEquals("Name (Z to A)", sortMenuCollection.get(1).getText());
        Assertions.assertEquals("Price (low to high)", sortMenuCollection.get(2).getText());
        Assertions.assertEquals("Price (high to low)", sortMenuCollection.get(3).getText());
        return this;
    }

    @Step("Check sort method from A to Z")
    public SauceDemoProductsPage checkAZName() {
        sortMenuCollection.get(0).should(exist).click();
        List<String> collection = new ArrayList<>();
        for (SelenideElement elem : itemsTitlesLink) {
            collection.add(elem.getText());
        }
        Collections.sort(collection);
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[@class='inventory_item']//a[contains(@id,'title')]"))) {
            expectedCollection.add(element.getText());
        }
        Assertions.assertEquals(collection, expectedCollection);
        return this;
    }

    @Step("Check sort method from Z to A")
    public SauceDemoProductsPage checkZAName() {
        sortMenuCollection.get(1).should(exist).click();
        List<String> collection = new ArrayList<>();
        for (SelenideElement elem : itemsTitlesLink) {
            collection.add(elem.getText());
        }
        Collections.sort(collection);
        Collections.reverse(collection);
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[@class='inventory_item']//a[contains(@id,'title')]"))) {
            expectedCollection.add(element.getText());
        }
        Assertions.assertEquals(collection, expectedCollection);
        return this;
    }

    @Step("Check sort method name from Z to A")
    public SauceDemoProductsPage checkZANameForErrorAndProblemUser() {
        sortMenuCollection.get(1).should(exist, clickable).click();
        List<String> collection = new ArrayList<>();
        for (SelenideElement elem : itemsTitlesLink) {
            collection.add(elem.getText());
        }
        Collections.sort(collection);
        Collections.reverse(collection);
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[@class='inventory_item']//a[contains(@id,'title')]"))) {
            expectedCollection.add(element.getText());
        }
        Assertions.assertNotEquals(collection, expectedCollection);
        return this;
    }

    @Step("Check sort method price (low to high)")
    public SauceDemoProductsPage checkPriceLowToHigh() {
        sortMenuCollection.get(2).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : itemsPrice) {
            expectedCollection.add(elem.getText());
        }
        List<Double> sortExpectedCollect =
                expectedCollection.stream().map(e -> Double.valueOf(e.replace("$", "")))
                        .sorted().toList();
        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[contains(@class,'item_price')]"))) {
            actualCollection.add(element.getText());
        }
        List<Double> sortActualCollect =
                actualCollection.stream().map(e -> Double.valueOf(e.replace("$", ""))).toList();
        Assertions.assertEquals(sortExpectedCollect, sortActualCollect);
        return this;
    }

    @Step("Check sort method price (high to low)")
    public SauceDemoProductsPage checkPriceHighToLow() {
        sortMenuCollection.get(3).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : itemsPrice) {
            expectedCollection.add(elem.getText());
        }
        List<Double> sortExpectedCollect =
                expectedCollection.stream().map(e -> Double.valueOf(e.replace("$", "")))
                        .sorted(Collections.reverseOrder()).toList();
        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[contains(@class,'item_price')]"))) {
            actualCollection.add(element.getText());
        }
        List<Double> sortActualCollect =
                actualCollection.stream().map(e -> Double.valueOf(e.replace("$", ""))).toList();
        Assertions.assertEquals(sortExpectedCollect, sortActualCollect);
        return this;
    }

    @Step("Check sort method price (low to high) for error and problem users")
    public SauceDemoProductsPage checkPriceLowToHighForErrorAndProblemUser() {
        sortMenuCollection.get(2).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : itemsPrice) {
            expectedCollection.add(elem.getText());
        }
        List<Double> sortExpectedCollect =
                expectedCollection.stream().map(e -> Double.valueOf(e.replace("$", "")))
                        .sorted().toList();
        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[contains(@class,'item_price')]"))) {
            actualCollection.add(element.getText());
        }
        List<Double> sortActualCollect =
                actualCollection.stream().map(e -> Double.valueOf(e.replace("$", ""))).toList();
        Assertions.assertNotEquals(sortExpectedCollect, sortActualCollect);
        return this;
    }

    @Step("Check sort method price (high to low) for error and problem users")
    public SauceDemoProductsPage checkPriceHighToLowForErrorAndProblemUser() {
        sortMenuCollection.get(3).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : itemsPrice) {
            expectedCollection.add(elem.getText());
        }
        List<Double> sortExpectedCollect =
                expectedCollection.stream().map(e -> Double.valueOf(e.replace("$", "")))
                        .sorted(Collections.reverseOrder()).toList();
        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[contains(@class,'item_price')]"))) {
            actualCollection.add(element.getText());
        }
        List<Double> sortActualCollect =
                actualCollection.stream().map(e -> Double.valueOf(e.replace("$", ""))).toList();
        Assertions.assertNotEquals(sortExpectedCollect, sortActualCollect);
        return this;
    }

    @Step("Click on 'add to cart' button")
    public SauceDemoProductsPage clickOnAddBtn(int index) {
        if (addRemoveToCartBtns.get(index).getText().contains("Add to cart")) {
            addRemoveToCartBtns.get(index).should(exist).click();
            Assertions.assertEquals(Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()),
                    $$(xpath("//button[text()='Remove']")).size());
        }
        return this;
    }

    @Step("click on remove button")
    public SauceDemoProductsPage clickOnRemoveBtn(int index) {
        if (addRemoveToCartBtns.get(index).getText().contains("Remove")) {
            addRemoveToCartBtns.get(index).should(exist).click();
            Assertions.assertEquals(Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()),
                    $$(xpath("//button[text()='Remove']")).size());
        }
        return this;
    }

    @Step("Click on shopping cart button")
    public SauceDemoCartPage clickOnCartBtn() {
        shoppingCartLink.should(exist).click();
        return new SauceDemoCartPage<>(this);
    }
}
