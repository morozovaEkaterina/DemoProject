package sauceDemoTests.allItemsPageTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sauceDemo.steps.LoginSteps;
import sauceDemoTests.BaseTest;

@DisplayName("Tests on sorting item`s name and price")
public class SortItemsTest extends BaseTest {

    @DisplayName("Check sorting item`s name from Z to A ")
    @Test
    public void checkSortNameZAStandardVisualGlitch() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnSortBtn()
                .checkListOFSortBtn()
                .checkSortingNameZA();
    }

    @DisplayName("Check sorting item`s name from A to Z ")
    @Test
    public void checkSortNameAZStandardVisualGlitch() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnSortBtn()
                .checkListOFSortBtn()
                .checkSortingNameZA()
                .checkSortingNameAZ();
    }

    @DisplayName("Check sorting item`s price from low to high")
    @Test
    public void checkSortPriceLowToHighStandardVisualGlitch() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnSortBtn()
                .checkListOFSortBtn()
                .checkSortingPriceLowToHigh();
    }

    @DisplayName("Check sorting item`s price from high to low")
    @Test
    public void checkSortPriceHighToLowStandardVisualGlitch() {
        LoginSteps.open("https://www.saucedemo.com")
                .waitPageLoading()
                .successfulLogin(usernameS, passwordS)
                .clickOnLoginBtnSuccessful()
                .checkURL("https://www.saucedemo.com/inventory.html")
                .checkStaticElementsOnAllItemsPage()
                .clickOnSortBtn()
                .checkListOFSortBtn()
                .checkSortingPriceHighToLow();
    }
}
