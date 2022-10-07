//package org.pageObjects;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class Main {
//    public static String browser="Chrome";
//
//
//    //Webdriver Interface
//    public static WebDriver driver;
//
//    public Main(WebDriver driver) {
//        Main.driver =driver;
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//
//        switch (browser) {
//            case "Chrome" -> {
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }
//            case "Firefox" -> {
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            }
//            case "Safari" -> {
//                WebDriverManager.safaridriver().setup();
//                driver = new SafariDriver();
//            }
//            default -> throw new IllegalStateException("Unexpected value: " + browser);
//        }
//
//        //Go to the website
//        homePage.openPage(driver);
////--------------------------------------------------FIRST PAGE----------------------------------------------------------
//        //close ads
//        homePage.closeAds(driver);
//
//        /*
//        //Round Trip
//        driver.findElement(By.xpath("//div[@class='fs-2 c-inherit flex flex-nowrap']")).click();
//        driver.findElement(By.xpath("//div[@class='bg-white br-4 elevation-5 p-1 p-absolute mt-2 z-50 l-0']/ul/li[@value='rt']")).click();
//        */
//
//        //Select Business class
//        homePage.selectBusinessCls(driver);
//
//        //Departure airport
//        homePage.departureAirport(driver);
//
//        //arrival airport
//        homePage.arrivalAirports(driver);
//
//        //Select Date
//        homePage.dateSelector(driver);
//
//        //Submit Button
//        homePage.submitBtn(driver);
//
////--------------------------------------------------NEXT PAGE-----------------------------------------------------------
//        //Non-Stop Checkbox
//        secondPage.nonstopCheckbox(driver);
//
//        //Click Book button
//        secondPage.bookBtn(driver);
//
//        //Handle child window and Go to the next window
//        secondPage.handleWindow(driver);
//
////--------------------------------------------------NEW WINDOW----------------------------------------------------------
//        //Explicit wait
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//        //Coupon Code
//        thirdPage.couponCode(driver,wait);
//
//        //Scroll down
//        thirdPage.scrollDown(driver);
//
//        //Continue Button
//        thirdPage.continueBtn(driver);
//
//        //Enter Mobile Number
//        thirdPage.enterMobile(driver);
//
//        //Enter Email
//        thirdPage.enterEmail(driver);
//
//        //Continue Button
//        thirdPage.continue1Btn(driver,wait);
//
//    }
//}