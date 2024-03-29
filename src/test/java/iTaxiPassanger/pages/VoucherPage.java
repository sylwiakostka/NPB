package iTaxiPassanger.pages;


import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;

public class VoucherPage extends BasePage {
    public VoucherPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragVoucherHeader")
    private WebElement voucherHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/confirmButton")
    private WebElement acceptButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackIconLeft")
    private WebElement backButton;


    @Step
    public VoucherPage verifyVoucherPageHeader() {
        waitForVisibilityOfElement(voucherHeader);
        Assert.assertTrue(voucherHeader.isDisplayed());
        return this;
    }

    @Step
    public SplashPage backToSplashPage() {
        backButton.click();
        return new SplashPage(driver).verifyMainScreen();
    }

    @Step
    public VoucherPage putIncorrectData(String phoneNumber, String code) throws InterruptedException {
        List<WebElement> logInFields = driver.findElements(By.className("android.widget.EditText"));
        logInFields.get(0).sendKeys(phoneNumber);
        logInFields.get(1).sendKeys(code);
        acceptButton.click();
        Thread.sleep(2000);
        return new VoucherPage(driver);
    }

    @Step
    public void verifyToastMessage() throws TesseractException, IOException {
        String toastMessage = new VoucherPage(driver).readToastMessage();
        Assert.assertTrue((toastMessage).contains("Prosze uzupetni¢ wszystkie pola"));
    }

    @Step
    public void verifyToastMessageDataProvider(String toastText) throws TesseractException, IOException {
        String toastMessage = new VoucherPage(driver).readToastMessage();
        Assert.assertTrue((toastMessage).contains(toastText));
    }

    @Step
    public VoucherPage putIncorrectVoucherCode(String phoneNumber, String code, String toastText) throws TesseractException, IOException, InterruptedException {
        List<WebElement> logInFields = driver.findElements(By.className("android.widget.EditText"));
        logInFields.get(0).sendKeys(phoneNumber);
        logInFields.get(1).sendKeys(code);
        acceptButton.click();
        new VerifyUserBySMSCodePage(driver).readAndPutSMSToVerifyVoucher();
        Thread.sleep(2000);
        verifyToastMessageDataProvider(toastText);
        return new VoucherPage(driver).verifyVoucherPageHeader();
    }

    @Step
    public VoucherMapAndMenuPage putCorrectVoucherCode(String phoneNumber, String code) throws InterruptedException {
        List<WebElement> logInFields = driver.findElements(By.className("android.widget.EditText"));
        logInFields.get(0).sendKeys(phoneNumber);
        logInFields.get(1).sendKeys(code);
        acceptButton.click();
        new VerifyUserBySMSCodePage(driver).readAndPutSMSToVerifyVoucher();
        return new VoucherMapAndMenuPage(driver).verifyVoucherMapPage();
    }

}
