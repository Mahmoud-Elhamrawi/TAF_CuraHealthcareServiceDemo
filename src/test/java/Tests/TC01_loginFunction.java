package Tests;

import org.example.pages.P01_homePage;
import org.example.pages.P02_LoginPage;
import org.example.pages.P03_makeAppointmentPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC01_loginFunction extends  TestBase {

    P01_homePage homePage;
    P02_LoginPage loginPage;
    P03_makeAppointmentPage makeAppointmentPage ;
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void loginFunction() throws InterruptedException {
        homePage = new P01_homePage(driver);
        homePage.makeAppBtn();

        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(driver.getCurrentUrl().contains("profile.php#login"));

        loginPage = new P02_LoginPage(driver);
        loginPage.doLogin("John Doe", "ThisIsNotAPassword");

        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(driver.getCurrentUrl().contains("appointment"));

        makeAppointmentPage =new P03_makeAppointmentPage(driver);

        Select select = new Select(makeAppointmentPage.facility());
        select.selectByValue("Tokyo CURA Healthcare Center");

        makeAppointmentPage.setHospotolCheck();

        makeAppointmentPage.radioProgramMedicare();

        makeAppointmentPage.groupAddonBtnPiker("18");

        makeAppointmentPage.comment("fist make Appointment");

        makeAppointmentPage.makeAppointmentBtn();


        System.out.println(driver.getCurrentUrl());
        softAssert.assertTrue(driver.getCurrentUrl().contains("appointment.php#summary"));

        System.out.println(makeAppointmentPage.dateAssert().getText());
        softAssert.assertEquals("18/08/2023",makeAppointmentPage.dateAssert().getText());












        softAssert.assertAll();
    }














}