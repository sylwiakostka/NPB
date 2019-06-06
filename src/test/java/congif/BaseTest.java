package congif;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utilities.DriverFactory;
import utilities.DriverType;
import utilities.NowSuchDriverException;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws NowSuchDriverException {
        driver = DriverFactory.getDriver(DriverType.CHROME);
        String startUrl = "https://taxi.demo.eo.pl/taxi-business-client-web/login.html";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(startUrl);
    }

    @AfterMethod
    public void quit() {
        driver.quit();
        DriverFactory.resetDriver();
    }
}



