package iTaxiPassanger.tests;

import iTaxiPassanger.pages.LogInPage;
import iTaxiPassanger.pages.VoucherPage;
import io.qameta.allure.Feature;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;


@Feature("Splash Page Tests")
public class SplashPageTests extends BaseTests {


    @Test
    public void shouldOpenLogInPage() {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToLogInPage().verifyLogInPageHeader();
    }

    @Test
    public void shouldOpenVoucherPageAndBack() {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToVoucherPage().verifyVoucherPageHeader().backToSplashPage().verifyMainScreen();
    }
}
