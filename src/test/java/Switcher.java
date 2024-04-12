import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Switcher {

    public void switchOnNewPage(WebDriver driver) {
        String nowWindow = driver.getWindowHandle();
        Set<String> pages = driver.getWindowHandles();
        List<String> pagesList = new ArrayList<>(pages);
        for (String p : pages) {
            if (!p.equals(nowWindow)) {
                driver.switchTo().window(p);
            }
        }
    }
}
