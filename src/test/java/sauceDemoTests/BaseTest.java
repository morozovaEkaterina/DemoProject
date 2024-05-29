package sauceDemoTests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {

    @Property("usernameS")
    public String usernameS;

    @Property("passwordS")
    public String passwordS;

    public BaseTest() {
        try {
            new PropertyLoader().loadProperties(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void clearLocalStorage() {
        Selenide.clearBrowserLocalStorage();
    }

    @AfterEach
    public void close() {
        closeWebDriver();
    }

}
