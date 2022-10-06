package org.ClearTrip;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class thirdPage {

    static void couponCode(WebDriver driver, WebDriverWait wait) throws InterruptedException {
        WebElement couponText = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.field.bw-1")));
        couponText.click();
        couponText.sendKeys("CTINT");
        driver.findElement(By.cssSelector("button.apply-button")).click();
        Thread.sleep(1000);
    }
    static void scrollDown(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(1000);
    }
    static void continueBtn(WebDriver driver) throws InterruptedException {
        WebElement continuebtn = driver.findElement(By.xpath("//button[contains(text(), \"Continue\")]"));
        if (continuebtn.isDisplayed())
            continuebtn.click();
        Thread.sleep(1000);
    }
    static void enterMobile(WebDriver driver) throws InterruptedException {
        WebElement mob=driver.findElement(By.xpath("//input[@data-testid=\"mobileNumber\"]"));
        mob.click();
        mob.sendKeys("6235982345");
        Thread.sleep(1000);
    }
    static void enterEmail(WebDriver driver) throws InterruptedException
    {
        WebElement email=driver.findElement(By.xpath("//input[@data-testid=\"email\"]"));
        email.click();
        email.sendKeys("arjunshyamarjuns@gmail.com");
        Thread.sleep(5000);
    }
    static void continue1Btn(WebDriver driver,WebDriverWait wait)
    {
        WebElement continueBtn1=driver.findElement(By.xpath("//div[6]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn1)).click();
    }
}
