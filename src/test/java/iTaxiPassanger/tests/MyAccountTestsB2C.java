package iTaxiPassanger.tests;

import iTaxiPassanger.pages.MenuPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Feature("Account Page Tests")
public class MyAccountTestsB2C extends BaseTests {

    @Test
    @Description("Description: B2C My account page - test to verify if user data is correct.")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldVerifyUserDataB2C() {
        new MenuPage(driver)
                .logInAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openMyAccountPage()
                .verifyMyAccountPage()
                .verifyUserDataB2C();
    }

    @Test
    @Description("Description: B2C My account page - test to verify if user can set home and work addresses.")
    @Severity(SeverityLevel.NORMAL)
    public void shouldSetAddresses() throws InterruptedException {
        new MenuPage(driver)
                .logInAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openMyAccountPage()
                .verifyMyAccountPage()
                .addHomeAddress("Jasna 5, Warszawa")
                .addWorkAddress("Sasanki 2, Warszawa");
    }

    @Test
    @Description("Description: B2C My account page - test to verify if user can switch silent.")
    @Severity(SeverityLevel.NORMAL)
    public void shouldSwitchSilent() {
        new MenuPage(driver)
                .logInAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openMyAccountPage()
                .verifyMyAccountPage()
                .switchSilent();
    }

    @Test
    @Description("Description: B2C My account page - test to verify if user can change name and surname. After data is set to the same like before test.")
    @Severity(SeverityLevel.MINOR)
    public void shouldChangeNameAndSurname() {
        new MenuPage(driver)
                .logInAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openMyAccountPage()
                .verifyMyAccountPage()
                .changeNameAndSurname("Andrzej Wszoła")
                .changeNameAndSurname("Marek Wąs");
    }

    @Test
    @Description("Description: B2C My account page - test to verify if user can change phone number. New phone number is not set.")
    @Severity(SeverityLevel.NORMAL)
    public void shouldTryToChangePhoneNumber() throws InterruptedException {
        new MenuPage(driver)
                .logInAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openMyAccountPage()
                .verifyMyAccountPage()
                .tryToChangePhoneNumber();
    }

    @Test
    @Description("Description: B2C My account page - test to verify if user can not change email.")
    @Severity(SeverityLevel.NORMAL)
    public void shouldTryToChangeEmail()  {
        new MenuPage(driver)
                .logInAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .openMyAccountPage()
                .verifyMyAccountPage()
                .tryToChangeEmail();
    }
}
