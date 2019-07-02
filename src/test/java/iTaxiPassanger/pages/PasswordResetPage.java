package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PasswordResetPage extends BasePage {
    public PasswordResetPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragResetPasswordBackHeader")
    private WebElement passwordResetPageHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragResetPassBtn")
    private WebElement resetPasswordButton;


    @Step
    public PasswordResetPage verifyPasswordResetPage() {
        waitForVisibilityOfElement(passwordResetPageHeader);
        Assert.assertTrue(passwordResetPageHeader.isDisplayed());
        return this;
    }

    @Step
    public LogInPage resetPassword() throws TesseractException, InterruptedException {
        resetPasswordButton.click();
        Thread.sleep(2000);
        String toastMessage = readToastMessage();
        Assert.assertTrue(toastMessage.contains("OK, sprawdz e-mail"));
        return new LogInPage(driver);
    }
}
