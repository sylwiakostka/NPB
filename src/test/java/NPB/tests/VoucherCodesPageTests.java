package NPB.tests;

import NPB.pages.VoucherCodesPage;
import NPB.utilities.LogUsersDataProvider;
import org.testng.annotations.Test;

public class VoucherCodesPageTests extends BaseTests {

    @Test (dataProvider = "combineCorrectDataLogInAndCorrectCompanyName", dataProviderClass = LogUsersDataProvider.class)
    public void generateOneUseVoucherForGuest(String username, String password, String correctCompanyName) {
        new VoucherCodesPage(driver).goToVoucherCodesPage(username, password,correctCompanyName).selectOneUseVoucher().selectVoucherForGuest();
    }

    @Test (dataProvider = "combineCorrectDataLogInAndCorrectCompanyName", dataProviderClass = LogUsersDataProvider.class)
    public void generateMultiUseVoucher (String username, String password, String correctCompanyName) {
        new VoucherCodesPage(driver).goToVoucherCodesPage(username, password,correctCompanyName).selectMultiUseVoucher();
    }


}
