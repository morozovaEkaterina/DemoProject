package sauceDemo.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.BaseSteps;
import sauceDemo.page.AllItemsPage;


import java.util.*;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class AllItemsSteps extends BaseSteps<AllItemsSteps> {

    AllItemsPage allItems = new AllItemsPage();

    @Step("Check static elements on the page")
    public AllItemsSteps checkStaticElementsOnAllItemsPage() {
        allItems.appLogo.should(text("Swag Labs"));
        allItems.inventoryList.should(size(6));
        return this;
    }

    @Step("Click on sort button")
    public AllItemsSteps clickOnSortBtn() {
        allItems.productSort.should(exist).click();
        return this;
    }

    @Step("Check elements on items cards")
    public AllItemsSteps checkElemsOnItemsCards() {
        for (int i = 0; i < allItems.inventoryList.size(); i++) {
            allItems.inventoryList.should(CollectionCondition.sizeGreaterThan(0));
            allItems.elements()
                    .forEach(e -> e.price().should(text("$")));
            Assertions.assertTrue(Integer.parseInt(allItems.elements().get(i).price().getText()
                    .replaceAll("[^\\d]", "")) >= 0);
            allItems.elements().forEach(e -> e.addRemoveBtn().should(or("", text("Add to cart"), text("Remove"))));
        }
        return this;
    }

    @Step("Check list of sort button")
    public AllItemsSteps checkListOFSortBtn() {
        Assertions.assertEquals("Name (A to Z)", allItems.sortMenuCollection.get(0).getText());
        Assertions.assertEquals("Name (Z to A)", allItems.sortMenuCollection.get(1).getText());
        Assertions.assertEquals("Price (low to high)", allItems.sortMenuCollection.get(2).getText());
        Assertions.assertEquals("Price (high to low)", allItems.sortMenuCollection.get(3).getText());
        return this;
    }

    @Step("Check sorting name from A to Z")
    public AllItemsSteps checkSortingNameAZ() {
        allItems.sortMenuCollection.get(0).should(exist).click();
        List<String> expectedCollection = allItems.elements().stream()
                .map(e -> e.title().getText())
                .sorted()
                .toList();
        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[@class='inventory_item']//a[contains(@id,'title')]"))) {
            actualCollection.add(element.getText());
        }
        Assertions.assertEquals(expectedCollection, actualCollection);
        return this;
    }

    @Step("Check sorting name from Z to A")
    public AllItemsSteps checkSortingNameZA() {
        allItems.sortMenuCollection.get(1).should(exist).click();
        List<String> expectedCollection = new ArrayList<>(allItems.elements().stream()
                .map(e -> e.title().getText())
                .sorted()
                .toList());
        Collections.reverse(expectedCollection);
        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[@class='inventory_item']//a[contains(@id,'title')]"))) {
            actualCollection.add(element.getText());
        }
        Assertions.assertEquals(expectedCollection, actualCollection);
        return this;
    }

    @Step("Check sorting price from low to high")
    public AllItemsSteps checkSortingPriceLowToHigh() {
        allItems.sortMenuCollection.get(2).should(exist, clickable).click();
        List<Double> expectedCollection = allItems.elements().stream()
                .map(e -> Double.parseDouble(e.price().getText().replace("$", "")))
                .toList();

        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[contains(@class,'item_price')]"))) {
            actualCollection.add(element.getText());
        }
        List<Double> actualCollect =
                actualCollection.stream()
                        .map(e -> Double.valueOf(e.replace("$", "")))
                        .toList();
        Assertions.assertEquals(expectedCollection, actualCollect);
        return this;
    }

    @Step("Check sorting price from high to low")
    public AllItemsSteps checkSortingPriceHighToLow() {
        allItems.sortMenuCollection.get(3).should(exist, clickable).click();
        List<Double> expectedCollection = allItems.elements().stream()
                .map(e -> Double.parseDouble(e.price().getText().replace("$", "")))
                .toList();

        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[contains(@class,'item_price')]"))) {
            actualCollection.add(element.getText());
        }
        List<Double> actualCollect =
                actualCollection.stream()
                        .map(e -> Double.valueOf(e.replace("$", "")))
                        .toList();
        Assertions.assertEquals(expectedCollection, actualCollect);
        return this;
    }

    @Step("Click on item title : {title}")
    public IndividualItemSteps<AllItemsSteps> clickOnItemTitle(String title) {
        allItems.elements().stream()
                .filter(e -> e.title().getText().equals(title))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No product with title: " + title)).title().click();
        return new IndividualItemSteps<>(this);
    }

    @Step("Check click on 'Add to cart' button")
    public AllItemsSteps checkClickOnAddToCartBtn() {
        Assertions.assertEquals(Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()),
                $$(xpath("//button[text()='Remove']")).size());
        return this;
    }

    @Step("Check click on 'Add to cart' button with no items")
    public AllItemsSteps checkClickOnAddToCartBtnNoItems() {
        $(xpath("//span[contains(@class,'badge')]")).shouldNot(exist);
        Assertions.assertEquals(0, $$(xpath("//button[text()='Remove']")).size());
        return this;
    }

    @Step("click on 'Remove' button")
    public AllItemsSteps clickOnRemoveBtn(String... titles) {
        for (String title : titles) {
            allItems.elements().stream()
                    .filter(e -> e.title().getText().equals(title))
                    .forEach(x -> x.addRemoveBtn().should(text("Remove"), exist).click());
        }
        return this;
    }

    @Step("click on 'Add to cart' button")
    public AllItemsSteps clickOnAddToCartBtn(String... titles) {
        for (String title : titles) {
            allItems.elements().stream()
                    .filter(e -> e.title().getText().equals(title))
                    .forEach(x -> x.addRemoveBtn().should(text("Add to cart"), exist).click());
        }
        return this;
    }


    @Step("Check that counter badge is not exist on the cart")
    public AllItemsSteps checkCounterBadgeIsNotExist() {
        $(xpath("//span[contains(@class,'badge')]")).shouldNot(exist);
        Assertions.assertEquals(0, $$(xpath("//button[text()='Remove']")).size());
        return this;
    }

    @Step("Click on cart button")
    public CartSteps<AllItemsSteps> clickOnCartBtn() {
        allItems.shoppingCartLink.should(exist).click();
        return new CartSteps<>(this);
    }
}
