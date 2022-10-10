package org.pagesObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class homePage {
    static WebDriver driver;

    //Constructor calling
    public homePage(WebDriver driver) {
        org.pageObjects.homePage.driver =driver;
    }


    //Close ads
    public static void closeAds(WebDriver driver) throws InterruptedException {
        if (driver.findElement(By.cssSelector("div.px-1.flex.flex-middle.nmx-1.pb-1")).isDisplayed()) //Assertions
        {
            driver.findElement(By.cssSelector("div.px-1.flex.flex-middle.nmx-1.pb-1")).click();
        }
        Thread.sleep(500);
        if (driver.findElement(By.cssSelector("svg.mt-3.mr-3.r-0.p-absolute.c-pointer")).isDisplayed()) //Assertions
        {
            driver.findElement(By.cssSelector("svg.mt-3.mr-3.r-0.p-absolute.c-pointer")).click();

        }
    }


    //Select which class of ticket
    public static void selectBusinessCls(WebDriver driver) throws InterruptedException{
        driver.findElement(By.cssSelector("div.p-relative.br-4")).click();
        Thread.sleep(600);
        driver.findElement(By.cssSelector("div.br-16.b-grey.py-1.px-3.lh-24.fs-3.d-inline-block.ml-4.mr-4.c-pointer")).click();
        Thread.sleep(200);
    }

    //Departure airport
    public static void departureAirport(WebDriver driver) throws InterruptedException{
        WebElement departure = driver.findElement(By.xpath("//input[@placeholder='Where from?']"));
        departure.click();
        departure.sendKeys("Ban");
        Thread.sleep(1000);
        List<WebElement> departureCity = driver.findElements(By.xpath("//ul[@class='airportList']//li/div/div/div"));
        Thread.sleep(1000);
        for (WebElement element : departureCity) {
            String inner = element.getAttribute("innerHTML");
            if (inner.contentEquals("BLR")) {
                element.click();
                break;
            }
        }
        Thread.sleep(2000);
    }

    //arrival airport
    public static void arrivalAirports(WebDriver driver) throws InterruptedException {
        WebElement arrival = driver.findElement(By.xpath("//input[@placeholder='Where to?']"));
        arrival.click();
        arrival.sendKeys("Dub");
        Thread.sleep(2000);
        List<WebElement> arrivalCity = driver.findElements(By.cssSelector(".airport-code"));
        Thread.sleep(1000);

        //Stale Element Reference Exception is occurred
        try {
            for (WebElement element1 : arrivalCity) {
                String inner1 = element1.getText();
                if (inner1.contentEquals("DXB")) {
                    element1.click();
                    break;
                }
            }
        } catch (StaleElementReferenceException e) {
            arrivalCity = driver.findElements(By.cssSelector(".airport-code"));
            for (WebElement element1 : arrivalCity) {
                String inner1 = element1.getText();
                if (inner1.contentEquals("DXB")) {
                    element1.click();
                    break;
                }
            }

            Thread.sleep(2000);
        }
    }

    //Select Date
    public static void dateSelector(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='fs-4 fw-500 c-inherit flex flex-nowrap ml-4']")).click();
        driver.findElement(By.xpath("//div[@class='DayPicker-Month']//div[@aria-label='Mon Oct 10 2022']")).click();
        Thread.sleep(500);
    }

    //Submit Button
    public static void submitBtn(WebDriver driver)
    {
        driver.findElement(By.cssSelector("span.fw-600.fs-4.lh-2.flex.flex-middle")).click();
    }
}
