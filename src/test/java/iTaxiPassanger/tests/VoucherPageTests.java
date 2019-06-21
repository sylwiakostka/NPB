package iTaxiPassanger.tests;

import iTaxiPassanger.pages.LogInPage;
import iTaxiPassanger.pages.VoucherMapAndMenuPage;
import iTaxiPassanger.utilities.VouchersDataProvider;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

public class VoucherPageTests extends BaseTests {

    @Test(dataProvider = "incorrectDataForVoucher", dataProviderClass = VouchersDataProvider.class)
    public void shouldNotIntroduceVoucherCode(String phoneNumber, String code) throws InterruptedException, IOException, TesseractException {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToVoucherPage().verifyVoucherPageHeader().putIncorrectData(phoneNumber, code).verifyToastMessage();
    }


    @Test(dataProvider = "voucherCodesInvalid", dataProviderClass = VouchersDataProvider.class)
    public void shouldNotIntroduceVoucherCodeValidation(String phoneNumber, String code, String toastText) throws InterruptedException, IOException, TesseractException {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToVoucherPage().verifyVoucherPageHeader().putIncorrectVoucherCode(phoneNumber, code, toastText);
    }


    @Test(dataProvider = "voucherCodesValid", dataProviderClass = VouchersDataProvider.class)
    public void shouldIntroduceVoucherCodeValidation(String phoneNumber, String code) throws InterruptedException {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToVoucherPage().verifyVoucherPageHeader().putCorrectVoucherCode(phoneNumber, code);
        new VoucherMapAndMenuPage(driver).verifyVoucherMapPage();
    }



}
