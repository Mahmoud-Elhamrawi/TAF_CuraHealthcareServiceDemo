package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_LoginPage extends pageBase{
    WebDriver driver ;
    public P02_LoginPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }



    private   By userInput = By.id("txt-username");
    private By passInput = By.id("txt-password");
    private  By logBtn = By.id("btn-login");

public  void doLogin(String uname ,String  upass){

    sendKeyElement(driver.findElement(userInput),uname);
    sendKeyElement(driver.findElement(passInput),upass);
    clickElement(driver.findElement(logBtn));


}




}
