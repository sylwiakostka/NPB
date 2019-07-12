package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/menuProfilePayments")
    private WebElement paymentsButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/menuProfilePromotionCodes")
    private WebElement promotionsButton;


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
    public PaymentPage openPaymentPage() {
        paymentsButton.click();
        new PaymentPage(driver).verifyPaymentPage();
        return new PaymentPage(driver);
    }


    @Step
    public MenuPage logInAndOpenMenu(String userName, String password) {
        new LogInPage(driver)
                .verifyLogInPageHeader()
                .logAsB2CUser(userName, password)
                .openMenu()
                .verifyMenuPage();
        return this;
    }

    @Step
    public MenuPage registerAndOpenMenu() throws InterruptedException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markAllAgreementsAndAcceptB2C();
        return this;
    }

    @Step
    public PromotionsPage openPromotionsPage() {
        promotionsButton.click();
        new PromotionsPage(driver).verifyPromotionPageHeader();
        return new PromotionsPage(driver);
    }
}
