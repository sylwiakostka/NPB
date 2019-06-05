package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.SeleniumHelper;


public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@id='normal-popover']//button[@id='onesignal-popover-allow-button']")
    private WebElement iframeButton;

    @Step
    public HomePage verifyURL() {
        Assert.assertEquals("https://phptravels.com/demo/", driver.getCurrentUrl());
        return this;
    }

    @Step
    public HomePage denyNotifications() {
        SeleniumHelper.waitForVisibilityOfElement(iframeButton);
        iframeButton.click();
        return this;
    }
}