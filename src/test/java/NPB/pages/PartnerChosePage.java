package NPB.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PartnerChosePage extends BasePage {

    public PartnerChosePage(WebDriver driver) {
        super(driver);
    }

    Actions action = new Actions(driver);

    @FindBy(id = "partnerAutocomplete")
    private WebElement partnerNameField;

    @FindBy(id = "submitButton")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='alert alert-warning']")
    private WebElement warnAlert;

    @FindBy(id = "ui-id-1")
    private WebElement companyList;

    @Step
    public void verifyPartnerChosePageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://taxi.demo.eo.pl/taxi-business-client-web/index.html");
    }

    @Step
    public PartnerChosePage cantGoIn(String incorrectCompanyName) {
        partnerNameField.sendKeys(incorrectCompanyName);
        submitButton.click();
        Assert.assertTrue(warnAlert.isDisplayed());
        Assert.assertEquals(warnAlert.getText(), "Uwaga! Wybierz poprawną wartość");
        return this;
    }

    @Step
    public CentralBPPage canGoIn(String correctCompanyName) {
        partnerNameField.sendKeys(correctCompanyName);
        companyList.click();
        submitButton.click();
        new CentralBPPage(driver).verifyCentralPageURL();
        return new CentralBPPage(driver);
    }
}
