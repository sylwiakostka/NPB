package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrderingPage extends BasePage {

    public OrderingPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/progress")
    private WebElement progressBar;

    @Step
    public OrderingPage verifyOrderingPage() {
        waitForVisibilityOfElement(progressBar);
        Assert.assertTrue(progressBar.isDisplayed());
        return new OrderingPage(driver);
    }
}
