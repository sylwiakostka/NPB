package iTaxiPassanger.pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BasePage {

    static protected AndroidDriver driver;
    private WebDriverWait wait;

    static String scrShotDir = "screenshots";
    static File scrShotDirPath = new java.io.File("./" + scrShotDir + "//");
    String destFile;


    public BasePage(AndroidDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private static final int WAIT_TIMEOUT = 30;

    protected void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    protected String readToastMessage() throws TesseractException {
        String imgName = takeScreenShotOfPage();
        String result;
        File imageFile = new File(scrShotDirPath, imgName);
        System.out.println("Image name is :" + imageFile.toString());
        ITesseract instance = new Tesseract();

        File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Extracts
        // Tessdata
        // folder
        // from
        // referenced
        // tess4j
        // jar
        // for
        // language
        // support
        instance.setDatapath(tessDataFolder.getAbsolutePath()); // sets tessData
        // path

        result = instance.doOCR(imageFile);
        System.out.println(result);
        return result;
    }


    protected String takeScreenShotOfPage() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        new File(scrShotDir).mkdirs(); // Create folder under project with name
        // "screenshots" if doesn't exist
        destFile = dateFormat.format(new Date()) + ".png"; // Set file name
        // using current
        // date time.
        try {
            FileUtils.copyFile(scrFile, new File(scrShotDir + "/" + destFile)); // Copy
            // paste
            // file
            // at
            // destination
            // folder
            // location
        } catch (IOException e) {
            System.out.println("Image not transfered to screenshot folder");
            e.printStackTrace();
        }
        return destFile;
    }

}






