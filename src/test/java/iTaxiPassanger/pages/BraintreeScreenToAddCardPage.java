package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class BraintreeScreenToAddCardPage extends BasePage {
    public BraintreeScreenToAddCardPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "bt_card_form_card_number")
    private WebElement cardNumberField;

    @FindBy(id = "bt_card_form_cvv")
    private WebElement ccvField;

    @FindBy(id = "bt_card_form_expiration")
    private WebElement expirationDateField;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/creditCardFormConfirmView")
    private WebElement addCreditCardButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/dialogButtonRight")
    private WebElement confirmButton;


    public void putCardNumberAndSave(String creditCardNumber, String expiredDate, String CVV) throws InterruptedException {
        waitForVisibilityOfElement(cardNumberField);
        cardNumberField.sendKeys(creditCardNumber);
        expirationDateField.sendKeys(expiredDate);
        ccvField.sendKeys(CVV);
        Thread.sleep(2000);
        addCreditCardButton.click();
        waitForVisibilityOfElement(confirmButton);
        confirmButton.click();

    }


}
