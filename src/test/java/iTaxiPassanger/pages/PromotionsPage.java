package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PromotionsPage extends BasePage {
    public PromotionsPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackTitle")
    private WebElement promotionsPageHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/editWithIconEdit")
    private WebElement putPromotionCodeField;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/customButtonText")
    private WebElement savePromotionCodeButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/editWithIconErrorText")
    private WebElement infoAboutWrongText;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/codeViewerCurrent")
    private WebElement infoAboutAddedCodeNumber;

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/headerBackIconLeft")
    private WebElement backFromPromotionsPageButton;

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/fragPromotionCodeViewerView")
    private WebElement fragPromotionCodeViewerView;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/promoCodeChangeContainer")
    private WebElement changeCodeButton;

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/dialogButtonRight")
    private WebElement acceptChangeButton;

    @Step
    public PromotionsPage verifyPromotionPageHeader() {
        waitForVisibilityOfElement(promotionsPageHeader);
        Assert.assertEquals(promotionsPageHeader.getText(), "Promocje");
        return this;
    }

    @Step
    public PromotionsPage putPromotionCodeCorrectly(String correctPromotionCodeNumber) {
        putPromotionCodeField.sendKeys(correctPromotionCodeNumber);
        savePromotionCodeButton.click();
        waitForVisibilityOfElement(fragPromotionCodeViewerView);
        Assert.assertEquals(infoAboutAddedCodeNumber.getText(), correctPromotionCodeNumber);
        return this;
    }

    @Step
    public PromotionsPage changeCode(String newPromotionCode){
        driver.hideKeyboard();
        changeCodeButton.click();
        acceptChangeButton.click();
        putPromotionCodeField.sendKeys(newPromotionCode);
        savePromotionCodeButton.click();
        waitForVisibilityOfElement(fragPromotionCodeViewerView);
        Assert.assertEquals(infoAboutAddedCodeNumber.getText(), newPromotionCode);
        return this;
    }


    @Step
    public PromotionsPage doNotPutCode() {
        putPromotionCodeField.sendKeys("");
        savePromotionCodeButton.click();
        Assert.assertEquals(infoAboutWrongText.getText(), "Pole jest wymagane");
        verifyPromotionPageHeader();
        return this;
    }

    @Step
    public PromotionsPage putWrongPromotionCode(String wrongPromotionCodeNumber) {
        putPromotionCodeField.sendKeys(wrongPromotionCodeNumber);
        savePromotionCodeButton.click();
        waitForVisibilityOfElement(infoAboutWrongText);
        Assert.assertEquals(infoAboutWrongText.getText(), "Niestety, ten kod nie zadziała");
        verifyPromotionPageHeader();
        return this;
    }

    @Step
    public MapPage backFromPromotionPage (){
        driver.hideKeyboard();
        waitForVisibilityOfElement(backFromPromotionsPageButton);
        Assert.assertTrue(backFromPromotionsPageButton.isDisplayed());
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        return new MapPage(driver).verifyMap();
    }
}

