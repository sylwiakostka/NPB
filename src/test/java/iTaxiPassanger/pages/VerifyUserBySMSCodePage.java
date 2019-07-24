package iTaxiPassanger.pages;

import iTaxiPassanger.utilities.ChooseCorrectDigitOnKeyboard;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;


public class VerifyUserBySMSCodePage extends BasePage {
    public VerifyUserBySMSCodePage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/pin_layout")
    private WebElement pinLayout;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"ITAXI.PL\")")
    private WebElement itaxiSMS;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/confirmButtonPhoneNumber")
    private WebElement confirmCodeButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/cardFormViewSkip")
    private WebElement cardFormViewSkipButton;


    public VerifyUserBySMSCodePage verifyVerifyUserBySMSCodePage() {
        waitForVisibilityOfElement(pinLayout);
        Assert.assertTrue(pinLayout.isDisplayed());
        return this;
    }

    public void readAndPutSMSIfNeedToVerify() throws InterruptedException {
        verifyVerifyUserBySMSCodePage();
        driver.openNotifications();
        Thread.sleep(10000);
        waitForVisibilityOfElement(itaxiSMS);
        Assert.assertTrue(itaxiSMS.isDisplayed());
        try {
            List<WebElement> notifList = driver.findElements(By.id("android:id/text"));
            for (WebElement notifElem : notifList)
                if (notifElem.getAttribute("text").contains("Twoj kod aktywacyjny to")) {
                    String splitedFirstPart = notifElem.getAttribute("text").split("to")[1].trim();
                    String splittedSecondPart = splitedFirstPart.split(". K")[0];
                    driver.pressKey(new KeyEvent(AndroidKey.BACK));
                    String digit1 = splittedSecondPart.substring(0, 1);
                    String digit2 = splittedSecondPart.substring(1, 2);
                    String digit3 = splittedSecondPart.substring(2, 3);
                    String digit4 = splittedSecondPart.substring(3, 4);
                    ChooseCorrectDigitOnKeyboard.chooseCorrectDigit(digit1);
                    ChooseCorrectDigitOnKeyboard.chooseCorrectDigit(digit2);
                    ChooseCorrectDigitOnKeyboard.chooseCorrectDigit(digit3);
                    ChooseCorrectDigitOnKeyboard.chooseCorrectDigit(digit4);
                    confirmCodeButton.click();
                    driver.hideKeyboard();
                    waitForVisibilityOfElement(cardFormViewSkipButton);
                    Assert.assertTrue(cardFormViewSkipButton.isDisplayed());
                    cardFormViewSkipButton.click();
                    new MapPage(driver).verifyMap();
                }
        } catch (StaleElementReferenceException e) {
        }
    }


    public void readAndPutSMSToVerifyVoucher() throws InterruptedException {
        verifyVerifyUserBySMSCodePage();
        driver.openNotifications();
        Thread.sleep(10000);
        waitForVisibilityOfElement(itaxiSMS);
        Assert.assertTrue(itaxiSMS.isDisplayed());
        try {
            List<WebElement> notifList = driver.findElements(By.id("android:id/text"));
            for (WebElement notifElem : notifList)
                if (notifElem.getAttribute("text").contains("Twoj kod aktywacyjny to")) {
                    String splitedFirstPart = notifElem.getAttribute("text").split("to")[1].trim();
                    String splittedSecondPart = splitedFirstPart.split(". K")[0];
                    driver.pressKey(new KeyEvent(AndroidKey.BACK));
                    String digit1 = splittedSecondPart.substring(0, 1);
                    String digit2 = splittedSecondPart.substring(1, 2);
                    String digit3 = splittedSecondPart.substring(2, 3);
                    String digit4 = splittedSecondPart.substring(3, 4);
                    ChooseCorrectDigitOnKeyboard.chooseCorrectDigit(digit1);
                    ChooseCorrectDigitOnKeyboard.chooseCorrectDigit(digit2);
                    ChooseCorrectDigitOnKeyboard.chooseCorrectDigit(digit3);
                    ChooseCorrectDigitOnKeyboard.chooseCorrectDigit(digit4);
                    confirmCodeButton.click();
                }
        } catch (StaleElementReferenceException e) {
        }
    }
}










