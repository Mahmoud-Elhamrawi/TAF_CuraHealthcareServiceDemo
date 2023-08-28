package Tests;

import org.example.pages.P03_makeAppointmentPage;
import org.example.pages.P04_historyPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TC02_CheckHistoryTest extends TestBase{
     P04_historyPage historyPage ;
    SoftAssert softAssert = new SoftAssert();
   @Test
    public void checkHistory() throws InterruptedException {
        historyPage = new P04_historyPage(driver);
        historyPage.menuToggleBtn();

        Thread.sleep(1000);
        historyPage.history();

       System.out.println(driver.getCurrentUrl());
       softAssert.assertTrue(driver.getCurrentUrl().contains("history"));

       List<WebElement> x  = historyPage.countEle();
       System.out.println(x.size());
       softAssert.assertEquals(1,x.size());












      softAssert.assertAll();
   }





}
