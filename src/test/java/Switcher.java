import org.openqa.selenium.WebDriver;

public class Switcher {


    public void switchPAge(WebDriver driver) {
        for (String p : driver.getWindowHandles()) {
            if (!p.equals(driver.getWindowHandle())) {
                driver.switchTo().window(p);
            }
        }
    }
}
