package iTaxiPassanger.tests;

import iTaxiPassanger.pages.LogInPage;
import iTaxiPassanger.pages.SplashPage;
import iTaxiPassanger.pages.VerifyUserBySMSCodePage;
import iTaxiPassanger.pages.VoucherMapAndMenuPage;
import iTaxiPassanger.utilities.VouchersDataProvider;
import io.qameta.allure.Feature;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

@Feature("Set voucher before ride tests")
public class VoucherPageTests extends BaseTests {

    @Test(dataProvider = "incorrectDataForVoucher", dataProviderClass = VouchersDataProvider.class)
    public void shouldNotIntroduceVoucherCode(String phoneNumber, String code) throws InterruptedException, IOException, TesseractException {
        new SplashPage(driver).allowPermision().verifyMainScreen().goToVoucherPage().verifyVoucherPageHeader().putIncorrectData(phoneNumber, code).verifyToastMessage();
    }


    @Test(dataProvider = "voucherCodesInvalid", dataProviderClass = VouchersDataProvider.class)
    public void shouldNotIntroduceVoucherCodeValidation(String phoneNumber, String code, String toastText) throws InterruptedException, IOException, TesseractException {
        new SplashPage(driver).allowPermision().verifyMainScreen().goToVoucherPage().verifyVoucherPageHeader().putIncorrectVoucherCode(phoneNumber, code, toastText);
    }


    @Test(dataProvider = "voucherCodesValid", dataProviderClass = VouchersDataProvider.class)
    public void shouldIntroduceVoucherCodeValidation(String phoneNumber, String code) throws InterruptedException {
        new SplashPage(driver).allowPermision().verifyMainScreen().goToVoucherPage().verifyVoucherPageHeader().putCorrectVoucherCode(phoneNumber, code);

    }



}
