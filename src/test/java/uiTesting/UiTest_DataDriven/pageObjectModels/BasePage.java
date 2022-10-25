package uiTesting.UiTest_DataDriven.pageObjectModels;

public class BasePage {

    static String continueWithEmailBtn ="//*[contains(text(),'Continue with Email')]";
    static String advertisement = "div.px-1.flex.flex-middle.nmx-1.pb-1";
    static String enterEmailID="//input[@placeholder='Enter registered email address']";
    static String enterPwd="//input[@placeholder='Enter password']";
    static String loginBtn="//span[@class='fs-3 fw-550']";
    static String myAccountBtn="//*[contains(text(),'My account')]";
    static String mailID = "//div[@class='fw-600 fs-3 c-neutral-900']";
    static String classTab= "div.p-relative.br-4";
    static String selectBusinessClass = "div.br-16.b-grey.py-1.px-3.lh-24.fs-3.d-inline-block.ml-4.mr-4.c-pointer";
    static String departureTextBox = "//input[@placeholder='Where from?']";
    static String departureAirportList = "//ul[@class='airportList']//li/div/div/div";
    static String arrivalTextBox = "//input[@placeholder='Where to?']";
    static String arrivalAirportList = ".airport-code";
    static String clickOnDateTab = "//div[@class='fs-4 fw-500 c-inherit flex flex-nowrap ml-4']";
    static String selectMonth = "//div[@class='DayPicker-Caption']";
    static String goToNextMonth = "//*[@data-testid='rightArrow']";
    static String listOfDates = "//div[@class='DayPicker-Body']/div/div[@aria-label]";
    static String submitBtn = "span.fw-600.fs-4.lh-2.flex.flex-middle";
    static String nonStop = "//div[@class='flex flex-start pl-2']/p[text()='Non-stop']";
    static String bookBtn = "//div[@class='col-19']/div[2]/div[8]/div/div/div/div/div[2]/div[4]/button";
    static String couponTextBox = "//input[@placeholder]";
    static String applyBtn = "button.apply-button";
    static String continueBtn = "//button[contains(text(), \"Continue\")]";
    static String mobNumberTextBox = "//input[@data-testid=\"mobileNumber\"]";
    static String mailIDTextBox = "//input[@data-testid=\"email\"]";
    static String signOutBtn = "//*[contains(text(),'Sign out')]";
}
