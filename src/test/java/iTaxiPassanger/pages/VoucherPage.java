package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class VoucherPage extends BasePage {

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragVoucherHeader")
    private WebElement voucherHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/confirmButton")
    private WebElement acceptButton;

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/headerBackIconLeft")
    private WebElement backButton;



    public VoucherPage(WebDriver driver) {
        super(driver);
    }

    public VoucherPage verifyVoucherPageHeader() throws InterruptedException {
        waitForVisibilityOfElement(voucherHeader);
        Assert.assertTrue(voucherHeader.isDisplayed());
        return this;
    }

    public SplashPage backToSplashPage(){
        backButton.click();
        return new SplashPage(driver).verifyMainScreen();
    }

    public VoucherPage putIncorrectData (String phoneNumber, String code) throws InterruptedException {
        List<WebElement> logInFields = driver.findElements(By.className("android.widget.EditText"));
        logInFields.get(0).sendKeys(phoneNumber);
        logInFields.get(1).sendKeys(code);
        acceptButton.click();
        Thread.sleep(2000);
        return new VoucherPage(driver);
    }

    public void verifyToastMessage() throws TesseractException, IOException {
        String toastMessage = new VoucherPage(driver).readToastMessage();
        Assert.assertTrue((toastMessage).contains("Prosze uzupetni¢ wszystkie pola"));
    }

}
