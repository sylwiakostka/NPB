package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SetWorkAddressPage extends BasePage {
    public SetWorkAddressPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackTitle")
    private WebElement setWorkAddressPageHeader;

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/fragAddAddressName")
    private WebElement pinName;

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/afragAdAddressSearchPhrase")
    private WebElement addressSearchField;

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/fragAddAddressButton")
    private WebElement addAddressButton;
    

    @Step
    public SetWorkAddressPage verifySetWorkAddressPage() {
        waitForVisibilityOfElement(setWorkAddressPageHeader);
        Assert.assertTrue(setWorkAddressPageHeader.isDisplayed());
        Assert.assertEquals("Adres pracy", setWorkAddressPageHeader.getText());
        Assert.assertEquals("PRACA", pinName.getText());
        return this;
    }

    @Step
    public MyAccountPage setWorkAddress (String address) throws InterruptedException {
        addressSearchField.clear();
        addressSearchField.sendKeys(address);
        Thread.sleep(2000);
        List<WebElement> listOfAddresses = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowAddressName"));
        listOfAddresses.get(0).click();
        addAddressButton.click();
        return new MyAccountPage(driver);

    }

}
