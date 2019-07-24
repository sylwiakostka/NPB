package iTaxiPassanger.tests;

import iTaxiPassanger.pages.MenuPage;
import org.testng.annotations.Test;

public class SwitchBetweenAcountsTests extends BaseTests {

    @Test
    public void switchBetweenLoggedUsers() {
        new MenuPage(driver)
                .logInB2BAndOpenMenu("ola.tola@gmail.com", "1234").verifyMenuPage().logOut().goToLogInPage()
                .logAsB2CUser("wasmarc12@gmail.com", "was1234").openMenu().verifyMenuPage().switchFromB2CToB2B().switchFromB2BToB2C();
    }

    @Test
    public void switchFromB2BLoggedToB2C() {
        new MenuPage(driver)
                .logInB2BAndOpenMenu("ola.tola@gmail.com", "1234").verifyMenuPage()
                .logB2CUserByMenuPanel("wasmarc12@gmail.com", "was1234");

    }

    @Test
    public void switchFromB2CLoggedToB2B() {
        new MenuPage(driver)
                .logInB2CAndOpenMenu("wasmarc12@gmail.com", "was1234")
                .verifyMenuPage().logB2BUserByMenuPanel("ola.tola@gmail.com", "1234");
    }

//    @Test
//    public void switchFromB2BLoggedAndRegisterB2C(){
//        new MenuPage(driver)
//                .logInB2BAndOpenMenu("ola.tola@gmail.com", "1234").verifyMenuPage().registerB2CUserByMenuPanel();
//    }
//
    // PO NAPRAWIENIU AND-1065
//
//    @Test
//    public void switchFromB2CLoggedAndRegisterB2B(){
//
//    }

    @Test
    public void doNotSwitchB2B() {
        new MenuPage(driver)
                .logInB2BAndOpenMenu("ola.tola@gmail.com", "1234").verifyMenuPage().doNotSwitchB2B();
    }

    @Test
    public void doNotSwitchB2C() {
        new MenuPage(driver)
                .logInB2CAndOpenMenu("wasmarc12@gmail.com", "was1234").verifyMenuPage().doNotSwitchB2C();
    }



}
