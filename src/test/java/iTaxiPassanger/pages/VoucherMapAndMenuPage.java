package iTaxiPassanger.pages;


import iTaxiPassanger.utilities.CaptureElementPicture;
import iTaxiPassanger.utilities.CompareScreens;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.TesseractException;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;


public class VoucherMapAndMenuPage extends BasePage {

    public VoucherMapAndMenuPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiMapPinUser")
    private WebElement voucherRideMap;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/customButtonText")
    private WebElement orderButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiMapAddress")
    private WebElement addressField;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiCategoryLux")
    private WebElement luxuryTaxiButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/confirmExtraCharge")
    private WebElement confirmationOfExtraCharge;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiMapDotsContainer")
    private WebElement goBackButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/confirmSelectTime")
    private WebElement selectTimeDisabled;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/confirmOrderMoreOptions")
    private WebElement moreOptionsButton;

    @FindBy(xpath = "//android.widget.LinearLayout[@index='2']")
    private WebElement selectTimeLayout;

    @FindBy(xpath = "//android.widget.LinearLayout[@index='3']")
    private WebElement voucherAndMoreOptionsLayout;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/targetLocation")
    private WebElement destinationAddressButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/confirmConfirm")
    private WebElement confirmOrderButton;

    public VoucherMapAndMenuPage makeBeReadyToOrderWithVoucher(String phoneNumber, String code) throws InterruptedException {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToVoucherPage().verifyVoucherPageHeader().putCorrectVoucherCode(phoneNumber, code);
        return new VoucherMapAndMenuPage(driver);
    }

    public VoucherMapAndMenuPage verifyVoucherMapPage() {
        waitForVisibilityOfElement(voucherRideMap);
        waitForVisibilityOfElement(goBackButton);
        Assert.assertTrue(voucherRideMap.isDisplayed());
        Assert.assertTrue(goBackButton.isDisplayed());
        return new VoucherMapAndMenuPage(driver);
    }

    public void verifyDetailsOfScreenElements() {
        orderButton.click();
        waitForVisibilityOfElement(driver.findElement(By.id("com.geckolab.eotaxi.passenger.demo:id/confirmScroll")));
        Assert.assertFalse(selectTimeDisabled.isEnabled());
    }

    public void compareScreens() throws IOException {
        String scrFile = "C://Users//user//Desktop//NPB//src//test//java//iTaxiPassanger//tests//screenshotsToCompareInTests//screenshot.png";

        String naTerazExpected = "C://Users//user//Desktop//NPB//src//test//java//iTaxiPassanger//tests//screenshotsToCompareInTests//NaTerazExpected.png";
        new CaptureElementPicture(driver).takeScreenshotOfElement(selectTimeLayout);
        Assert.assertEquals(CompareScreens.Result.Matched, CompareScreens.CompareImage(naTerazExpected, scrFile));

        String VoucherWiecejOpcjiExpected = "C://Users//user//Desktop//NPB//src//test//java//iTaxiPassanger//tests//screenshotsToCompareInTests//VoucherWiecejOpcjiExpected.png";
        new CaptureElementPicture(driver).takeScreenshotOfElement(voucherAndMoreOptionsLayout);
        Assert.assertEquals(CompareScreens.Result.Matched, CompareScreens.CompareImage(VoucherWiecejOpcjiExpected, scrFile));
    }

    public VoucherMapAndMenuPage setStartAddress(String address) throws InterruptedException {
        addressField.click();
        new SetStartAddressPage(driver).setStartAddress(address);
        new VoucherMapAndMenuPage(driver).orderButton.click();
        return new VoucherMapAndMenuPage(driver);
    }

    public VoucherMapAndMenuPage setDestinationAddress(String address) throws InterruptedException {
        destinationAddressButton.click();
        new SetDestinationAddressPage(driver).setDestinationAddressOnPage(address);
        return new VoucherMapAndMenuPage(driver);
    }

    public VoucherMapAndMenuPage setLuxuryTaxi() {
        waitForVisibilityOfElement(driver.findElement(By.id("com.geckolab.eotaxi.passenger.demo:id/selectData")));
        luxuryTaxiButton.click();
        Assert.assertTrue(confirmationOfExtraCharge.isDisplayed());
        Assert.assertEquals(confirmationOfExtraCharge.getText(), "Taksówka Luksusowa: dopłata 40,00 zł");
        return new VoucherMapAndMenuPage(driver);
    }

    public OrderingPage confirmOrder() {
        waitForVisibilityOfElement(confirmOrderButton);
        confirmOrderButton.click();
        new OrderingPage(driver).verifyOrderingPage();
        return new OrderingPage(driver);
    }

}