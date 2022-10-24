package uiTesting.UI_Test_HardCoded.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class itineraryPage {
   public static void couponCode(WebDriver driver) throws InterruptedException {
       Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  //explicit wait
        WebElement couponText = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.field.bw-1")));
        couponText.click();
        couponText.sendKeys("CTINT");
        driver.findElement(By.xpath("//form/div/button")).click();
        Thread.sleep(1000);
    }
    public static void continueBtn(WebDriver driver) throws InterruptedException {
        WebElement continueBtn = driver.findElement(By.xpath("//*[contains(text(),'Continue')]"));
            continueBtn.click();
        Thread.sleep(2000);
    }
    public static void enterMobile(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  //explicit wait
        WebElement mob = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-testid='mobileNumber']")));
        mob.click();
        mob.sendKeys("6235982345");
        Thread.sleep(1000);
    }
    public static void enterEmail(WebDriver driver) throws InterruptedException
    {
        WebElement email=driver.findElement(By.xpath("//input[@data-testid=\"email\"]"));
        email.click();
        email.sendKeys("arjunshyamarjuns@gmail.com");
        Thread.sleep(5000);
    }
    public static void continue1Btn(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  //explicit wait
        WebElement continueBtn1=driver.findElement(By.xpath("//div[6]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn1)).click();
        Thread.sleep(1000);
    }
}
