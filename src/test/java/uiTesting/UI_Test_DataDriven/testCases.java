package uiTesting.UI_Test_DataDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import uiTesting.UI_Test_DataDriven.pageObjectModels.itineraryPage;
import uiTesting.UI_Test_DataDriven.pageObjectModels.listOfFlightsPage;
import uiTesting.UI_Test_DataDriven.pageObjectModels.searchFlightPage;
import uiTesting.UI_Test_DataDriven.utilities.excelUtilities;

import java.io.IOException;


public class testCases {
    WebDriver driver;
    String link = "https://www.cleartrip.com/flights";
    String browser="Chrome";

    @BeforeClass()
    public void beforeTest() {
        switch (browser) {
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
        driver.get(link);
        driver.manage().window().maximize();
    }
//    @Test(dataProvider ="email_password",priority = 1)
//    public void loginPage(String mail,String pwd) throws InterruptedException {
//        searchFlightPage.login(driver,mail,pwd);
//    }

    @Test(dataProvider = "searchFlight",priority =1)
    public void selectingFlight(String givenDeparture,
                                String actualDeparture,
                                String givenArrival,
                                String actualArrival,
                                String monthAndYear,
                                String day,String CouponCode) throws InterruptedException {
        searchFlightPage.closeAds(driver);
        searchFlightPage.selectFlightClass(driver);
        searchFlightPage.departureAirport(driver,givenDeparture,actualDeparture);
        searchFlightPage.arrivalAirports(driver,givenArrival,actualArrival);
        searchFlightPage.dateSelector(driver,monthAndYear,day);
        searchFlightPage.submitBtn(driver);
        listOfFlightsPage.nonstopCheckbox(driver);
        listOfFlightsPage.bookBtn(driver);
        itineraryPage.enterCouponCode(driver,CouponCode);
        itineraryPage.scrollDown(driver);
        itineraryPage.clickContinueBtn(driver);
        itineraryPage.enterMobNumAndEmail(driver,"6235982345","arjunshyamarjuns@gmail.com");


    }

    @DataProvider(name="email_password")
    public Object[][] getData() throws IOException
    {
        //get the data from excel
        String path="src/test/resources/datas.xlsx";
        excelUtilities xlutil=new excelUtilities(path);

        int totalRows=xlutil.getRowCount("credentials");
        int totalCols=xlutil.getCellCount("credentials",1);

        String[][] loginData =new String[totalRows][totalCols];


        for(int i=1;i<=totalRows;i++)
        {
            for(int j=0;j<totalCols;j++)
            {
                loginData[i-1][j]=xlutil.getCellData("credentials", i, j);
            }

        }
        return loginData;
    }

    @DataProvider(name="searchFlight")
    public Object[][] getData1() throws IOException
    {
        //get the data from excel
        String path="src/test/resources/datas.xlsx";
        excelUtilities xlutil=new excelUtilities(path);

        int totalRows=xlutil.getRowCount("flight Searching");
        int totalCols=xlutil.getCellCount("flight Searching",1);

        String[][] loginData =new String[totalRows][totalCols];


        for(int i=1;i<=totalRows;i++)
        {
            for(int j=0;j<totalCols;j++)
            {
                loginData[i-1][j]=xlutil.getCellData("flight Searching", i, j);
            }

        }
        return loginData;
    }
}
