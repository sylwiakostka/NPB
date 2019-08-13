package NPB.utilities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


public class CaptureScreenshotOfElement extends NPB.pages.BasePage {

    public CaptureScreenshotOfElement(WebDriver driver) {
        super(driver);
    }

    public File takeScreenshotOfElement(WebElement element) throws IOException {

        // Take screen shot of whole web page
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Point point = element.getLocation();
        int width = element.getSize().getWidth();
        int height = element.getSize().getHeight();

        Rectangle rectangle = new Rectangle(width, height);

        BufferedImage img = ImageIO.read(screenShot);

        BufferedImage dest = img.getSubimage(point.getX(), point.getY(), rectangle.width, rectangle.height);

        // write cropped image into File Object
        ImageIO.write(dest, "png", screenShot);

        // Copy the element screenshot to disk
        File screenshotLocation = new File("C://Users//user//Desktop//NPB//src//test//java//NPB//tests//ScreenshotsToCompareInTests//screenshot.png");
        FileUtils.copyFile(screenShot, screenshotLocation);
        return screenShot;
    }
}
