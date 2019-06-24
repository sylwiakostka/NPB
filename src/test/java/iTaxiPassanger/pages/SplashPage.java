package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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


    public SplashPage verifyMainScreen() {
        waitForVisibilityOfElement(mainScreen);
        Assert.assertTrue(mainScreen.isDisplayed());
        return this;
    }

    public LogInPage goToLogInPage() {
        logInButton.click();
        new LogInPage(driver).verifyLogInPageHeader();
        return new LogInPage(driver);
    }

    public VoucherPage goToVoucherPage() {
        voucherButton.click();
        return new VoucherPage(driver).verifyVoucherPageHeader().verifyVoucherPageHeader();
    }

    public RegisterPageB2C goToRegisterPage() {
        registerButton.click();
        new RegisterPageB2C(driver).verifyRegisterPage();
        return new RegisterPageB2C(driver);
    }
}
