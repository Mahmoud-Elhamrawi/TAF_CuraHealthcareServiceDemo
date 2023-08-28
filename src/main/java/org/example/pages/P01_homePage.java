package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_homePage extends pageBase{
    WebDriver driver ;
    public P01_homePage(WebDriver driver) {
        super(driver);
        this.driver =driver;
    }


    private By makeApp = By.id("btn-make-appointment");
    public  void   makeAppBtn(){
        clickElement(driver.findElement(makeApp));
    }



}
