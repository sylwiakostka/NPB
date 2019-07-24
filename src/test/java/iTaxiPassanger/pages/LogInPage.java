package iTaxiPassanger.pages;

import iTaxiPassanger.utilities.CaptureElementPicture;
import iTaxiPassanger.utilities.CompareScreens;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;


public class LogInPage extends BasePage {
    public LogInPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackTitle")
    private WebElement logInPageHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragLoginChooseType")
    private WebElement profileSwitch;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/customButtonText")
    private WebElement logInButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackIconLeft")
    private WebElement backButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragLoginPassForget")
    private WebElement forgetDateButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragChooseUserServerToggleBtn")
    private WebElement demoAndStageSwicher;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/accountIcon")
    private WebElement accountIcon;

    @Step
    public LogInPage verifyLogInPageHeader() {
        waitForVisibilityOfElement(logInPageHeader);
        Assert.assertEquals(logInPageHeader.getText(), "Logowanie");
        if (demoAndStageSwicher.getAttribute("checked").equals("true")) {
            demoAndStageSwicher.click();
            Assert.assertTrue(demoAndStageSwicher.getAttribute("checked").equals("false"));
        }
        return this;
    }

    @Step
    public SplashPage backToSplashPage() {
        backButton.click();
        return new SplashPage(driver);
    }

    @Step
    public MapPage logAsB2CUser(String userName, String password) {
        List<WebElement> logInFields = driver.findElements(By.className("android.widget.EditText"));
        logInFields.get(0).clear();
        logInFields.get(1).clear();
        if (profileSwitch.getText().equals("WYŁ.")) {
            logInFields.get(0).sendKeys(userName);
            logInFields.get(1).sendKeys(password);
            logInButton.click();
        } else {
            profileSwitch.click();
            logInFields.get(0).sendKeys(userName);
            logInFields.get(1).sendKeys(password);
            logInButton.click();
        }
        return new MapPage(driver);
    }

    @Step
    public MapPage logAsB2BUser(String username, String password) {
        List<WebElement> logInFields = driver.findElements(By.className("android.widget.EditText"));
        logInFields.get(0).clear();
        logInFields.get(1).clear();
        if (profileSwitch.getText().equals("WŁ.")) {
            logInFields.get(0).sendKeys(username);
            logInFields.get(1).sendKeys(password);
            logInButton.click();
        } else {
            profileSwitch.click();
            logInFields.get(0).sendKeys(username);
            logInFields.get(1).sendKeys(password);
            logInButton.click();
        }
        return new MapPage(driver);
    }

    @Step
    public LogInPage cantLogInB2B(String username, String password) {
        List<WebElement> logInFields = driver.findElements(By.className("android.widget.EditText"));
        logInFields.get(0).clear();
        logInFields.get(1).clear();
        if (profileSwitch.getText().equals("WŁ.")) {
            logInFields.get(0).sendKeys(username);
            logInFields.get(1).sendKeys(password);
            logInButton.click();
        } else {
            profileSwitch.click();
            logInFields.get(0).sendKeys(username);
            logInFields.get(1).sendKeys(password);
            logInButton.click();
        }
        return this;
    }

    @Step
    public LogInPage cantLogInB2C(String username, String password) {
        List<WebElement> logInFields = driver.findElements(By.className("android.widget.EditText"));
        logInFields.get(0).clear();
        logInFields.get(1).clear();
        if (profileSwitch.getText().equals("WYŁ.")) {
            logInFields.get(0).sendKeys(username);
            logInFields.get(1).sendKeys(password);
            logInButton.click();
        } else {
            profileSwitch.click();
            logInFields.get(0).sendKeys(username);
            logInFields.get(1).sendKeys(password);
            logInButton.click();
        }
        return this;
    }

    @Step
    public PasswordResetPage goToPasswordResetPage() {
        forgetDateButton.click();
        new PasswordResetPage(driver).verifyPasswordResetPage();
        return new PasswordResetPage(driver);
    }

    @Step
    public LogInPage setB2CUserBySwitcher() throws IOException {
        if (profileSwitch.getAttribute("content-desc").equals("Tryb biznesowy, włącz tryb prywatny")) {
            profileSwitch.click();
        }
        return this;
    }

    @Step
    public LogInPage setB2BUserBySwitcher() throws IOException {
        if (profileSwitch.getAttribute("content-desc").equals("Tryb prywatny, włącz tryb biznesowy")) {
            profileSwitch.click();
        }
        new CaptureElementPicture(driver).takeScreenshotOfElement(accountIcon);
        return this;
    }

    @Step
    public void compareAccountIconB2C () throws IOException, InterruptedException {
        Thread.sleep(3000);
        String scrFile = "C://Users//user//Desktop//NPB//src//test//java//iTaxiPassanger//tests//screenshotsToCompareInTests//screenshot.png";
        String splashPage = "C://Users//user//Desktop//NPB//src//test//java//iTaxiPassanger//tests//screenshotsToCompareInTests//B2Cicon.png";
        new CaptureElementPicture(driver).takeScreenshotOfElement(accountIcon);
        Assert.assertEquals(CompareScreens.Result.SizeMismatch, CompareScreens.CompareImage(splashPage, scrFile));
    }

    @Step
    public void compareAccountIconB2B () throws IOException, InterruptedException {
        Thread.sleep(3000);
        String scrFile = "C://Users//user//Desktop//NPB//src//test//java//iTaxiPassanger//tests//screenshotsToCompareInTests//screenshot.png";
        String splashPage = "C://Users//user//Desktop//NPB//src//test//java//iTaxiPassanger//tests//screenshotsToCompareInTests//B2Bicon.png";
        new CaptureElementPicture(driver).takeScreenshotOfElement(accountIcon);
        Assert.assertEquals(CompareScreens.Result.SizeMismatch, CompareScreens.CompareImage(splashPage, scrFile));
    }


}

