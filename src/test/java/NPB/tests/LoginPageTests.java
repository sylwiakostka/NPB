package NPB.tests;

import NPB.pages.LoginPage;
import NPB.utilities.LogUsersDataProvider;
import iTaxiPassanger.utilities.LogUsersWrongDataProvider;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Feature("LogIn Test")
public class LoginPageTests extends BaseTests {

    @Test
    public void should_verify_loginPage() {
        new LoginPage(driver)
                .verify_loginPage()
                .verify_benefitsSection();
    }

    @Test
    public void should_login_as_superAdmin() {
        new LoginPage(driver)
                .verify_loginPage()
                .login_as_superAdmin()
                .choose_business_partner_from_list("ABC")
                .verify_dashboardPge_for_admin();
    }

    @Test (dataProvider = "correctDataLogIn", dataProviderClass = LogUsersDataProvider.class)
    public void should_login_as_employee(String username, String password) {
        new LoginPage(driver)
                .verify_loginPage()
                .login_as_employee(username,password)
                .verify_dashboardPge_for_employee();
    }

    @Test
    public void should_cant_login_wrong_credentials (){

    }
}
