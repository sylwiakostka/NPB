package iTaxiPassanger.tests;



import iTaxiPassanger.pages.MapPage;
import iTaxiPassanger.pages.SplashPage;
import iTaxiPassanger.utilities.LogUsersWrongDataProvider;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.io.IOException;

@Feature("LogIn Tests B2C and B2B")
public class LogInPageTests extends BaseTests {


    @Test
    public void shouldLogInCorrectlyB2C (){
        new SplashPage(driver).allowPermision().verifyMainScreen()
                .goToLogInPage().verifyLogInPageHeader().logAsB2CUser("wkruk98@gmail.com", "wojkru");
        new MapPage(driver).verifyMap();
    }

    @Test
    public void shouldLogInCorrectlyB2B (){
        new SplashPage(driver).allowPermision().verifyMainScreen()
                .goToLogInPage().verifyLogInPageHeader().logAsB2BUser("jarsar888@gmail.com", "1234");
        new MapPage(driver).verifyMap();
    }

    @Test (dataProvider = "incorrectDataLogInB2C", dataProviderClass = LogUsersWrongDataProvider.class)
    public void shouldNotLogInB2C (String username, String password){
        new SplashPage(driver).allowPermision().verifyMainScreen()
                .goToLogInPage().verifyLogInPageHeader().cantLogInB2C(username,password).verifyLogInPageHeader();
    }

    @Test (dataProvider = "incorrectDataLogInB2B", dataProviderClass = LogUsersWrongDataProvider.class)
    public void shouldNotLogInB2B (String username, String password){
        new SplashPage(driver).allowPermision().verifyMainScreen()
                .goToLogInPage().verifyLogInPageHeader().cantLogInB2B(username,password).verifyLogInPageHeader();
    }

//    @Test
//    public void remindPassword () throws TesseractException, InterruptedException {
//        new SplashPage(driver).allowPermision().verifyMainScreen()
//                .goToLogInPage().verifyLogInPageHeader().goToPasswordResetPage().verifyPasswordResetPage().verifyPasswordResetPage().resetPassword("juliamis222@gmail.com");
//    }

    @Test
    public void compareAccountIconB2C () throws IOException, InterruptedException {
        new SplashPage(driver).allowPermision().verifyMainScreen()
                .goToLogInPage().verifyLogInPageHeader().setB2CUserBySwitcher().compareAccountIconB2C();
    }

    @Test
    public void compareAccountIconB2B () throws IOException, InterruptedException {
        new SplashPage(driver).allowPermision().verifyMainScreen()
                .goToLogInPage().verifyLogInPageHeader().setB2BUserBySwitcher()
                .compareAccountIconB2B();
    }

}
