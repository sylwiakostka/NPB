package NPB.tests;

import NPB.utilities.CaptureScreenshotOfElement;
import NPB.utilities.DriverFactory;
import NPB.utilities.DriverType;
import NPB.utilities.NowSuchDriverException;
import iTaxiPassanger.utilities.CaptureElementPicture;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.name;

public class BaseTests {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws NowSuchDriverException {

        driver = DriverFactory.getDriver(DriverType.CHROME);
        String url = "https://npb.jsdev.com.pl/login";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().deleteAllCookies();

    }




    @AfterMethod
    @Attachment(value = "Error screenshot", type = "image/png")
    public void TakeScreenshotOfFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot screenshot = (TakesScreenshot) driver;
                File src = screenshot.getScreenshotAs(OutputType.FILE);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
                Date date = new Date();
                String dateOfTest = sdf.format(date);
                FileUtils.copyFile(src, new File("C:\\Users\\user\\Desktop\\NPB\\screenshot\\" + " " + dateOfTest + " " + result.getName() + ".png"));
                System.out.println("Successfully captured a screenshot" + " " + dateOfTest + " " + result.getName());

            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
//            finally {
//                driver.quit();
//                DriverFactory.resetDriver();

//            }
        }
    }

}




