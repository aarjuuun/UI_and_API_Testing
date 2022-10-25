package uiTesting.UiTest_HardCoded.pageObjectModel;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import uiTesting.UiTest_HardCoded.utilities.selectors;

import java.util.List;

public class homePage {

    //Close ads
    public static void closeAds(WebDriver driver) throws InterruptedException {
        if (driver.findElement(By.cssSelector(selectors.ads)).isDisplayed()) //Assertions
        {
            driver.findElement(By.cssSelector(selectors.ads)).click();
        }
        Thread.sleep(500);
    }


    //Select which class of ticket
    public static void selectBusinessCls(WebDriver driver) throws InterruptedException{
        driver.findElement(By.cssSelector(selectors.clickClassTab)).click();
        Thread.sleep(600);
        driver.findElement(By.cssSelector(selectors.selectBusinessClass)).click();
        Thread.sleep(200);
    }

    //Departure airport
    public static void departureAirport(WebDriver driver) throws InterruptedException{
        WebElement departure = driver.findElement(By.xpath(selectors.clickDepartureTab));
        departure.click();
        departure.sendKeys("Ban");
        Thread.sleep(2500);
        List<WebElement> departureCity = driver.findElements(By.xpath(selectors.departureAirportList));
        for (WebElement element : departureCity) {
            String inner = element.getAttribute("innerHTML");
            Thread.sleep(1500);
            if (inner.contentEquals("BLR")) {
                Thread.sleep(1500);
                element.click();
                break;
            }
        }
        Thread.sleep(2000);
    }

    //arrival airport
    public static void arrivalAirports(WebDriver driver) throws InterruptedException {
        WebElement arrival = driver.findElement(By.xpath(selectors.clickArrivalTab));
        arrival.click();
        arrival.sendKeys("Dub");
        Thread.sleep(2000);
        List<WebElement> arrivalCity = driver.findElements(By.cssSelector(selectors.arrivalAirportList));
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
            arrivalCity = driver.findElements(By.cssSelector(selectors.arrivalAirportList));
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
        driver.findElement(By.xpath(selectors.clickDateTab)).click();
        //driver.findElement(By.xpath("//div[@class='DayPicker-Month']//div[@aria-label='Mon Oct 10 2022']")).click();
        String month="January 2023";
        String date="13";
        try
        {
            while(true) {
                String element = driver.findElement(By.xpath(selectors.selectMonth)).getText();
                if (element.equals(month)) {
                    System.out.println(month);
                    break;
                } else {
                    System.out.println("else part"+ element);
                    driver.findElement(By.xpath(selectors.arrowBtn)).click();
                }

            }
            List<WebElement> elementList=driver.findElements(By.xpath(selectors.selectDate));
            for (WebElement element:elementList) {
                String text =element.getText();
                String[] dateSplit = text.split("\n");
                System.out.println(dateSplit[0]);
                if (dateSplit[0].contentEquals(date))
                {
                    Thread.sleep(1000);
                    element.click();
                    break;
                }
            }
}
        catch ( InterruptedException e)
        {
            while(true)
            {
                String element=driver.findElement(By.xpath(selectors.selectMonth)).getText();
                if(element.equals(month))
                {
                    break;
                }
                else {
                    driver.findElement(By.xpath(selectors.arrowBtn)).click();
                }
            }

            List<WebElement> elementList=driver.findElements(By.xpath(selectors.selectDate));

            for (WebElement element:elementList) {
                String a=element.getText();
                if (a.equals(date))
                {
                    Thread.sleep(2000);
                    element.click();
                }
            }
        }
    }

    //Submit Button
    public static void submitBtn(WebDriver driver)
    {
        driver.findElement(By.cssSelector(selectors.clickSubmitBtn)).click();
    }
}
