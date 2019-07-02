package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MenuPage extends BasePage {
    public MenuPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/menuProfileHi")
    private WebElement hiInfo;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragLoginChooseType")
    private WebElement chooseUserSwitch;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/menuProfileUserName")
    private WebElement profileButton;


    @Step
    public MenuPage verifyMenuPage() {
        waitForVisibilityOfElement(hiInfo);
        Assert.assertTrue(hiInfo.isDisplayed());
        if (chooseUserSwitch.getText().equals("WYŁ")) {
            Assert.assertTrue(hiInfo.getText().contains("Cześć"));
        } else if (chooseUserSwitch.getText().equals("WŁ")) {
            Assert.assertTrue(hiInfo.getText().contains("Dzień dobry"));
        }
        return this;
    }

    @Step
    public MyAccountPage openMyAccountPage() {
        profileButton.click();
        new MyAccountPage(driver).verifyMyAccountPage();
        return new MyAccountPage(driver);
    }


    @Step
    public MenuPage makeBeReadyToUseMenu(String userName, String password) {
        new LogInPage(driver)
                .verifyLogInPageHeader()
                .logAsB2CUser(userName, password)
                .openMenu()
                .verifyMenuPage();
        return new MenuPage(driver);
    }
}
