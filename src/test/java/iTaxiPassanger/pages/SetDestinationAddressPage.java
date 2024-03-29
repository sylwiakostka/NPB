package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SetDestinationAddressPage extends BasePage {
    public SetDestinationAddressPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy (id = "com.geckolab.eotaxi.passenger.demo:id/searchAddressPhrase")
    private WebElement destinationAddressField;

    @Step
    public VoucherMapAndMenuPage setDestinationAddressOnPage(String address) throws InterruptedException {
        waitForVisibilityOfElement(destinationAddressField);
        destinationAddressField.sendKeys(address);
        waitForVisibilityOfElement(driver.findElement(By.id("com.geckolab.eotaxi.passenger.demo:id/lastAddressesList")));
        Thread.sleep(3000);
        List<WebElement> addressesList = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowAddressName"));
        addressesList.get(0).click();
        return new VoucherMapAndMenuPage(driver);
    }


}

