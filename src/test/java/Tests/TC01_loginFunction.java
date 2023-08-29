package Tests;

import org.example.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TC01_loginFunction extends  TestBase {

    P01_homePage homePage;
    P02_LoginPage loginPage;
    P03_makeAppointmentPage makeAppointmentPage ;
    P05_checkProfilePage checkProfilePage ;
    SoftAssert softAssert = new SoftAssert();


    P04_historyPage historyPage ;


    @Test(priority = 1)
    public void loginFunction() throws InterruptedException {
        homePage = new P01_homePage(driver);
        homePage.makeAppBtn();

        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(driver.getCurrentUrl().contains("profile.php#login"));

        loginPage = new P02_LoginPage(driver);
        loginPage.doLogin("John Doe", "ThisIsNotAPassword");

        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(driver.getCurrentUrl().contains("appointment"));

        makeAppointmentPage = new P03_makeAppointmentPage(driver);

        Select select1 = new Select(makeAppointmentPage.facility());
        select1.selectByValue("Tokyo CURA Healthcare Center");

        makeAppointmentPage.setHospotolCheck();

        makeAppointmentPage.radioProgramMedicare();

        makeAppointmentPage.groupAddonBtnPiker("18");

        makeAppointmentPage.comment("fist make Appointment");

        makeAppointmentPage.makeAppointmentBtn();


        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(driver.getCurrentUrl().contains("appointment.php#summary"));

        System.out.println(makeAppointmentPage.dateAssert().getText());
        softAssert.assertEquals("18/08/2023",makeAppointmentPage.dateAssert().getText());



        makeAppointmentPage.goTOHome();
        Thread.sleep(2000);

        homePage.makeAppBtn();
        Thread.sleep(1000);

        Select select = new Select(makeAppointmentPage.facility());
        select.selectByValue("Seoul CURA Healthcare Center");

        makeAppointmentPage.setHospotolCheck();

        makeAppointmentPage.radioProgramMedicare();

        makeAppointmentPage.groupAddonBtnPiker("8");

        makeAppointmentPage.comment("second make Appointment");

        makeAppointmentPage.makeAppointmentBtn();


        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(driver.getCurrentUrl().contains("appointment.php#summary"));

        System.out.println(makeAppointmentPage.dateAssert().getText());
        softAssert.assertEquals("08/08/2023",makeAppointmentPage.dateAssert().getText());

        makeAppointmentPage.goTOHome();

        softAssert.assertAll();
    }




    @Test(priority = 2)
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




   @Test(priority = 3)
    private  void  checkprofile() throws InterruptedException {

      makeAppointmentPage.goTOHome();
      historyPage.menuToggleBtn();

      checkProfilePage = new P05_checkProfilePage(driver);

      checkProfilePage.profile();
      System.out.println(driver.getCurrentUrl());
      softAssert.assertTrue(driver.getCurrentUrl().contains("profile"));

      softAssert.assertEquals("Profile",checkProfilePage.assertText().getText());

      Thread.sleep(1000);

      checkProfilePage.logout();
       System.out.println(driver.getCurrentUrl());
     softAssert.assertTrue(driver.getCurrentUrl().contains("cura.herokuapp.com"));

        softAssert.assertAll();
  }













}