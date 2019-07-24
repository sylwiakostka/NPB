package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

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

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/dialogButtonRight")
    private WebElement logOutConfirmButton;

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/parentPanel")
    private WebElement logUsersPanel;

    @FindBy (id = "android:id/button1")
    private WebElement zalogujPoRazPierwszyButton;

    @FindBy (id = "android:id/button2")
    private WebElement zalozKontoPrywatneButton;

    @FindBy (id = "android:id/button3")
    private WebElement wrocDoKontaBiznesowegoButton;

    @FindBy (id = "android:id/button3")
    private WebElement wrocDoKontaPrywatnegoButton;



    @Step
    public MenuPage verifyMenuPage() {
        waitForVisibilityOfElement(hiInfo);
        Assert.assertTrue(hiInfo.isDisplayed());
        if (chooseUserSwitch.getAttribute("content-desc").equals("Tryb prywatny, włącz tryb biznesowy")) {
            Assert.assertTrue(hiInfo.getText().contains("Cześć"));
        } else  Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb biznesowy, włącz tryb prywatny");
        return this;
    }

    @Step
    public MenuPage switchFromB2CToB2B(){
        Assert.assertTrue(hiInfo.isDisplayed());
        Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb prywatny, włącz tryb biznesowy");
        chooseUserSwitch.click();

        new MapPage(driver).openMenu();
        waitForVisibilityOfElement(hiInfo);
        Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb biznesowy, włącz tryb prywatny");
        return this;
    }

    @Step
    public MenuPage switchFromB2BToB2C(){
        Assert.assertTrue(hiInfo.isDisplayed());
        Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb biznesowy, włącz tryb prywatny");
        chooseUserSwitch.click();

        new MapPage(driver).openMenu();
        waitForVisibilityOfElement(hiInfo);
        Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb prywatny, włącz tryb biznesowy");
        return this;
    }

    @Step
    public MenuPage logB2CUserByMenuPanel(String b2cUserName, String b2cUserPassword){
        Assert.assertTrue(hiInfo.isDisplayed());
        Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb biznesowy, włącz tryb prywatny");
        chooseUserSwitch.click();
        waitForVisibilityOfElement(logUsersPanel);
        zalogujPoRazPierwszyButton.click();
        new LogInPage(driver).logAsB2CUser(b2cUserName,b2cUserPassword).verifyMap().openMenu().verifyMenuPage();
        return this;
    }

    @Step
    public MenuPage logB2BUserByMenuPanel (String b2bUserName, String b2bUserPassword){
        Assert.assertTrue(hiInfo.isDisplayed());
        Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb prywatny, włącz tryb biznesowy");
        chooseUserSwitch.click();
        waitForVisibilityOfElement(logUsersPanel);
        zalogujPoRazPierwszyButton.click();
        new LogInPage(driver).logAsB2BUser(b2bUserName,b2bUserPassword).verifyMap().openMenu().verifyMenuPage();
        return this;
    }

    @Step
    public MenuPage registerB2CUserByMenuPanel(){
        Assert.assertTrue(hiInfo.isDisplayed());
        Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb biznesowy, włącz tryb prywatny");
        chooseUserSwitch.click();
        waitForVisibilityOfElement(logUsersPanel);
        zalozKontoPrywatneButton.click();
        new RegisterPageB2C(driver).completeFieldsCorrectlyB2C().markFirstAgreementB2C();
        return this;
    }

    @Step
    public MenuPage doNotSwitchB2B (){
        Assert.assertTrue(hiInfo.isDisplayed());
        Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb biznesowy, włącz tryb prywatny");
        chooseUserSwitch.click();
        waitForVisibilityOfElement(logUsersPanel);
        wrocDoKontaBiznesowegoButton.click();
        Assert.assertTrue(hiInfo.isDisplayed());
        Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb biznesowy, włącz tryb prywatny");
        return this;
    }

    @Step
    public MenuPage doNotSwitchB2C (){
        Assert.assertTrue(hiInfo.isDisplayed());
        Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb prywatny, włącz tryb biznesowy");
        chooseUserSwitch.click();
        waitForVisibilityOfElement(logUsersPanel);
        wrocDoKontaPrywatnegoButton.click();
        Assert.assertTrue(hiInfo.isDisplayed());
        Assert.assertEquals(chooseUserSwitch.getAttribute("content-desc"),"Tryb prywatny, włącz tryb biznesowy");
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
    public MenuPage logInB2CAndOpenMenu(String userName, String password) {
        new SplashPage(driver).allowPermision().verifyMainScreen().goToLogInPage()
                .verifyLogInPageHeader()
                .logAsB2CUser(userName, password)
                .verifyMap()
                .openMenu()
                .verifyMenuPage();
        return this;
    }

    @Step
    public MenuPage logInB2BAndOpenMenu(String userName, String password) {
        new SplashPage(driver).allowPermision().verifyMainScreen().goToLogInPage()
                .verifyLogInPageHeader()
                .logAsB2BUser(userName, password)
                .verifyMap()
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

    @Step
    public SplashPage logOut(){
        List<WebElement> customButtoms = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/customButtonText"));
        for (WebElement logOutButton: customButtoms) {
            if (logOutButton.getAttribute("text").equals("WYLOGUJ SIĘ")) {logOutButton.click();}
        }
        logOutConfirmButton.click();
        new SplashPage(driver).verifyMainScreen();
        return new SplashPage(driver);
    }
}
