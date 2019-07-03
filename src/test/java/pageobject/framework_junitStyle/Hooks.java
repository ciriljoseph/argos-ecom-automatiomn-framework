package pageobject.framework_junitStyle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

  public static WebDriver driver;

    @Before

    public void Browser() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();


        driver = new FirefoxDriver();
        driver.get("https://www.argos.co.uk/");
        //OpenBrowser("Chrome","https://www.argos.co.uk/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".privacy-prompt-footer")).click();

    }

//    @After
//    public void BrowserQuit() {
//
//        driver.quit();
//    }
}

