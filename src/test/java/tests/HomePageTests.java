package tests;

import congif.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTest {


    @Test(priority = 0)
    @Description("Description: Open first Page")
    @Story("Open correctly page")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldOpenHomePage() {
        new HomePage(driver).verifyURL().logIn("sylwia", "123456789");

    }


}
