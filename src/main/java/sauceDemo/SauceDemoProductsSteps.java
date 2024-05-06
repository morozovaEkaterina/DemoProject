package sauceDemo;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.elementsPackage.SauceDemoProductsPageElements;
import sauceDemo.methodsPackage.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class SauceDemoProductsSteps extends BasePage<SauceDemoProductsSteps> {

    SauceDemoProductsPageElements productsPageElems = new SauceDemoProductsPageElements();

    @Step("Check static elements on the page")
    public SauceDemoProductsSteps checkStaticElementsOnProductPage() {
        Assertions.assertEquals("Swag Labs", productsPageElems.appLogo.getText());
        Assertions.assertTrue(productsPageElems.productSort.isDisplayed());
        Assertions.assertTrue(productsPageElems.shoppingCartLink.isDisplayed());
        Assertions.assertEquals(6, productsPageElems.inventoryList.size());
        return this;
    }

    @Step("Click on menu button and open wrap menu")
    public SauceDemoProductsSteps clickOnWrapMenu() {
        productsPageElems.menuBtn.should(exist).click();
        return this;
    }

    @Step("Check all positions:'All Items','About','Logout','Reset App State'")
    public SauceDemoProductsSteps checkAllPositionsInWrapMenu() {
        Assertions.assertEquals(4, productsPageElems.wrapMenuItems.size());
        Assertions.assertEquals("All Items", productsPageElems.wrapMenuItems.get(0).getText());
        Assertions.assertEquals("About", productsPageElems.wrapMenuItems.get(1).getText());
        Assertions.assertEquals("Logout", productsPageElems.wrapMenuItems.get(2).getText());
        Assertions.assertEquals("Reset App State", productsPageElems.wrapMenuItems.get(3).getText());
        Assertions.assertTrue(productsPageElems.exitBtnOnWrapMenu.isDisplayed());
        return this;
    }

    @Step("Click on button logout")
    public SauceDemoMainSteps clickOnLogoutBtn(int index) {
        productsPageElems.wrapMenuItems.get(index).click();
        return new SauceDemoMainSteps();
    }

    @Step("Click on button 'All Items' button")
    public SauceDemoProductsSteps clickOnAllItemsBtn(int index) {
        productsPageElems.wrapMenuItems.get(index).click();
        return this;
    }

    @Step("Click on sort button")
    public SauceDemoProductsSteps clickOnSortBtn() {
        productsPageElems.productSort.should(exist).click();
        return this;
    }

    @Step("Check elements on products cards")
    public SauceDemoProductsSteps checkElemsOnProductsCards() {
        for (int i = 0; i < productsPageElems.inventoryList.size(); i++) {
            Assertions.assertFalse(productsPageElems.inventoryList.isEmpty());
            Assertions.assertTrue(productsPageElems.itemsPrice.get(i).getText().contains("$"));
            Assertions.assertTrue(Integer.parseInt(productsPageElems.itemsPrice.get(i).getText().replaceAll("[^\\d]", "")) >= 0);
            Assertions.assertTrue(productsPageElems.itemsPictures.get(i).isDisplayed());
            Assertions.assertTrue(productsPageElems.itemsDescriptions.get(i).is(visible));
            Assertions.assertTrue( productsPageElems.addRemoveToCartBtns.get(i).getText().contains("Remove")||
                    productsPageElems.addRemoveToCartBtns.get(i).getText().contains("Add to cart"));
            Assertions.assertTrue(productsPageElems.addRemoveToCartBtns.get(i).is(clickable));
        }
        return this;
    }

    @Step("Click on product title")
    public SauceDemoItemSteps clickOnProductTitle(int index) {
        productsPageElems.itemsTitlesLink.get(index).should(exist).click();
        return new SauceDemoItemSteps<>(this);
    }

    @Step("Check sort menu")
    public SauceDemoProductsSteps checkSortMenu() {
        Assertions.assertEquals("Name (A to Z)", productsPageElems.sortMenuCollection.get(0).getText());
        Assertions.assertEquals("Name (Z to A)", productsPageElems.sortMenuCollection.get(1).getText());
        Assertions.assertEquals("Price (low to high)", productsPageElems.sortMenuCollection.get(2).getText());
        Assertions.assertEquals("Price (high to low)", productsPageElems.sortMenuCollection.get(3).getText());
        return this;
    }

    @Step("Check sort method from A to Z")
    public SauceDemoProductsSteps checkAZName() {
        productsPageElems.sortMenuCollection.get(0).should(exist).click();
        List<String> collection = new ArrayList<>();
        for (SelenideElement elem : productsPageElems.itemsTitlesLink) {
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
    public SauceDemoProductsSteps checkZAName() {
        productsPageElems.sortMenuCollection.get(1).should(exist).click();
        List<String> collection = new ArrayList<>();
        for (SelenideElement elem : productsPageElems.itemsTitlesLink) {
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
    public SauceDemoProductsSteps checkZANameForErrorAndProblemUser() {
        productsPageElems.sortMenuCollection.get(1).should(exist, clickable).click();
        List<String> collection = new ArrayList<>();
        for (SelenideElement elem : productsPageElems.itemsTitlesLink) {
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
    public SauceDemoProductsSteps checkPriceLowToHigh() {
        productsPageElems.sortMenuCollection.get(2).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : productsPageElems.itemsPrice) {
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
    public SauceDemoProductsSteps checkPriceHighToLow() {
        productsPageElems.sortMenuCollection.get(3).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : productsPageElems.itemsPrice) {
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
    public SauceDemoProductsSteps checkPriceLowToHighForErrorAndProblemUser() {
        productsPageElems.sortMenuCollection.get(2).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : productsPageElems.itemsPrice) {
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
    public SauceDemoProductsSteps checkPriceHighToLowForErrorAndProblemUser() {
        productsPageElems.sortMenuCollection.get(3).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>();
        for (SelenideElement elem : productsPageElems.itemsPrice) {
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
    public SauceDemoProductsSteps clickOnAddBtn(int index) {
        if (productsPageElems.addRemoveToCartBtns.get(index).getText().contains("Add to cart")) {
            productsPageElems.addRemoveToCartBtns.get(index).should(exist).click();
            Assertions.assertEquals(Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()),
                    $$(xpath("//button[text()='Remove']")).size());
        }
        return this;
    }

    @Step("click on remove button")
    public SauceDemoProductsSteps clickOnRemoveBtn(int index) {
        if (productsPageElems.addRemoveToCartBtns.get(index).getText().contains("Remove")) {
            productsPageElems.addRemoveToCartBtns.get(index).should(exist).click();
            Assertions.assertEquals(Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()),
                    $$(xpath("//button[text()='Remove']")).size());
        }
        return this;
    }

    @Step("Click on shopping cart button")
    public SauceDemoCartSteps clickOnCartBtn() {
        productsPageElems.shoppingCartLink.should(exist).click();
        return new SauceDemoCartSteps<>(this);
    }

    @Step("Click on close wrap menu button")
    public SauceDemoProductsSteps clickOnCloseWrapMenuBtn() {
        productsPageElems.closeWrapMenuBtn.should(exist).click();
        Assertions.assertEquals("true", productsPageElems.wrapMenuArea.getAttribute("aria-hidden"));
        return this;
    }
}
