package iTaxiPassanger.tests;


import iTaxiPassanger.utilities.ReadSMS;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.net.URL;

public class BaseTests {
    public AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Redmi Note 5");
        caps.setCapability("platformName", "Android");
        caps.setCapability(CapabilityType.VERSION, "8.0.1");
        caps.setCapability("noReset", "true");
        caps.setCapability("appPackage", "com.geckolab.eotaxi.passenger.demo");
        caps.setCapability("appActivity", "pl.itaxi.MainActivity");
        caps.setCapability("appWaitDuration", 10000);
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }


//    @Test
//    public void readSMS() {
//        ReadSMS readOTPValue = new ReadSMS();
//        readOTPValue.readSMS();
//
//    }
}


//    @AfterMethod
//    public void quit() {
//        driver.closeApp();
//    }


