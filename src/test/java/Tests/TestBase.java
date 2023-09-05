package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public RemoteWebDriver driver;


    @BeforeClass
    public void openBrpwser() throws MalformedURLException {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("latest");

        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-mahmoudelhamrawi5-03c11");
        sauceOptions.put("accessKey", "8a8aad57-32e5-4ca1-8d85-4df8c53b6455");
        sauceOptions.put("build", "selenium-build-R8OKT");
        sauceOptions.put("name", "end 2 end scenario");
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);







        //configuration
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

        //home url


    }



    @AfterClass
    public  void quitBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
