package iTaxiPassanger.tests;

import iTaxiPassanger.pages.RegisterPageB2C;
import iTaxiPassanger.pages.VerifyUserBySMSCodePage;
import iTaxiPassanger.utilities.ReadSMS;
import iTaxiPassanger.utilities.RegisterWrongDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

@Feature("Register Tests B2C")
public class RegisterTestsB2C extends BaseTests {

    @Test
    @Description("Description: B2C Login test with correct username and password, with all agreements - can log in.")
    public void shouldRegisterCorrectlyB2CAllAgreements() throws InterruptedException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markAllAgreementsAndAcceptB2C();
        new VerifyUserBySMSCodePage(driver).verifyVerifyUserBySMSCodePage()
                .readAndPutSMSIfNeedToVerify();
    }

    @Test
    @Description("Description: B2C Login test with correct username and password, with only first agreement - can log in.")
    public void shouldRegisterCorrectlyB2CFirstAgreement() throws InterruptedException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markFirstAgreementB2C();
        new VerifyUserBySMSCodePage(driver).verifyVerifyUserBySMSCodePage()
                .readAndPutSMSIfNeedToVerify();
    }

    @Test
    @Description("Description: B2C Login test with correct username and password with, with only second agreement. - can not log in")
    public void shouldNotRegisterCorrectlyB2CSecondAgreement() throws InterruptedException, TesseractException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markSecondAgreementB2C()
                .verifyRegisterPage();
    }

    @Test
    @Description("Description: B2C Login test with correct username and password with, with only third agreement. - can not log in")
    public void shouldNotRegisterCorrectlyB2CThirdAgreement() throws InterruptedException,  TesseractException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markThirdAgreementB2C()
                .verifyRegisterPage();
    }

    @Test
    @Description("Description: B2C Login test with correct username and password, with first and second agreement - can log in.")
    public void shouldRegisterCorrectlyB2CFirstAndSecondAgreements() throws InterruptedException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markFirstAndSecondAgreementsB2C();
        new VerifyUserBySMSCodePage(driver).verifyVerifyUserBySMSCodePage()
                .readAndPutSMSIfNeedToVerify();
    }

    @Test
    @Description("Description: B2C Login test with correct username and password, with first and third agreement - can log in.")
    public void shouldRegisterCorrectlyB2CFirstAndThirdAgreements() throws InterruptedException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .completeFieldsCorrectlyB2C()
                .markFirstAndThirdAgreementsB2C();
        new VerifyUserBySMSCodePage(driver).verifyVerifyUserBySMSCodePage()
                .readAndPutSMSIfNeedToVerify();
    }

    @Test
    @Description("Description: B2C Login test without username and password - can not log in.")
    public void shouldNotRegisterB2CWithoutData() {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .doNotSetDataB2C()
                .verifyRegisterPage();

    }

    @Test(dataProvider = "incorrectDataRegisterB2C", dataProviderClass = RegisterWrongDataProvider.class)
    @Description("Description: B2C Login test with wrong username and password - can not log in.")
    public void shouldNotRegisterB2CWrongData(String nameAndSurname, String errorText0, String email, String errorText1,
                                              String phoneNumber, String errorText2, String password, String errorText3) throws InterruptedException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .setWrongDataB2C(nameAndSurname, errorText0, email, errorText1, phoneNumber, errorText2, password, errorText3)
                .verifyRegisterPage();
    }

    @Test
    @Description("Description: B2C Login test with existing username and password - can not log in.")
    public void shouldNotRegisterB2CExistingEmailB2C () throws TesseractException, InterruptedException {
        new RegisterPageB2C(driver)
                .openRegisterPage()
                .setExistingEmail();
    }

    @Test
    @Description("Description: B2C user can open regulations page.")
    public void shouldOpenReg() {
        new RegisterPageB2C(driver)
                .openRegisterPage().tapOnRegulation();

    }

}



