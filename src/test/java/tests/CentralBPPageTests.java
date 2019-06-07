package tests;

import org.testng.annotations.Test;
import pages.CentralBPPage;
import pages.HomePage;
import pages.PartnerChosePage;
import utilities.LogUsersDataProvider;

public class CentralBPPageTests extends BaseTests {

    @Test(dataProvider = "combineCorrectDataLogInAndCorrectCompanyName", dataProviderClass = LogUsersDataProvider.class)
    public void goToVoucherCodesPage(String username, String password, String correctCompanyName) {
        new HomePage(driver).logIn(username, password);
        new PartnerChosePage(driver).canGoIn(correctCompanyName);
        new CentralBPPage(driver).goToVoucherCodesPage();
    }

}
