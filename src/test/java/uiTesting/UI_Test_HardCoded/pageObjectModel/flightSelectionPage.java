package uiTesting.UI_Test_HardCoded.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiTesting.UI_Test_HardCoded.utilities.selectors;

import java.time.Duration;

public class flightSelectionPage {
    //Select non stop flights
    public static void nonstopCheckbox(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  //explicit wait

        WebElement nonStopCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectors.nonStopCheckBox1)));
        if (nonStopCheckbox.isDisplayed())
            nonStopCheckbox.click();
        Thread.sleep(1000);
    }
    //Book button click
    public static void bookBtn(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectors.bookButton))).click();
        Thread.sleep(1000);
    }

}

