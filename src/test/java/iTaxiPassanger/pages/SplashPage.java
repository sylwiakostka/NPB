package iTaxiPassanger.pages;

import iTaxiPassanger.utilities.CaptureElementPicture;
import iTaxiPassanger.utilities.CompareScreens;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

public class SplashPage extends BasePage {
    public SplashPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiMapChooseUser")
    private WebElement mainScreen;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiMapLogin")
    private WebElement logInButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiMapVoucher")
    private WebElement voucherButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiMapRegister")
    private WebElement registerButton;

    @FindBy (id = "com.android.packageinstaller:id/permission_message")
    private WebElement localizationPermision;

    @FindBy (id = "com.android.packageinstaller:id/permission_allow_button")
    private WebElement allowButton;


    @Step
    public SplashPage verifyMainScreen() {
        waitForVisibilityOfElement(mainScreen);
        Assert.assertTrue(mainScreen.isDisplayed());
        return this;
    }

    @Step
    public void compareScreensSplash() throws IOException {
        String scrFile = "C://Users//user//Desktop//NPB//src//test//java//iTaxiPassanger//tests//screenshotsToCompareInTests//screenshot.png";
        String splashPage = "C://Users//user//Desktop//NPB//src//test//java//iTaxiPassanger//tests//screenshotsToCompareInTests//splashPage.png";
        new CaptureElementPicture(driver).takeScreenshotOfElement(mainScreen);
        Assert.assertEquals(CompareScreens.Result.SizeMismatch, CompareScreens.CompareImage(splashPage, scrFile));
    }

    @Step
    public void  screen () throws IOException {
        new CaptureElementPicture(driver).takeScreenshotOfElement(mainScreen);
    }

    @Step
    public LogInPage goToLogInPage() {
        logInButton.click();
        new LogInPage(driver).verifyLogInPageHeader();
        return new LogInPage(driver);
    }

    @Step
    public VoucherPage goToVoucherPage() {
        voucherButton.click();
        return new VoucherPage(driver).verifyVoucherPageHeader().verifyVoucherPageHeader();
    }

    @Step
    public RegisterPageB2C goToRegisterPage() {
        registerButton.click();
        new RegisterPageB2C(driver).verifyRegisterPage();
        return new RegisterPageB2C(driver);
    }

    @Step
    public SplashPage allowPermision (){
        waitForVisibilityOfElement(localizationPermision);
        Assert.assertTrue(localizationPermision.getAttribute("text").contains("lokalizacji"));
        allowButton.click();
        return this;
    }
}
