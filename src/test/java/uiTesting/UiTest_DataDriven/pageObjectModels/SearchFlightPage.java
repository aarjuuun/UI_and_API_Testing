package uiTesting.UiTest_DataDriven.pageObjectModels;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SearchFlightPage extends BasePage {

    //Logging in
    public static void login(WebDriver driver, String mailId,String pwd) throws InterruptedException {
        driver.findElement(By.xpath(continueWithEmailBtn)).click();
        Thread.sleep(2000);
        WebElement emailID = driver.findElement(By.xpath(enterEmailID));
        emailID.click();
        emailID.sendKeys(mailId);
        WebElement password=driver.findElement(By.xpath(enterPwd));
        password.click();
        password.sendKeys(pwd);
        driver.findElement(By.xpath(loginBtn)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(myAccountBtn)).click();
        Thread.sleep(3000);
        WebElement shownMailID=driver.findElement(By.xpath(mailID));
        if (shownMailID.getText().equals(mailId))
        {
            Assert.assertTrue(true);//Assertions
        }
        driver.findElement(By.xpath(myAccountBtn)).click();
    }
    public static void closeAds(WebDriver driver) throws InterruptedException {
        if (driver.findElement(By.cssSelector(advertisement)).isDisplayed()) //Assertions
        {
            driver.findElement(By.cssSelector(advertisement)).click();
        }
        Thread.sleep(500);
    }

    //Selecting Business Class for the travel
    public static void selectFlightClass(WebDriver driver) throws InterruptedException{
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(classTab)).click();
        Thread.sleep(600);
        driver.findElement(By.cssSelector(selectBusinessClass)).click();
        Thread.sleep(2000);
    }

    //Selecting departure City
    public static void departureAirport(WebDriver driver,String departure_input,String departure_expected) throws InterruptedException{
        WebElement departure = driver.findElement(By.xpath(departureTextBox));
        departure.click();
        departure.sendKeys(departure_input);
        Thread.sleep(1000);
        List<WebElement> departureCity = driver.findElements(By.xpath(departureAirportList));
        Thread.sleep(2000);
        for (WebElement element : departureCity) {
            String inner = element.getAttribute("innerHTML");
            System.out.println(inner);
            Thread.sleep(2000);
            if (inner.contentEquals(departure_expected)) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement couponText = wait.until(ExpectedConditions.elementToBeClickable(element));
                couponText.click();
                break;
            }
        }
        Thread.sleep(2000);
    }

    //Selecting arrival airport
    public static void arrivalAirports(WebDriver driver,String arrival_input,String arrival_expected) throws InterruptedException {
        WebElement arrival = driver.findElement(By.xpath(arrivalTextBox));
        arrival.click();
        arrival.sendKeys(arrival_input);
        Thread.sleep(1000);
        List<WebElement> arrivalCity = driver.findElements(By.cssSelector(arrivalAirportList));
        Thread.sleep(1000);
        //Stale Element Reference Exception is occurred
        try {
            for (WebElement element1 : arrivalCity) {
                String inner1 = element1.getText();
                Thread.sleep(1000);
                if (inner1.contentEquals(arrival_expected)) {
                    Thread.sleep(1000);
                    element1.click();
                    break;
                }
            }
        } catch (StaleElementReferenceException e) {
            arrivalCity = driver.findElements(By.cssSelector(".airport-code"));
            for (WebElement element1 : arrivalCity) {
                String inner1 = element1.getText();
                Thread.sleep(1000);
                if (inner1.contentEquals(arrival_expected)) {
                    Thread.sleep(1000);
                    element1.click();
                    break;
                }
            }
            Thread.sleep(2000);
        }
    }

    //Selecting the date
    public static void dateSelector(WebDriver driver, String monthAndYear, String date) throws ElementClickInterceptedException {
        driver.findElement(By.xpath(clickOnDateTab)).click();
        while(true)
        {
            String currentMonth=driver.findElement(By.xpath(selectMonth)).getText();
            if(currentMonth.equals(monthAndYear))
            {
                break;
            }
            else
                driver.findElement(By.xpath(goToNextMonth)).click();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<WebElement> list=driver.findElements(By.xpath(listOfDates));
        for (WebElement element:list) {
            String a=element.getText();
            if (a.contentEquals(date))
            {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
                WebElement elementClick= wait.until(ExpectedConditions.elementToBeClickable(element));
                elementClick.click();
            }

        }
    }
    //Submit Button
    public static void submitBtn(WebDriver driver)
    {
        driver.findElement(By.cssSelector(submitBtn)).click();
    }
}
