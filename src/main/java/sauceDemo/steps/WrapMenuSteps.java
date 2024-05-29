package sauceDemo.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemo.page.AllItemsPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public abstract class WrapMenuSteps<P> {
    AllItemsPage productsElems = new AllItemsPage();

    @Step("Click on wrap menu button")
    public P clickOnWrapMenu() {
        productsElems.menuBtn.should(exist).click();
        return (P) this;
    }

    @Step("Click on 'Reset App State' button")
    public P clickOnResetAppStateBtn() {
        productsElems.wrapMenuItems.get(3).should(text("Reset App State")).click();
        return (P) this;
    }

    @Step("Click on 'Logout' button")
    public LoginSteps clickOnLogoutBtn() {
        productsElems.wrapMenuItems.get(2).should(text("Logout")).click();
        return new LoginSteps();
    }

    @Step("Click on button 'All Items' button")
    public AllItemsSteps clickOnAllItemsBtn() {
        productsElems.wrapMenuItems.get(0).should(text("All Items")).click();
        return new AllItemsSteps();
    }

    @Step("Click on close wrap menu button")
    public P clickOnCloseWrapMenuBtn() {
        productsElems.closeWrapMenuBtn.should(exist).click();
        Assertions.assertEquals("true",
                productsElems.wrapMenuArea.getAttribute("aria-hidden"));
        return (P) this;
    }

    @Step("Check click on close wrap menu button")
    public P checkClickOnCloseWrapMenuBtn() {
        Assertions.assertEquals("true",
                productsElems.wrapMenuArea.getAttribute("aria-hidden"));
        return (P) this;
    }

    @Step("Check working of 'Reset App State' button")
    public P checkClickResetAppStateBtn() {
        $(xpath("//span[contains(@class,'badge')]")).shouldNot(exist);
        return (P) this;
    }
}
