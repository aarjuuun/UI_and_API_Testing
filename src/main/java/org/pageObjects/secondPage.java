package org.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class secondPage {
    static void nonstopCheckbox(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));  //explicit wait
        WebElement nonstopcheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='flex flex-start pl-2']/p[text()='Non-stop']")));
        nonstopcheckbox.click();
        Thread.sleep(1000);
    }
    //Book button click
    static void bookBtn(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='col-19']/div[2]/div[8]/div/div/div/div/div[2]/div[4]/button")).click();
        Thread.sleep(1000);
    }
    static void handleWindow(WebDriver driver)
    {
        String main_window = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String child_window = i1.next();
            if (!main_window.equalsIgnoreCase(child_window)) {
                driver.switchTo().window(child_window);
                break;
            }
        }
    }
}
