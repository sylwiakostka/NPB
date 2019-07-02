package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SetHomeAddressPage extends BasePage {
    public SetHomeAddressPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackTitle")
    private WebElement setHomeAddressPageHeader;

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/fragAddAddressName")
    private WebElement pinName;

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/afragAdAddressSearchPhrase")
    private WebElement addressSearchField;

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/fragAddAddressButton")
    private WebElement addAddressButton;
    

    @Step
    public SetHomeAddressPage verifySetHomeAddressPage() {
        waitForVisibilityOfElement(setHomeAddressPageHeader);
        Assert.assertTrue(setHomeAddressPageHeader.isDisplayed());
        Assert.assertEquals("Adres domu", setHomeAddressPageHeader.getText());
        Assert.assertEquals("DOM", pinName.getText());
        return this;
    }

    @Step
    public MyAccountPage setHomeAddress (String address) throws InterruptedException {
        addressSearchField.clear();
        addressSearchField.sendKeys(address);
        Thread.sleep(2000);
        List<WebElement> listOfAddresses = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowAddressName"));
        listOfAddresses.get(0).click();
        addAddressButton.click();
        return new MyAccountPage(driver);


    }

}
