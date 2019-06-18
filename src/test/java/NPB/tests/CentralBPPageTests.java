package NPB.tests;

import NPB.pages.CentralBPPage;
import org.testng.annotations.Test;
import NPB.pages.HomePage;
import NPB.pages.PartnerChosePage;
import NPB.utilities.LogUsersDataProvider;

public class CentralBPPageTests extends BaseTests {

    @Test(dataProvider = "combineCorrectDataLogInAndCorrectCompanyName", dataProviderClass = LogUsersDataProvider.class)
    public void goToVoucherCodesPage(String username, String password, String correctCompanyName) {
        new HomePage(driver).logIn(username, password);
        new PartnerChosePage(driver).canGoIn(correctCompanyName);
        new CentralBPPage(driver).goToVoucherCodesPage();
    }

}
