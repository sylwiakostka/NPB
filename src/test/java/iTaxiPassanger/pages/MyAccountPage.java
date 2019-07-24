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

public class MyAccountPage extends BasePage {
    public MyAccountPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragUserDataBackHeader")
    private WebElement myAccountPageHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragUserDataName")
    private WebElement userName;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragUserDataEmail")
    private WebElement userEmail;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragUserDataPhone")
    private WebElement userPhone;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragUserDataAddressHome")
    private WebElement homeAddressButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragUserDataAddressWork")
    private WebElement workAddressButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragUseDataSilentSwitch")
    private WebElement silentSwitch;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackIconLeft")
    private WebElement backButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragChangeNameBackHeader")
    private WebElement changeNameAndSurnameHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/editWithIconEdit")
    private WebElement changeNameAndSurnameField;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragChangeUsernameSave")
    private WebElement saveChangesNameAndSurnameButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragChangePhoneBackHeader")
    private WebElement changePhoneNumberHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/editWithIconEdit")
    private WebElement changePhoneNumberField;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragChangeUsernameSave")
    private WebElement saveChangesPhoneNumberButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragVerifyBackHeader")
    private WebElement verifyPhoneNumberHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackIconLeft")
    private WebElement verifyPhoneNumberBackButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackIconRight")
    private WebElement changePhoneNumberBackButton;


    @Step
    public MyAccountPage verifyMyAccountPage() {
        waitForVisibilityOfElement(myAccountPageHeader);
        Assert.assertTrue(myAccountPageHeader.isDisplayed());
        return this;
    }

    @Step
    public MyAccountPage verifyUserDataB2C() {
        String nameAndSurname = "Marek Wąs";
        String email = "wasmarc12@gmail.com";
        String phoneNumber = "+48574777590";
        Assert.assertEquals(nameAndSurname, userName.getAttribute("content-desc"));
        Assert.assertEquals(email, userEmail.getAttribute("content-desc"));
        Assert.assertEquals(phoneNumber, userPhone.getAttribute("content-desc"));
        return this;
    }

    @Step
    public MyAccountPage verifyUserDataB2B(){
        String nameAndSurname = "Ola Tola";
        String email = "ola.tola@gmail.com";
        String phoneNumber = "+48111111111";
        Assert.assertEquals(nameAndSurname, userName.getAttribute("content-desc"));
        Assert.assertEquals(email, userEmail.getAttribute("content-desc"));
        Assert.assertEquals(phoneNumber, userPhone.getAttribute("content-desc"));
        return this;
    }

    @Step
    public MyAccountPage verifyIfCanNotChangeDataUserB2B(){
        userName.click();
        Assert.assertTrue(myAccountPageHeader.isDisplayed());
        userEmail.click();
        Assert.assertTrue(myAccountPageHeader.isDisplayed());
        userPhone.click();
        Assert.assertTrue(myAccountPageHeader.isDisplayed());
        return this;
    }


    @Step
    public MyAccountPage addHomeAddress(String address) throws InterruptedException {
        homeAddressButton.click();
        new SetHomeAddressPage(driver).verifySetHomeAddressPage().setHomeAddress(address);
        waitForVisibilityOfElement(myAccountPageHeader);
        List<WebElement> listElementValue = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/listElementValue"));
        String setAddress = listElementValue.get(3).getText();
        Assert.assertTrue(setAddress.contains(address));
        return this;
    }

    @Step
    public MyAccountPage addWorkAddress(String address) throws InterruptedException {
        workAddressButton.click();
        new SetWorkAddressPage(driver).verifySetWorkAddressPage().setWorkAddress(address);
        waitForVisibilityOfElement(myAccountPageHeader);
        List<WebElement> listElementValue = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/listElementValue"));
        String setAddress = listElementValue.get(4).getText();
        Assert.assertTrue(setAddress.contains(address));
        return this;
    }

    @Step
    public MyAccountPage switchSilent() {
        String silentText = silentSwitch.getAttribute("text");
        System.out.println(silentText);
        if (silentText.equals("WYŁ.")) {
            silentSwitch.click();
            Assert.assertEquals(silentSwitch.getAttribute("content-desc"), "Cichy przejazd włączony");
        } else if (silentText.equals("WŁ.")) {
            silentSwitch.click();
            Assert.assertEquals(silentSwitch.getAttribute("content-desc"), "Cichy przejazd wyłączony");
        }
        return this;
    }

    @Step
    public MyAccountPage changeNameAndSurnameB2C(String newNameAndSurname) {
        userName.click();
        waitForVisibilityOfElement(changeNameAndSurnameHeader);
        Assert.assertTrue(changeNameAndSurnameHeader.isDisplayed());
        changeNameAndSurnameField.clear();
        changeNameAndSurnameField.sendKeys(newNameAndSurname);
        saveChangesNameAndSurnameButton.click();
        waitForVisibilityOfElement(myAccountPageHeader);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        new MapPage(driver).verifyMap().openMenu().openMyAccountPage().verifyMyAccountPage();
        Assert.assertEquals(newNameAndSurname, userName.getAttribute("content-desc"));
        return this;
    }

    @Step
    public MyAccountPage tryToChangePhoneNumberB2C() throws InterruptedException {
        userPhone.click();
        waitForVisibilityOfElement(changePhoneNumberHeader);
        Assert.assertTrue(changePhoneNumberHeader.isDisplayed());
        changePhoneNumberField.clear();
        changePhoneNumberField.sendKeys("574777590");
        saveChangesPhoneNumberButton.click();
        new VerifyUserBySMSCodePage(driver).readAndPutSMSIfNeedToVerify();
        waitForVisibilityOfElement(changePhoneNumberHeader);
        Assert.assertEquals(changePhoneNumberField.getAttribute("text"), "+48574777590");
        return this;
    }

    @Step
    public MyAccountPage tryToChangeEmailB2C() {
        userEmail.click();
        Assert.assertTrue(myAccountPageHeader.isDisplayed());
        return this;
    }

    @Step
    public void logOut(){
        waitForVisibilityOfElement(myAccountPageHeader);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        new MapPage(driver).verifyMap().openMenu().logOut();
    }


}



