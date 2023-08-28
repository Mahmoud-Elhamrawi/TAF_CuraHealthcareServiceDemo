package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P04_historyPage extends pageBase{
    WebDriver driver ;
    public P04_historyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By menuToggle = By.id("menu-toggle");
    public void menuToggleBtn()
    {
        clickElement(driver.findElement(menuToggle));
    }


    private  By historyLink = By.cssSelector("a[href=\"history.php#history\"]");
    public void history()
    {
        clickElement(driver.findElement(historyLink));
    }

    private  By count = By.cssSelector("div[class=\"container\"] div[class=\"row\"]:nth-child(2)");
    public List<WebElement> countEle()
    {
        return driver.findElements(count);
    }



















}
