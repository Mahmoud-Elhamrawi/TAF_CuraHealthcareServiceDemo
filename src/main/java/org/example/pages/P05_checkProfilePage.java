package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P05_checkProfilePage extends pageBase{
    WebDriver driver;
    public P05_checkProfilePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By profileLink = By.cssSelector("a[href=\"profile.php#profile\"]");
    public void profile()
    {
        clickElement(driver.findElement(profileLink));
    }

 private By  textAsssert = By.cssSelector("div[class=\"col-lg-12 text-center\"] h2");
    public WebElement assertText()
    {
        return driver.findElement(textAsssert);
    }


    private  By logOutBtn = By.cssSelector("a[class=\"btn btn-default\"]");
    public  void logout()
    {
        clickElement(driver.findElement(logOutBtn));
    }












}
