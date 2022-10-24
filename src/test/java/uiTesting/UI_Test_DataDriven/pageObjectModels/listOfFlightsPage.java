package uiTesting.UI_Test_DataDriven.pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class listOfFlightsPage extends basePage{

    //Click on the non-stop checkBox
    public static void nonstopCheckbox(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  //explicit wait
        WebElement nonStopCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(nonStop)));
        nonStopCheckbox.click();
        Thread.sleep(1000);
    }

    //Click on "Book" button
    public static void bookBtn(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath(bookBtn)).click();
        Thread.sleep(5000);
    }
}
