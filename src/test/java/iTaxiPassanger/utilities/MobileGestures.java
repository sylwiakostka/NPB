package iTaxiPassanger.utilities;

import iTaxiPassanger.pages.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;


public class MobileGestures extends BasePage {

    public MobileGestures(AndroidDriver driver) {
        super(driver);
    }

    public static void ScrollDown() {
        TouchAction action = new TouchAction(driver);
        Dimension dimensions = driver.manage().window().getSize();
        Double screenHeightStart = dimensions.getHeight() * 0.5;
        Double screenWidthStart = dimensions.getWidth() * 0.5;
        int h1 = screenHeightStart.intValue();
        int w1 = screenWidthStart.intValue();

        Double screenHeightEnd = dimensions.getHeight() * 0.2;
        Double screenWidthEnd = dimensions.getWidth() * 0.2;
        int h2 = screenHeightEnd.intValue();
        int w2 = screenWidthEnd.intValue();
        action.press(PointOption.point(w1, h1))
                .waitAction().moveTo(PointOption
                .point(w2, h2))
                .release().perform();
    }

    public static void ScrollUp() {
        TouchAction action = new TouchAction(driver);
        Dimension dimensions = driver.manage().window().getSize();
        Double screenHeightStart = dimensions.getHeight() * 0.5;
        Double screenWidthStart = dimensions.getWidth() * 0.5;
        int h1 = screenHeightStart.intValue();
        int w1 = screenWidthStart.intValue();

        Double screenHeightEnd = dimensions.getHeight() * 0.2;
        Double screenWidthEnd = dimensions.getWidth() * 0.2;
        int h2 = screenHeightEnd.intValue();
        int w2 = screenWidthEnd.intValue();
        action.press(PointOption.point(w2, h2))
                .waitAction().moveTo(PointOption
                .point(w1, h1))
                .release().perform();

    }

    public static void longPressOnElement(WebElement element) {
        TouchActions touchActions = new TouchActions(driver);
        touchActions.longPress(element).release().perform();
    }

    public static void scrollToElement (WebElement element){
        TouchActions touchActions = new TouchActions(driver);
        int xCoord = element.getLocation().getX();
        int yCoord = element.getLocation().getY();
        touchActions.scroll(element,xCoord,yCoord );
    }

}