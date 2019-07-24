package iTaxiPassanger.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class PaymentPage extends BasePage {
    public PaymentPage(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragOrderPaymentHeader")
    private WebElement paymentPageHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/paymentList")
    private WebElement paymentList;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/creditCardTypeButton")
    private WebElement creditCardTypeButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackLabelRight")
    private WebElement editButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/dialogButtonRight")
    private WebElement confirmDeletePaymentButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackTitle")
    private WebElement editPaymentScreenHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackIconLeft")
    private WebElement backFromEditPaymentScreen;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/payMethTxtChargeWithDefault")
    private WebElement automaticPaymentCheckbox;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/headerBackIconLeft")
    private WebElement backFromPaymentsPageButton;

    @Step
    public PaymentPage verifyPaymentPage() {
        waitForVisibilityOfElement(paymentPageHeader);
        Assert.assertTrue(paymentPageHeader.isDisplayed());
        return this;
    }

    @Step
    public PaymentPage addNewPayment() {
        waitForVisibilityOfElement(paymentList);
        List<WebElement> allButtons = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowPaymText"));
        for (WebElement button : allButtons) {
            if (button.getAttribute("text").contains("Dodaj nową płatność")) {
                button.click();
            }
        }
        waitForVisibilityOfElement(creditCardTypeButton);
        creditCardTypeButton.click();
        return this;
    }

    @Step
    boolean verifyIsAddedCreditCardIsPresent(String finalCreditCardFourNumbers) {
        waitForVisibilityOfElement(paymentList);
        List<WebElement> addedPayments = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowPaymText"));

        for (WebElement addPayment : addedPayments)
            if (addPayment.getAttribute("text").contains(finalCreditCardFourNumbers)) {
                return true;
            }
        return false;
    }


    @Step
    boolean verifyIsAddedCreditCardIsMarkedAsDefault(String finalCreditCardFourNumbers) {
        waitForVisibilityOfElement(paymentList);
        List<WebElement> addedPayments = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowPaymText"));

        for (WebElement addPayment : addedPayments)
            if (addPayment.getAttribute("content-desc").contains(finalCreditCardFourNumbers + " " + "Wybrana")) {
                return true;
            }
        return false;
    }


    @Step
    public PaymentPage verifyAddedCreditCard(String finalCreditCardFourNumbers) {
        Assert.assertTrue(verifyIsAddedCreditCardIsPresent(finalCreditCardFourNumbers));
        return this;
    }

    @Step
    public PaymentPage verifyAddedCreditCardIsMarkedAsDefault(String finalCreditCardFourNumbers) {
        Assert.assertTrue(verifyIsAddedCreditCardIsMarkedAsDefault(finalCreditCardFourNumbers));
        return this;
    }


    @Step
    public PaymentPage deleteExistingPaymentMethod() throws InterruptedException {
        editButton.click();
        Thread.sleep(3000);
        waitForVisibilityOfElement(editPaymentScreenHeader);
        List<WebElement> listOfAddedPaymentsInEditionScreen = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowPaymText"));
        int sizeOfPaymentList = listOfAddedPaymentsInEditionScreen.size();
        System.out.println(sizeOfPaymentList);
        while (sizeOfPaymentList > 0) {
            Thread.sleep(3000);
            List<WebElement> deletePaymentButtons = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowPaymRightIcon"));
            for (WebElement deleteButton : deletePaymentButtons) {
                if (deleteButton.getAttribute("content-desc").equals("Usuń kartę")) {
                    deleteButton.click();
                }
            }
            confirmDeletePaymentButton.click();
            sizeOfPaymentList--;
        }
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        waitForVisibilityOfElement(paymentList);
        waitForVisibilityOfElement(paymentPageHeader);
        return this;
    }

    @Step
    public PaymentPage checkAutomationPaymentCheckbox() {
        if (automaticPaymentCheckbox.getAttribute("content-desc").equals("Potwierdzaj płatność automatycznie. Odznaczone")) {
            automaticPaymentCheckbox.click();
            Assert.assertTrue(automaticPaymentCheckbox.getAttribute("content-desc").equals("Potwierdzaj płatność automatycznie. Zaznaczone"));
        } else
            Assert.assertTrue((automaticPaymentCheckbox.getAttribute("content-desc").equals("Potwierdzaj płatność automatycznie. Zaznaczone")));
        return this;
    }

    @Step
    public PaymentPage uncheckAutomationPaymentCheckbox() {
        if (automaticPaymentCheckbox.getAttribute("content-desc").equals("Potwierdzaj płatność automatycznie. Zaznaczone")) {
            automaticPaymentCheckbox.click();
            Assert.assertTrue(automaticPaymentCheckbox.getAttribute("content-desc").equals("Potwierdzaj płatność automatycznie. Odznaczone"));
        } else
            Assert.assertTrue((automaticPaymentCheckbox.getAttribute("content-desc").equals("Potwierdzaj płatność automatycznie. Odznaczone")));
        return this;
    }

    @Step
    public PaymentPage markCashPaymentAsDefault() {
        waitForVisibilityOfElement(paymentList);
        List<WebElement> listOfPayments = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowPaymText"));
        for (WebElement payment : listOfPayments) {
            if (payment.getAttribute("text").equals("Gotówka")) {
                payment.click();
                Assert.assertEquals(payment.getAttribute("content-desc"), "Gotówka Wybrana");
            }
        }
        return this;
    }

    @Step
    public PaymentPage markCardInCabPaymentAsDefault() {
        waitForVisibilityOfElement(paymentList);
        List<WebElement> listOfPayments = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowPaymText"));
        for (WebElement payment : listOfPayments) {
            if (payment.getAttribute("text").equals("Karta u kierowcy")) {
                payment.click();
                Assert.assertEquals(payment.getAttribute("content-desc"), "Karta u kierowcy Wybrana");
            }
        }
        return this;
    }


    @Step
    public PaymentPage markBlikPaymentAsDefault() {
        waitForVisibilityOfElement(paymentList);
        List<WebElement> listOfPayments = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowPaymText"));
        for (WebElement payment : listOfPayments) {
            if (payment.getAttribute("text").equals("BLIK")) {
                payment.click();
                Assert.assertEquals(payment.getAttribute("content-desc"), "BLIK Wybrana");
            }
        }
        return this;
    }

    @Step
    public PaymentPage markGooglePayPaymentAsDefault() {
        waitForVisibilityOfElement(paymentList);
        List<WebElement> listOfPayments = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowPaymText"));
        for (WebElement payment : listOfPayments) {
            if (payment.getAttribute("text").equals("Google Pay")) {
                payment.click();
                Assert.assertEquals(payment.getAttribute("content-desc"), "Google Pay Wybrana");
            }
        }
        return this;
    }


    @Step
    public MapPage backFromPaymentPage() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        return new MapPage(driver).verifyMap();
    }


}