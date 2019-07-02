package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MapPage extends BasePage {


    public MapPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiMapRoot")
    private WebElement map;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiMapMenuLeft")
    private WebElement openMenuButton;


    @Step
    public MapPage verifyMap() {
        waitForVisibilityOfElement(map);
        Assert.assertTrue(map.isDisplayed());
        return this;
    }

    @Step
    public MenuPage openMenu() {
        openMenuButton.click();
        new MenuPage(driver).verifyMenuPage();
        return new MenuPage(driver);
    }


}
