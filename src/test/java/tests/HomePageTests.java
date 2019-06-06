package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.LogUsersDataProvider;

public class HomePageTests extends BaseTest {


    @Test(priority = 0, dataProvider = "correctData", dataProviderClass = LogUsersDataProvider.class)
    @Description("Description: Log in with good username and password")
    @Story("Log in correctly")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("LogIn Test")
    public void shouldLogIn(String username, String password) {
        new HomePage(driver).logIn(username,password).verifyURL();

    }

    @Test (dataProvider = "incorrectData", dataProviderClass = LogUsersDataProvider.class)
    @Description("Description: Log in with wrong username and password")
    @Story("Log in ")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("LogIn Test")
    public void shouldNotLogIn (String username, String password, String expectedResult){
        new HomePage(driver).cantLogIn(username,password,expectedResult);
    }

}
