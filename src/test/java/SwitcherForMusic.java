import org.openqa.selenium.WebDriver;

public class SwitcherForMusic {
    public void switchPage(WebDriver driver) {
        for (String p : driver.getWindowHandles()) {
            if (!p.equals(driver.getWindowHandle())) {
                driver.switchTo().window(p);
            }
        }
    }
}
