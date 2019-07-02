package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUpPage extends BasePage {
    public SignUpPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragRegisterBackHeader")
    private WebElement signUpPageHeader;

    @Step
    public SignUpPage verifySignUpPageHeader() {
        waitForVisibilityOfElement(signUpPageHeader);
        Assert.assertTrue(signUpPageHeader.isDisplayed());
        return new SignUpPage(driver);
    }


}