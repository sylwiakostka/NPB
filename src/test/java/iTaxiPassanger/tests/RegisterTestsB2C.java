package iTaxiPassanger.tests;

import iTaxiPassanger.pages.RegisterPageB2C;
import iTaxiPassanger.utilities.MobileGestures;
import iTaxiPassanger.utilities.RegisterWrongDataProvider;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import java.io.IOException;


public class RegisterTestsB2C extends BaseTests {

    @Test
    public void shouldRegisterCorrectlyB2CAllAgreements() {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markAllAgreementsAndAcceptB2C();
    }

    @Test
    public void shouldRegisterCorrectlyB2CFirstAgreement() {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markFirstAgreementB2C();
    }

    @Test
    public void shouldNotRegisterCorrectlyB2CSecondAgreement() throws InterruptedException, IOException, TesseractException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markSecondAgreementB2C()
                .verifyRegisterPage();
    }

    @Test
    public void shouldNotRegisterCorrectlyB2CThirdAgreement() throws InterruptedException, IOException, TesseractException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markThirdAgreementB2C()
                .verifyRegisterPage();
    }

    @Test
    public void shouldRegisterCorrectlyB2CFirstAndSecondAgreements() {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markFirstAndSecondAgreementsB2C();
    }

    @Test
    public void shouldRegisterCorrectlyB2CFirstAndThirdAgreements() {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markFirstAndThirdAgreementsB2C();
    }

    @Test
    public void shouldNotRegisterB2CWithoutData() {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .doNotSetDataB2C()
                .verifyRegisterPage();

    }

    @Test(dataProvider = "incorrectDataRegisterB2C", dataProviderClass = RegisterWrongDataProvider.class)
    public void shouldNotRegisterB2CWrongData(String nameAndSurname, String errorText0, String email, String errorText1,
                                              String phoneNumber, String errorText2, String password, String errorText3) throws InterruptedException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .setWrongDataB2C(nameAndSurname, errorText0, email, errorText1, phoneNumber, errorText2, password, errorText3)
                .verifyRegisterPage();
    }





}



