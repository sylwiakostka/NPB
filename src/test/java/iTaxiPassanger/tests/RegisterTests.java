package iTaxiPassanger.tests;

import iTaxiPassanger.pages.RegisterPage;
import iTaxiPassanger.utilities.RegisterWrongDataProvider;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;


public class RegisterTests extends BaseTests {

    @Test
    public void shouldRegisterCorrectlyB2CAllAgreements() {
        new RegisterPage(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markAllAgreementsAndAccept();
    }

    @Test
    public void shouldRegisterCorrectlyB2CFirstAgreement() {
        new RegisterPage(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markFirstAgreement();
    }

    @Test
    public void shouldNotRegisterCorrectlyB2CSecondAgreement() throws InterruptedException, IOException, TesseractException {
        new RegisterPage(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markSecondAgreement()
                .verifyRegisterPage();
    }

    @Test
    public void shouldNotRegisterCorrectlyB2CThirdAgreement() throws InterruptedException, IOException, TesseractException {
        new RegisterPage(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markThirdAgreement()
                .verifyRegisterPage();
    }

    @Test
    public void shouldRegisterCorrectlyB2CFirstAndSecondAgreements() {
        new RegisterPage(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markFirstAndSecondAgreements();
    }

    @Test
    public void shouldRegisterCorrectlyB2CFirstAndThirdAgreements() {
        new RegisterPage(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markFirstAndThirdAgreements();
    }

    @Test
    public void shouldNotRegisterB2CWithoutData() {
        new RegisterPage(driver)
                .openRegisterPage()
                .doNotSetData()
                .verifyRegisterPage();

    }

    @Test(dataProvider = "incorrectDataRegisterB2C", dataProviderClass = RegisterWrongDataProvider.class)
    public void shouldNotRegisterB2CWrongData(String nameAndSurname, String errorText0, String email, String errorText1,
                                              String phoneNumber, String errorText2, String password, String errorText3) throws InterruptedException {
        new RegisterPage(driver)
                .openRegisterPage()
                .setWrongData(nameAndSurname, errorText0, email, errorText1, phoneNumber, errorText2, password, errorText3)
                .verifyRegisterPage();
    }


}
