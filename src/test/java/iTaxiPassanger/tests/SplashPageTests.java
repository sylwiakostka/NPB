package iTaxiPassanger.tests;

import iTaxiPassanger.pages.LogInPage;
import iTaxiPassanger.pages.VoucherPage;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

public class SplashPageTests extends BaseTests {


    @Test
    public void openLogInPage() {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToLogInPage().verifyLogInPageHeader();
    }

    @Test
    public void openVoucherPageAndBack() throws InterruptedException, TesseractException, IOException {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToVoucherPage().verifyVoucherPageHeader().backToSplashPage().verifyMainScreen();
    }
}
