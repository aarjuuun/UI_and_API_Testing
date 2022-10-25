package uiTesting.UiTest_HardCoded.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static uiTesting.UiTest_HardCoded.utilities.selectors.*;

public class loginPage {
    public static void login(WebDriver driver) throws InterruptedException {
        driver.findElement(By.xpath(loginTab)).click();
        driver.findElement(By.xpath(continueWithEmailBtn)).click();
        WebElement mailID = driver.findElement(By.xpath(enterEmailID));
        mailID.click();
        mailID.sendKeys("arjunshyamarjuns@gmail.com");
        WebElement password = driver.findElement(By.xpath(enterPwd));
        password.click();
        password.sendKeys("$Abhimanyu86#");
        driver.findElement(By.xpath(loginBtn)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(myAccountBtn)).click();
        Thread.sleep(3000);
        WebElement shownMailID=driver.findElement(By.xpath(emailID));
        if (shownMailID.getText().equals("arjunshyamarjuns@gmail.com"))
            Assert.assertTrue(true);//Assertions

    }
}
