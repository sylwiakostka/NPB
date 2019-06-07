package tests;

import org.testng.annotations.Test;
import pages.VoucherCodesPage;
import utilities.LogUsersDataProvider;

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
