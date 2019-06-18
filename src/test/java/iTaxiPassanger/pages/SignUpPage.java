package iTaxiPassanger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUpPage extends BasePage {
    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragRegisterBackHeader")
    private WebElement signUpPageHeader;


    public SignUpPage verifySignUpPageHeader() {
        waitForVisibilityOfElement(signUpPageHeader);
        Assert.assertTrue(signUpPageHeader.isDisplayed());
        return new SignUpPage(driver);
    }


}