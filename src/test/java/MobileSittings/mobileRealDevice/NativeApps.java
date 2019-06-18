package MobileSittings.mobileRealDevice;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URL;

public class NativeApps {

    // to find "appPackage" and "appActivity" in cmd put adb devices and later adb shell dumpsys window windows |grep -E 'mCurrentFocus'
    private WebDriver driver;

    @Test
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Redmi Note 5");
        caps.setCapability("platformName", "Android");
        caps.setCapability(CapabilityType.VERSION, "8.0.1");
        caps.setCapability("noReset", "true");
        caps.setCapability("appPackage", "com.geckolab.eotaxi.passenger.demo");
        caps.setCapability("appActivity", "pl.itaxi.MainActivity");
        caps.setCapability("appWaitDuration", 5000);
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.geckolab.eotaxi.passenger.demo:id/fragLoginChooseType")));
        driver.findElement(By.id("com.geckolab.eotaxi.passenger.demo:id/fragLoginChooseType")).click();

    }
}


