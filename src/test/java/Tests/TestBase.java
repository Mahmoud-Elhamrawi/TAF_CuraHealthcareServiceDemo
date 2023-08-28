package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public  WebDriver driver;

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
