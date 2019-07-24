package iTaxiPassanger.tests;

import iTaxiPassanger.pages.LogInPage;
import iTaxiPassanger.pages.SplashPage;
import iTaxiPassanger.pages.VoucherPage;
import io.qameta.allure.Feature;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;


@Feature("Splash Page Tests")
public class SplashPageTests extends BaseTests {


    @Test
    public void shouldOpenLogInPage() {
        new SplashPage(driver).allowPermision().verifyMainScreen().goToLogInPage().verifyLogInPageHeader();
    }

    @Test
    public void shouldOpenVoucherPageAndBack() {
        new SplashPage(driver).allowPermision().verifyMainScreen().goToVoucherPage().verifyVoucherPageHeader().backToSplashPage().verifyMainScreen();
    }
    @Test
    public void compareScreenshotsOfSplash() throws IOException {
        new SplashPage(driver).allowPermision().verifyMainScreen().compareScreensSplash();

    }

}
