package tests;

import congif.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTest {

    @Description("Description: Open first Page")
    @Story("Open correctly page")
    @Severity(SeverityLevel.BLOCKER)

    @Test (priority = 0)
    public void shouldOpenHomePage() {
        new HomePage(driver).verifyURL();
    }

    @Test (priority = 1)
    public void denyNotification (){
        new HomePage(driver).denyNotifications();
    }
}
