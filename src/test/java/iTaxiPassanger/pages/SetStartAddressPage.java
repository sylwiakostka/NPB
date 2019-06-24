package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SetStartAddressPage extends BasePage {
    public SetStartAddressPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/searchAddressPhrase")
    private WebElement searchAddressField;

    public VoucherMapAndMenuPage setStartAddress(String address) throws InterruptedException {
        waitForVisibilityOfElement(searchAddressField);
        searchAddressField.sendKeys(address);
        waitForVisibilityOfElement(driver.findElement(By.id("com.geckolab.eotaxi.passenger.demo:id/rowAddressName")));
        Thread.sleep(3000);
        List<WebElement> addressesList = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowAddressName"));
        addressesList.get(1).click();
        return new VoucherMapAndMenuPage(driver);
    }


}

