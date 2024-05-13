package sauceDemo.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.BaseSteps;
import sauceDemo.page.ProductsPageElements;
import sauceDemo.page.components.Product;

import java.util.*;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.xpath;

public class ProductsPageSteps extends BaseSteps<ProductsPageSteps> {

    ProductsPageElements productsElems = new ProductsPageElements();

    @Step("Check static page on the page")
    public ProductsPageSteps checkStaticElementsOnProductPage() {
        productsElems.appLogo.should(text("Swag Labs"));
        productsElems.inventoryList.should(size(6));
        return this;
    }

    @Step("Click on menu button and open wrap menu")
    public ProductsPageSteps clickOnWrapMenu() {
        productsElems.menuBtn.should(exist).click();
        return this;
    }

    @Step("Click on button logout")
    public LoginPageSteps clickOnResetAppStateBtn() {
        productsElems.wrapMenuItems.get(3).should(text("Reset App State")).click();
        return new LoginPageSteps();
    }

    @Step("Click on button logout")
    public LoginPageSteps clickOnLogoutBtn() {
        productsElems.wrapMenuItems.get(2)
                .should(text("Logout"))
                .click();
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

    @Step("Check page on products cards")
    public ProductsPageSteps checkElemsOnProductsCards() {
        for (int i = 0; i < productsElems.inventoryList.size(); i++) {
            productsElems.inventoryList.should(CollectionCondition.sizeGreaterThan(0));
            productsElems.elements().forEach(e -> e.price().should(text("$")));
            Assertions.assertTrue(Integer.parseInt(productsElems.elements().get(i).price().getText().replaceAll("[^\\d]", "")) >= 0);
            productsElems.elements().forEach(e -> e.addRemoveBtn().should(or("", text("Add to cart"), text("Remove"))));
        }
        return this;
    }

    @Step("Click on product title")
    public ItemPageSteps<ProductsPageSteps> clickOnProductTitle(int index) {
        productsElems.elements()
                .get(index)
                .title()
                .should(exist)
                .click();
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
        List<String> expectedCollection = productsElems.elements().stream().map(e -> e.title().getText())
                .sorted()
                .toList();
        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[@class='inventory_item']//a[contains(@id,'title')]"))) {
            actualCollection.add(element.getText());
        }
        Assertions.assertEquals(expectedCollection, actualCollection);
        return this;
    }

    @Step("Check sort method from Z to A")
    public ProductsPageSteps checkZAName() {
        productsElems.sortMenuCollection.get(1).should(exist).click();
        List<String> expectedCollection = new ArrayList<>(productsElems.elements().stream()
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

    @Step("Check sort method name from Z to A")
    public ProductsPageSteps checkZANameForErrorAndProblemUser() {
        productsElems.sortMenuCollection.get(1).should(exist, clickable).click();
        List<String> expectedCollection = new ArrayList<>(productsElems.elements().stream()
                .map(e -> e.title().getText())
                .sorted()
                .toList());
        Collections.reverse(expectedCollection);

        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[@class='inventory_item']//a[contains(@id,'title')]"))) {
            actualCollection.add(element.getText());
        }
        Assertions.assertNotEquals(expectedCollection, actualCollection);
        return this;
    }


    @Step("Check sort method price (low to high)")
    public ProductsPageSteps checkPriceLowToHigh() {
        productsElems.sortMenuCollection.get(2).should(exist, clickable).click();
        List<Double> expectedCollection = productsElems.elements().stream()
                .map(e -> Double.parseDouble(e.price().getText().replace("$", ""))).toList();

        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[contains(@class,'item_price')]"))) {
            actualCollection.add(element.getText());
        }
        List<Double> actualCollect =
                actualCollection.stream().map(e ->
                        Double.valueOf(e.replace("$", ""))).toList();
        Assertions.assertEquals(expectedCollection, actualCollect);
        return this;
    }

    @Step("Check sort method price (high to low)")
    public ProductsPageSteps checkPriceHighToLow() {
        productsElems.sortMenuCollection.get(3).should(exist, clickable).click();
        List<Double> expectedCollection = productsElems.elements().stream().map(e -> Double.parseDouble(e.price().getText()
                .replace("$", ""))).toList();

        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[contains(@class,'item_price')]"))) {
            actualCollection.add(element.getText());
        }
        List<Double> actualCollect =
                actualCollection.stream().map(e ->
                        Double.valueOf(e.replace("$", ""))).toList();
        Assertions.assertEquals(expectedCollection, actualCollect);
        return this;
    }


    @Step("Check sort method price (low to high) for error and problem users")
    public ProductsPageSteps checkPriceLowToHighForErrorAndProblemUser() {
        productsElems.sortMenuCollection.get(2).should(exist, clickable).click();
        List<Double> expectedCollection = productsElems.elements().stream().map(e ->
                        Double.parseDouble(e.price().getText().replace("$", "")))
                .sorted()
                .toList();

        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[contains(@class,'item_price')]"))) {
            actualCollection.add(element.getText());
        }
        List<Double> actualCollect =
                actualCollection.stream().map(e -> Double.valueOf(e.replace("$", ""))).toList();
        Assertions.assertNotEquals(expectedCollection, actualCollect);
        return this;
    }

    @Step("Check sort method price (high to low) for error and problem users")
    public ProductsPageSteps checkPriceHighToLowForErrorAndProblemUser() {
        productsElems.sortMenuCollection.get(3).should(exist, clickable).click();
        List<Double> expectedPrices = productsElems.elements().stream()
                .map(element -> Double.parseDouble(element.price().getText().replace("$", "")))
                .sorted(Comparator.reverseOrder())
                .toList();

        List<String> actualCollection = new ArrayList<>();
        for (SelenideElement element : $$(xpath("//div[contains(@class,'item_price')]"))) {
            actualCollection.add(element.getText());
        }
        List<Double> sortActualCollect =
                actualCollection.stream().map(e -> Double.valueOf(e.replace("$", ""))).toList();
        Assertions.assertNotEquals(expectedPrices, sortActualCollect);
        return this;
    }

    @Step("Click on 'add to cart' button successful")
    public ProductsPageSteps clickOnAddBtnSuccessful() {
        productsElems.elements().stream()
                .map(Product::addRemoveBtn)
                .forEach(e -> e.should(text("Add to cart")).click());
        return this;
    }

    @Step("Check that click on 'add to cart' button successful")
    public ProductsPageSteps checkClickOnAddBtnSuccessful() {
        Assertions.assertEquals(Integer.parseInt($(xpath("//span[contains(@class,'badge')]")).getText()),
                $$(xpath("//button[text()='Remove']")).size());
        return this;
    }

    @Step("click on 'remove' button successful")
    public ProductsPageSteps clickOnRemoveBtnSuccessful() {
        productsElems.elements().stream()
                .map(Product::addRemoveBtn)
                .forEach(e -> e.should(text("Add to cart")).click());

        productsElems.elements().forEach(e -> e.addRemoveBtn().should(text("Remove")));
        productsElems.elements().stream()
                .map(Product::addRemoveBtn).forEach(e -> e.should(exist).click());
        $(xpath("//span[contains(@class,'badge')]")).shouldNot(visible);

        return this;
    }

    @Step("Click on 'add to cart' button unsuccessful")
    public ProductsPageSteps clickOnAddBtnUnsuccessful() {
        productsElems.elements().stream()
                .map(Product::addRemoveBtn)
                .forEach(e -> e.should(text("Add to cart"), clickable).click());
        return this;
    }

    @Step("Check click on 'add to cart' button unsuccessful")
    public ProductsPageSteps checkClickOnAddBtnUnsuccessful() {
        Assertions.assertNotEquals(productsElems.elements().stream().map(Product::addRemoveBtn).toList().size(),
                $$(xpath("//button[text()='Remove']")).size());
        return this;
    }

    @Step("click on 'remove' button unsuccessful")
    public ProductsPageSteps clickOnRemoveBtnUnsuccessful() {
        productsElems.elements().stream()
                .map(Product::addRemoveBtn)
                .forEach(e -> e.should(text("Add to cart"), clickable).click());
        Assertions.assertNotEquals(productsElems.elements().stream().map(Product::addRemoveBtn).toList().size(),
                $$(xpath("//button[text()='Remove']")).size());

        productsElems.elements().forEach(e -> e.addRemoveBtn().should(text("Remove").or(text("Add to cart"))));
        productsElems.elements().stream()
                .map(Product::addRemoveBtn)
                .forEach(SelenideElement::click);
        $(xpath("//span[contains(@class,'badge')]")).should(visible);
        return this;
    }

    @Step("Click on shopping cart button")
    public CartPageSteps<ProductsPageSteps> clickOnCartBtn() {
        productsElems.shoppingCartLink.should(exist).click();
        return new CartPageSteps<>(this);
    }

    @Step("Click on close wrap menu button")
    public ProductsPageSteps clickOnCloseWrapMenuBtn() {
        productsElems.closeWrapMenuBtn.should(exist).click();
        Assertions.assertEquals("true",
                productsElems.wrapMenuArea.getAttribute("aria-hidden"));
        return this;
    }

    @Step("Check click on close wrap menu button")
    public ProductsPageSteps checkClickOnCloseWrapMenuBtn() {
        Assertions.assertEquals("true",
                productsElems.wrapMenuArea.getAttribute("aria-hidden"));
        return this;
    }
}
