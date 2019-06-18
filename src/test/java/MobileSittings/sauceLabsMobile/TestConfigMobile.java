package MobileSittings.sauceLabsMobile;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class TestConfigMobile {


    WebDriver driver;
    public static final String USERNAME = System.getenv("SAUCE_USERNAME");
    public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

    @Parameters({"browserName",  "platformName","deviceName","platformVersion"})
    @BeforeMethod
    public void createSauceDriver(String br, String pfN, String dv, String pfV, Method method) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", USERNAME);
        capabilities.setCapability("accessKey", ACCESS_KEY);
        capabilities.setCapability("browserName", br);
        capabilities.setCapability("platformName", pfN);
        capabilities.setCapability("deviceName", dv);
        capabilities.setCapability("platformVersion", pfV);
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("appiumVersion", "1.9.1");
        capabilities.setCapability("name", method.getName() + " " + br + " " + pfN + " " + pfV);
        driver = new AndroidDriver<>(new URL("http://ondemand.eu-central-1.saucelabs.com/wd/hub"),capabilities);
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}

