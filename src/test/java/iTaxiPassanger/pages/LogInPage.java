package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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


    @Step
    public LogInPage verifyLogInPageHeader() {
        waitForVisibilityOfElement(logInPageHeader);
        Assert.assertEquals(logInPageHeader.getText(), "Logowanie");
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

}

