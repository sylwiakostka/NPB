package MobileSittings.sauceLabsDesktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class TestConfigDesktop {


    public WebDriver driver = null;

    public static final String USERNAME = System.getenv("SAUCE_USERNAME");
    public static final String ACCESS_KEY = System.getenv("SAUCE_ACCESS_KEY");

    @Parameters({"browserName", "version", "platform"})
    @BeforeMethod
    public void createSauceDriver(String br, String vr, String pf, Method method) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("username", USERNAME);
        capabilities.setCapability("accessKey", ACCESS_KEY);
        capabilities.setCapability("browserName", br);
        capabilities.setCapability("version", vr);
        capabilities.setCapability("platform", pf);
        capabilities.setCapability("name", method.getName()+ " " + br + " " + pf);
        driver = new RemoteWebDriver(new URL("http://ondemand.eu-central-1.saucelabs.com/wd/hub"), capabilities);
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
