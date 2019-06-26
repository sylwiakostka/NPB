package iTaxiPassanger.tests;

import iTaxiPassanger.pages.RegisterPageB2B;
import iTaxiPassanger.pages.RegisterPageB2C;
import iTaxiPassanger.tests.BaseTests;
import iTaxiPassanger.utilities.RegisterWrongDataProvider;
import net.sourceforge.tess4j.TesseractException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegisterTestsB2B extends BaseTests {

    @Test
    public void shouldRegisterCorrectlyB2BAllAgreements() {
        new RegisterPageB2B(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2B()
                .markAllAgreementsAndAcceptB2B()
                .verifyConfirmationPopup();
    }

    @Test
    public void shouldNotRegisterB2CWithoutData() {
        new RegisterPageB2B(driver)
                .openRegisterPage()
                .doNotSetDataB2B()
                .verifyRegisterPage();
    }

    @Test(dataProvider = "incorrectDataRegisterB2B", dataProviderClass = RegisterWrongDataProvider.class)
    public void shouldNotRegisterB2BWrongData(String nameAndSurname, String errorText0, String nip, String errorText1, String email, String errorText2,
                                              String phoneNumber, String errorText3, String password, String errorText4) throws InterruptedException {
        new RegisterPageB2B(driver)
                .openRegisterPage()
                .setWrongDataB2B(nameAndSurname, errorText0, nip, errorText1, email, errorText2, phoneNumber, errorText3, password, errorText4)
                .verifyRegisterPage();
    }

    @Test
    public void shouldRegisterCorrectlyB2BFirstAgreement() {
        new RegisterPageB2B(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2B()
                .markFirstAgreementB2B();
    }

    @Test
    public void shouldNotRegisterCorrectlyB2BSecondAgreement() throws InterruptedException, IOException, TesseractException {
        new RegisterPageB2B(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2B()
                .markSecondAgreementB2B()
                .verifyRegisterPage();
    }

    @Test
    public void shouldNotRegisterCorrectlyB2BThirdAgreement() throws InterruptedException, IOException, TesseractException {
        new RegisterPageB2B(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2B()
                .markThirdAgreementB2B()
                .verifyRegisterPage();
    }

    @Test
    public void shouldRegisterCorrectlyB2BFirstAndSecondAgreements() {
        new RegisterPageB2B(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2B()
                .markFirstAndSecondAgreementsB2B();
    }

    @Test
    public void shouldRegisterCorrectlyB2BFirstAndThirdAgreements() {
        new RegisterPageB2B(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2B()
                .markFirstAndThirdAgreementsB2B();
    }

    @Test
    public void shouldNotRegisterB2CExistingEmailB2B() throws TesseractException, InterruptedException {
        new RegisterPageB2B(driver)
                .openRegisterPage()
                .setExistingEmailB2B();
    }


}
