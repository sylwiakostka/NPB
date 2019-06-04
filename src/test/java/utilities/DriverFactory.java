package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import java.io.File;


public class DriverFactory {
    private static WebDriver driver;


    public static WebDriver getDriver(DriverType driverType) throws NowSuchDriverException {
        if (driver == null) {
            getSpecificDriver(driverType);
            driver.manage().window().maximize();
        }
        return driver;

    }

    private static void getSpecificDriver(DriverType driverType) throws NowSuchDriverException {
        switch (driverType) {
            case IE:
                File ieExe = new File("src/main/resources/IEDriverServer.exe");
                InternetExplorerDriverService ieService = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(ieExe)
                        .usingAnyFreePort().build();
                driver = new InternetExplorerDriver(ieService);
                break;

            case FIREFOX:
                File firefoxExe = new File("src/main/resources/geckodriver.exe");
                GeckoDriverService geckoService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(firefoxExe)
                        .usingAnyFreePort().build();
                driver = new FirefoxDriver(geckoService);
                break;

            case CHROME:
                File chromeExe = new File("src/main/resources/chromedriver.exe");
                ChromeDriverService chromeService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(chromeExe)
                        .usingAnyFreePort().build();
                driver = new ChromeDriver(chromeService);
                break;

            default:
                System.out.println("Brak drivera danego typu");
                throw new NowSuchDriverException();

        }
    }
}
