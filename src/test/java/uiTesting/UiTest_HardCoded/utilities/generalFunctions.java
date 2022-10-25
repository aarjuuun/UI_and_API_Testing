package uiTesting.UiTest_HardCoded.utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class generalFunctions {

    public static void handleWindow(WebDriver driver) throws InterruptedException {
        String main_window = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        for (String child_window : s1) {
            if (!main_window.equalsIgnoreCase(child_window)) {
                driver.switchTo().window(child_window);
                break;
            }
        }
        Thread.sleep(1000);
    }
    public static void scrollDown(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
    }
}
