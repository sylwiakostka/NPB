package tests;

import congif.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends BaseTest {

    @Test
    public void shouldOpenHomePage (){
        new HomePage(driver).verifyURL();
    }
}
