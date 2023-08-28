package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P03_makeAppointmentPage extends  pageBase{
    WebDriver driver;

    public P03_makeAppointmentPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }
             P01_homePage homePage ;
         private By facilitTag =By.id("combo_facility");
            public WebElement facility()
            {
             return driver.findElement(facilitTag);
            }

        private  By hospotolCheckBox = By.id("chk_hospotal_readmission");
            public  void setHospotolCheck()
            {
               clickElement(driver.findElement(hospotolCheckBox));
            }

        private  By radioProgram = By.id("radio_program_medicare");
            public void radioProgramMedicare()
            {
              clickElement(driver.findElement(radioProgram));
            }


                //click on date picker
               private  By groupAddonBtn =By.className("input-group-addon") ;
                public void groupAddonBtnPiker(String day){
                    clickElement(driver.findElement(groupAddonBtn));
                    clickElement(driver.findElement(By.xpath("//td[@class = \"day\" and text()='"+day+"']")));

                }

                private By txtComment = By.id("txt_comment");
                public void comment(String txt)
                {
                    sendKeyElement(driver.findElement(txtComment), txt);
                }



                private By AppointmentBtn = By.id("btn-book-appointment");
                public void makeAppointmentBtn()
                {
                    clickElement(driver.findElement(AppointmentBtn));
                }



                private  By visitDate = By.id("visit_date");
                public  WebElement dateAssert ()
                {
                   return driver.findElement(visitDate);
                }

            private  By home = By.cssSelector("a[class=\"btn btn-default\"]");
                public void goTOHome(){
                    clickElement(driver.findElement(home));
                }










}
