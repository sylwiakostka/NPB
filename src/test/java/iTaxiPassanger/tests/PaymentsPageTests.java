package iTaxiPassanger.tests;

import iTaxiPassanger.pages.BraintreeScreenToAddCardPage;
import iTaxiPassanger.pages.MenuPage;
import iTaxiPassanger.pages.PaymentPage;
import iTaxiPassanger.pages.SplashPage;
import iTaxiPassanger.utilities.CreditCardDataProvider;
import org.testng.annotations.Test;

public class PaymentsPageTests extends BaseTests {

    @Test
    public void shouldDeletePayments() throws InterruptedException {
        new MenuPage(driver).logInB2CAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openPaymentPage()
                .deleteExistingPaymentMethod()
                .backFromPaymentPage();
    }

    @Test(dataProvider = "CorrectCreditCard", dataProviderClass = CreditCardDataProvider.class)
    public void shouldAddCreditCard(String creditCardNumber, String expiredDate, String CVV) throws InterruptedException {
        new MenuPage(driver)
                .logInB2CAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openPaymentPage()
                .addNewPayment();
        new BraintreeScreenToAddCardPage(driver).putCardNumberAndSave(creditCardNumber, expiredDate, CVV);
        new PaymentPage(driver)
                .verifyPaymentPage()
                .verifyAddedCreditCard("0005")
                .verifyAddedCreditCardIsMarkedAsDefault("0005")
                .backFromPaymentPage();
    }

    @Test
    public void shouldVerifyAutomationPaymentCheckbox() throws InterruptedException {
        new MenuPage(driver)
                .logInB2CAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openPaymentPage()
                .uncheckAutomationPaymentCheckbox()
                .checkAutomationPaymentCheckbox()
                .backFromPaymentPage();
    }

    @Test
    public void shouldMarkCashAsDefault() {
        new MenuPage(driver)
                .logInB2CAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openPaymentPage()
                .markCashPaymentAsDefault()
                .backFromPaymentPage();
    }

    @Test
    public void shouldMarkCardInCabAsDefault() {
        new MenuPage(driver)
                .logInB2CAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openPaymentPage()
                .markCardInCabPaymentAsDefault()
                .backFromPaymentPage();
    }

    @Test
    public void shouldMarkBlikAsDefault() {
        new MenuPage(driver)
                .logInB2CAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openPaymentPage()
                .markBlikPaymentAsDefault()
                .backFromPaymentPage();
    }

    @Test
    public void shouldMarkGooglePayAsDefault() {
        new MenuPage(driver)
                .logInB2CAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openPaymentPage()
                .markGooglePayPaymentAsDefault()
                .backFromPaymentPage();
    }
}

