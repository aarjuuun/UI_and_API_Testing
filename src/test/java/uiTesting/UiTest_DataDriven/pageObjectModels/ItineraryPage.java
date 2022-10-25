package uiTesting.UiTest_DataDriven.pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ItineraryPage extends BasePage {


    //Enter the coupon code for extra discount
    public static void enterCouponCode(WebDriver driver,String code) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement couponText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(couponTextBox)));
        couponText.click();
        couponText.sendKeys(code);
        driver.findElement(By.cssSelector(applyBtn)).click();
        Thread.sleep(2000);
    }

    //Scroll down to the bottom of page
    public static void scrollDown(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
    }

    //Click on the Continue Button
    public static void clickContinueBtn(WebDriver driver) throws InterruptedException {
        WebElement clickBtn = driver.findElement(By.xpath(continueBtn));
        if (clickBtn.isDisplayed())
            clickBtn.click();
        Thread.sleep(1000);
    }

    //Enter mobile num and email ID
    public static void enterMobNumAndEmail(WebDriver driver,String mobileNum, String email) throws InterruptedException {
        WebElement mob=driver.findElement(By.xpath(mobNumberTextBox));
        mob.click();
        mob.clear();
        mob.sendKeys(mobileNum);
        WebElement mail=driver.findElement(By.xpath(mailIDTextBox));
        mail.click();
        mail.clear();
        mail.sendKeys(email);
        Thread.sleep(1000);
    }
    public static void clickSignOut(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath(myAccountBtn)).click();
        driver.findElement(By.xpath(signOutBtn)).click();
        Thread.sleep(2000);
    }



}
