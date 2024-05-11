package sauceDemo.stepsPackage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.BaseSteps;
import sauceDemo.elementsPackage.ProductsPageElements;
import sauceDemo.elementsPackage.components.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class ProductsPageSteps extends BaseSteps<ProductsPageSteps> {

    ProductsPageElements productsElems = new ProductsPageElements();

    @Step("Check static elements on the page")
    public ProductsPageSteps checkStaticElementsOnProductPage() {
        Assertions.assertEquals("Swag Labs", productsElems.appLogo.getText());
        Assertions.assertEquals(6, productsElems.inventoryList.size());
        return this;
    }

    @Step("Click on menu button and open wrap menu")
    public ProductsPageSteps clickOnWrapMenu() {
        productsElems.menuBtn.should(exist).click();
        return this;
    }

    @Step("Check all positions:'All Items','About','Logout','Reset App State'")
    public ProductsPageSteps checkAllPositionsInWrapMenu() {
        Assertions.assertEquals(4, productsElems.wrapMenuItems.size());
        Assertions.assertEquals("All Items", productsElems.wrapMenuItems.get(0).getText());
        Assertions.assertEquals("About", productsElems.wrapMenuItems.get(1).getText());
        Assertions.assertEquals("Logout", productsElems.wrapMenuItems.get(2).getText());
        Assertions.assertEquals("Reset App State", productsElems.wrapMenuItems.get(3).getText());
        Assertions.assertTrue(productsElems.exitBtnOnWrapMenu.isDisplayed());
        return this;
    }

    @Step("Click on button logout")
    public LoginPageSteps clickOnLogoutBtn(int index) {
        productsElems.wrapMenuItems.get(index).click();
        return new LoginPageSteps();
    }

    @Step("Click on button 'All Items' button")
    public ProductsPageSteps clickOnAllItemsBtn(int index) {
        productsElems.wrapMenuItems.get(index).click();
        return this;
    }

    @Step("Click on sort button")
    public ProductsPageSteps clickOnSortBtn() {
        productsElems.productSort.should(exist).click();
        return this;
    }

    @Step("Check elements on products cards")
    public ProductsPageSteps checkElemsOnProductsCards() {
        for (int i = 0; i < productsElems.inventoryList.size(); i++) {
            Assertions.assertFalse(productsElems.inventoryList.isEmpty());
            Assertions.assertTrue(productsElems.elements().get(i).price().getText().contains("$"));
            Assertions.assertTrue(Integer.parseInt(productsElems.elements().get(i).price().getText().replaceAll("[^\\d]", "")) >= 0);
            Assertions.assertTrue(productsElems.elements().get(i).addRemoveBtn().getText().contains("Remove") ||
                    productsElems.elements().get(i).addRemoveBtn().getText().contains("Add to cart"));
        }
        return this;
    }

    @Step("Click on product title")
    public ItemPageSteps clickOnProductTitle(int index) {
        productsElems.elements().get(index).title().should(exist).click();
        return new ItemPageSteps<>(this);
    }

    @Step("Check sort menu")
    public ProductsPageSteps checkSortMenu() {
        Assertions.assertEquals("Name (A to Z)", productsElems.sortMenuCollection.get(0).getText());
        Assertions.assertEquals("Name (Z to A)", productsElems.sortMenuCollection.get(1).getText());
        Assertions.assertEquals("Price (low to high)", productsElems.sortMenuCollection.get(2).getText());
        Assertions.assertEquals("Price (high to low)", productsElems.sortMenuCollection.get(3).getText());
        return this;
    }

    @Step("Check sort method from A to Z")
    public ProductsPageSteps checkAZName() {
        productsElems.sortMenuCollection.get(0).should(exist).click();
        List<String> collection = new ArrayList<>();
        for (SelenideElement elem : productsElems.elements().stream().map(Product::title).toList()) {
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
    public ProductsPageSteps checkZAName() {
        productsElems.sortMenuCollection.get(1).should(exist).click();
        List<String> collection = new ArrayList<>();
        for (SelenideElement elem : productsElems.elements().stream().map(Product::title).toList()) {
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
    public ProductsPageSteps checkZANameForErrorAndProblemUser() {
        productsElems.sortMenuCollection.get(1).should(exist, clickable).click();
        List<String> collection = new ArrayList<>();
        for (SelenideElement elem : productsElems.elements().stream().map(Product::title).toList()) {
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
    public ProductsPageSteps checkPriceLowToHigh() {
        productsElems.sortMenuCollection.get(2).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : productsElems.elements().stream().map(Product::price).toList()) {
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
    public ProductsPageSteps checkPriceHighToLow() {
        productsElems.sortMenuCollection.get(3).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : productsElems.elements().stream().map(Product::price).toList()) {
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
    public ProductsPageSteps checkPriceLowToHighForErrorAndProblemUser() {
        productsElems.sortMenuCollection.get(2).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : productsElems.elements().stream().map(Product::price).toList()) {
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
    public ProductsPageSteps checkPriceHighToLowForErrorAndProblemUser() {
        productsElems.sortMenuCollection.get(3).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : productsElems.elements().stream().map(Product::price).toList()) {
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
    public ProductsPageSteps clickOnAddBtn(int index) {
        if (productsElems.elements().get(index).addRemoveBtn().getText().contains("Add to cart")) {
            productsElems.elements().stream().map(Product::addRemoveBtn).toList().get(index).should(exist).click();
            Assertions.assertEquals(Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()),
                    $$(xpath("//button[text()='Remove']")).size());
        }
        return this;
    }

    @Step("click on remove button")
    public ProductsPageSteps clickOnRemoveBtn(int index) {
        if (productsElems.elements().stream().map(Product::addRemoveBtn).toList().get(index).getText().contains("Add to cart")) {
            productsElems.elements().stream().map(Product::addRemoveBtn).toList().get(index).should(exist).click();
            Assertions.assertEquals(Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()),
                    $$(xpath("//button[text()='Remove']")).size());
        }
        return this;
    }

    @Step("Click on shopping cart button")
    public CartPageSteps clickOnCartBtn() {
        productsElems.shoppingCartLink.should(exist).click();
        return new CartPageSteps<>(this);
    }

    @Step("Click on close wrap menu button")
    public ProductsPageSteps clickOnCloseWrapMenuBtn() {
        productsElems.closeWrapMenuBtn.should(exist).click();
        Assertions.assertEquals("true", productsElems.wrapMenuArea.getAttribute("aria-hidden"));
        return this;
    }
}
