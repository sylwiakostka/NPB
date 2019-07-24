package iTaxiPassanger.tests;

import iTaxiPassanger.pages.MenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Feature("Account Page Tests")
public class MyAccountTestsB2B extends BaseTests {

    @Test
    @Description("Description: B2B My account page - test to verify if user data is correct.")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldVerifyUserDataB2B() {
        new MenuPage(driver)
                .logInB2BAndOpenMenu("ola.tola@gmail.com", "1234")
                .openMyAccountPage()
                .verifyMyAccountPage()
                .verifyUserDataB2B()
                .logOut();
    }

    @Test
    @Description("Description: B2B My account page - test to verify if user can set home and work addresses.")
    @Severity(SeverityLevel.NORMAL)
    public void shouldSetAddresses() throws InterruptedException {
        new MenuPage(driver)
                .logInB2BAndOpenMenu("ola.tola@gmail.com", "1234")
                .openMyAccountPage()
                .verifyMyAccountPage()
                .addWorkAddress("Al. Jerozolimskie 200, Warszawa")
                .addHomeAddress("Jasna 5, Warszawa")
                .logOut();
    }

    @Test
    @Description("Description: B2B My account page - test to verify if user can switch silent.")
    @Severity(SeverityLevel.NORMAL)
    public void shouldSwitchSilent() {
        new MenuPage(driver)
                .logInB2BAndOpenMenu("ola.tola@gmail.com", "1234")
                .openMyAccountPage()
                .verifyMyAccountPage()
                .switchSilent()
                .logOut();
    }


    @Test
    @Description("Description: B2B My account page - test to verify if user can not change email, name and phone number.")
    @Severity(SeverityLevel.NORMAL)
    public void shouldTryToChangeEmailNameAndPhone() {
        new MenuPage(driver)
                .logInB2BAndOpenMenu("ola.tola@gmail.com", "1234")
                .openMyAccountPage()
                .verifyMyAccountPage()
                .verifyIfCanNotChangeDataUserB2B()
                .logOut();
    }
}
