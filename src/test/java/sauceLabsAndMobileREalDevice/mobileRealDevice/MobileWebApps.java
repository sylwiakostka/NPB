package sauceLabsAndMobileREalDevice.mobileRealDevice;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileWebApps {

    private WebDriver driver;

    @Test
    public void setUp () throws Exception {
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("platformVersion","8.1.0");
        caps.setCapability("platformName","Android");
        caps.setCapability("deviceName","Redmi Note 5");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);


        driver.get("https://taxi.demo.eo.pl/taxi-business-client-web/index.html");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loginForm"))));
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("sylwia");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.tagName("button")).click();
        driver.quit();





    }
}
