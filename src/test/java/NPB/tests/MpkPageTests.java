package NPB.tests;

import NPB.pages.LoginPage;
import NPB.utilities.LogUsersDataProvider;
import org.testng.annotations.Test;

public class MpkPageTests extends BaseTests {

    @Test(dataProvider = "correctDataToAddMPK", dataProviderClass = LogUsersDataProvider.class)
    public void should_add_new_mpk(String mpkName, String maxAmount, String alertAmount, String comment) throws InterruptedException {
        new LoginPage(driver)
                .verify_loginPage()
                .login_as_superAdmin()
                .choose_business_partner_from_list("ABC")
                .go_to_MpkPage()
                .verify_MpkPage()
                .add_new_mpk(mpkName, maxAmount, alertAmount, comment)
                .verify_is_mpk_added(mpkName, maxAmount, alertAmount, comment);
    }

    @Test
    public void should_cant_add_new_mpk() throws InterruptedException {
        new LoginPage(driver)
                .verify_loginPage()
                .login_as_superAdmin()
                .choose_business_partner_from_list("ABC")
                .go_to_MpkPage()
                .verify_MpkPage()
                .cant_add_mpk_without_data();
    }

    @Test
    public void should_delete_mpk() throws InterruptedException {
        new LoginPage(driver)
                .verify_loginPage()
                .login_as_superAdmin()
                .choose_business_partner_from_list("ABC")
                .go_to_MpkPage()
                .verify_MpkPage()
                .show_amount_of_rows_per_page("20")
                .choose_appropriate_mpk_without_users_and_click_delete("erw")
                .verify_if_deleted_mpk_isnt_on_list("erw");
    }

    @Test
    public void should_active_deleted_mpk() throws InterruptedException {
        new LoginPage(driver)
                .verify_loginPage()
                .login_as_superAdmin()
                .choose_business_partner_from_list("ABC")
                .go_to_MpkPage()
                .verify_MpkPage()
                .active_deleted_mpk("dd");

    }

}
