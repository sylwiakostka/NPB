package congif;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utilities.DriverFactory;
import utilities.DriverType;
import utilities.NowSuchDriverException;
import java.util.concurrent.TimeUnit;



public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() throws NowSuchDriverException {
        driver = DriverFactory.getDriver(DriverType.IE);
        String startUrl = "https://phptravels.com/demo/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(startUrl);
    }

    @AfterTest
    public void quit() {
        if (null != driver) {
            driver.quit();
        }
    }


}
