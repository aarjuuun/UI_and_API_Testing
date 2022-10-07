import io.github.bonigarcia.wdm.WebDriverManager;
import org.pageObjects.homePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases
{
    WebDriver driver;
    homePage obj1;
    public static String browser="Chrome";

@BeforeTest
    public void beforeTest() throws InterruptedException {
    switch (browser)
    {
        case "Chrome" -> {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        case "Firefox" -> {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        case "Safari" -> {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        }
        default -> throw new IllegalStateException("Unexpected value: " + browser);

    }
    driver.get("https://www.cleartrip.com/flights");
    driver.manage().window().maximize();
    Thread.sleep(2000);
}
@Test(priority = 0)
public void closingAds() throws InterruptedException {
    obj1=new homePage(driver);
    homePage.closeAds(driver);
}
@Test(priority = 1)
public void ticketClass() throws InterruptedException {
    obj1=new homePage(driver);
    homePage.selectBusinessCls(driver);
}
@Test(priority = 2)
public void testDeparture() throws InterruptedException {
    obj1=new homePage(driver);
    homePage.departureAirport(driver);
}
@Test(priority = 3)
public void testArrival() throws InterruptedException {
    obj1=new homePage(driver);
    homePage.arrivalAirports(driver);
}
@Test(priority = 4)
public void testDate() throws InterruptedException {
    obj1=new homePage(driver);
    homePage.dateSelector(driver);
}
@Test(priority = 5)
public void testSubmit(){
    obj1=new homePage(driver);
    homePage.submitBtn(driver);
}


@AfterTest
    public void afterTest()
{
    driver.quit();
}

}
