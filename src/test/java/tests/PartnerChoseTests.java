package tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PartnerChosePage;
import utilities.LogUsersDataProvider;


@Feature("Chose Partner Test")
public class PartnerChoseTests extends BaseTests {


    @Test (dataProvider = "combineCorrectDataLogInAndWrongCompanyName", dataProviderClass = LogUsersDataProvider .class)
    public void choseWrongPartner (String username, String password, String incorrectCompanyName){
        new HomePage(driver).logIn(username, password);
        new PartnerChosePage(driver).cantGoIn(incorrectCompanyName);
    }

    @Test (dataProvider =  "combineCorrectDataLogInAndCorrectCompanyName", dataProviderClass = LogUsersDataProvider .class)
    public void choseCorrectPartner  (String username, String password, String correctCompanyName){
        new HomePage(driver).logIn(username,password);
        new PartnerChosePage(driver).canGoIn(correctCompanyName);
    }



}
