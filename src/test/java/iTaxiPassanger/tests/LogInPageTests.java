package iTaxiPassanger.tests;


import iTaxiPassanger.pages.LogInPage;
import iTaxiPassanger.pages.MapPage;
import iTaxiPassanger.utilities.LogUsersWrongDataProvider;
import io.qameta.allure.Feature;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

@Feature("LogIn Tests B2C and B2B")
public class LogInPageTests extends BaseTests {


    @Test
    public void shouldLogInCorrectlyB2C (){
        new LogInPage(driver).verifyLogInPageHeader().logAsB2CUser("wkruk98@gmail.com", "wojkru");
        new MapPage(driver).verifyMap();
    }

    @Test
    public void shouldLogInCorrectlyB2B (){
        new LogInPage(driver).verifyLogInPageHeader().logAsB2BUser("jarsar888@gmail.com", "1234");
        new MapPage(driver).verifyMap();
    }

    @Test (dataProvider = "incorrectDataLogInB2C", dataProviderClass = LogUsersWrongDataProvider.class)
    public void shouldNotLogInB2C (String username, String password){
        new LogInPage(driver).verifyLogInPageHeader().cantLogInB2C(username,password).verifyLogInPageHeader();
    }

    @Test (dataProvider = "incorrectDataLogInB2B", dataProviderClass = LogUsersWrongDataProvider.class)
    public void shouldNotLogInB2B (String username, String password){
        new LogInPage(driver).verifyLogInPageHeader().cantLogInB2B(username,password).verifyLogInPageHeader();
    }

    @Test
    public void remindPassword () throws TesseractException, InterruptedException {
        new LogInPage(driver).verifyLogInPageHeader().goToPasswordResetPage().verifyPasswordResetPage().verifyPasswordResetPage().resetPassword();
    }
}
