package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public  WebDriver driver;



//    public WebDriver getDriver(){
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        return new ChromeDriver(options);
//    }
//
//    @BeforeClass
//    public void initializeSelenium(){
//        driver = getDriver();
//    }

    @BeforeClass
    public void openBrpwser(){
        //chrome Driver
        driver = new ChromeDriver();

        //configuration
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        //home url
        driver.get("https://katalon-demo-cura.herokuapp.com/");

    }



    @AfterClass
    public  void quitBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
