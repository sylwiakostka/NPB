package NPB.tests;

import NPB.pages.DashboardPage;
import NPB.pages.LoginPage;
import org.testng.annotations.Test;

public class ProfilesPageTests extends BaseTests {

    @Test
    public void should_verify_tab_headers() throws InterruptedException {
        new LoginPage(driver)
                .verify_loginPage()
                .login_as_superAdmin()
                .choose_business_partner_from_list("HH")
                .go_to_MpkPage()
                .verify_MpkPage()
                .go_to_ProfilesPage()
                .verify_profilesPage()
                .verify_profiles_tab_header_names();
        new DashboardPage(driver).logout();
    }

    @Test
    public void should_verify_if_can_switch_profiles_list() throws InterruptedException {
        new LoginPage(driver)
                .verify_loginPage()
                .login_as_superAdmin()
                .choose_business_partner_from_list("HH")
                .go_to_MpkPage()
                .verify_MpkPage()
                .go_to_ProfilesPage()
                .verify_profilesPage()
                .verify_if_next_and_back_buttons_are_active_and_clickable();
        new DashboardPage(driver).logout();
    }
}
