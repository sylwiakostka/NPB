package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
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

    @Step
    public VoucherMapAndMenuPage setStartAddress(String address) throws InterruptedException {
        waitForVisibilityOfElement(searchAddressField);
        searchAddressField.sendKeys(address);
        waitForVisibilityOfElement(driver.findElement(By.id("com.geckolab.eotaxi.passenger.demo:id/rowAddressName")));
        Thread.sleep(3000);
        List<WebElement> addressesList = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowAddressName"));
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+address+"\").instance(0))").click();
        return new VoucherMapAndMenuPage(driver);
    }


}

