package NPB.tests;

import NPB.pages.HomePage;
import NPB.utilities.LogUsersDataProvider;
import io.qameta.allure.*;
import org.testng.annotations.Test;


@Feature("LogIn Test")
public class HomePageTests extends BaseTests {


    @Test(dataProvider = "correctDataLogIn", dataProviderClass = LogUsersDataProvider.class)
    @Description("Description: Log in with good username and password")
    @Story("Log in correctly")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldLogIn(String username, String password) {
        new HomePage(driver).logIn(username,password).verifyPartnerChosePageURL();

    }

    @Test (dataProvider = "incorrectDataLogIn", dataProviderClass = LogUsersDataProvider.class)
    @Description("Description: Log in with wrong username and password")
    @Story("Log in ")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldNotLogIn (String username, String password, String expectedResult){
        new HomePage(driver).cantLogIn(username,password,expectedResult);
    }

}
