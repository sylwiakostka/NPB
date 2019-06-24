package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MapPage extends BasePage {


    public MapPage(AndroidDriver driver) {
        super(driver);
    }
    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/taxiMapRoot")
    private WebElement map;



    public MapPage verifyMap() {
        waitForVisibilityOfElement(map);
        Assert.assertTrue(map.isDisplayed());
        return this;
    }



}
