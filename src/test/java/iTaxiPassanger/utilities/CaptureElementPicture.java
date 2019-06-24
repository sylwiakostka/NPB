package iTaxiPassanger.utilities;

import iTaxiPassanger.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class CaptureElementPicture extends BasePage {

    public CaptureElementPicture(AndroidDriver driver) {
        super(driver);
    }

    public File takeScreenshotOfElement(WebElement element) throws IOException {

// Get entire page screenshot
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage eleImg = ImageIO.read(screen);

// Get the location of element on the page
        Point point = element.getLocation();

// Get width and height of the element
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();

// Crop the entire page screenshot to get only element screenshot
        BufferedImage elementScreenshot = eleImg.getSubimage(point.getX(), point.getY(),
                eleWidth, eleHeight);
        ImageIO.write(elementScreenshot, "png", screen);

// Copy the element screenshot to disk
        File screenshotLocation = new File("C://Users//user//Desktop//NPB//src//test//java//iTaxiPassanger//tests//screenshotsToCompareInTests//screenshot.png");
        FileUtils.copyFile(screen, screenshotLocation);
        return screen;
    }
}
