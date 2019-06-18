package iTaxiPassanger.tests;

import iTaxiPassanger.pages.LogInPage;
import iTaxiPassanger.utilities.VouchersDataProvider;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

public class VoucherPageTests extends BaseTests {

    @Test(dataProvider = "incorrectDataForVoucher", dataProviderClass = VouchersDataProvider.class)
    public void shouldNotPutVoucher(String phoneNumber, String code) throws InterruptedException, IOException, TesseractException {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToVoucherPage().verifyVoucherPageHeader().putIncorrectData(phoneNumber, code).verifyToastMessage();
    }
}
