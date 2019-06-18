package iTaxiPassanger.utilities;

import org.testng.annotations.DataProvider;

public class VouchersDataProvider {


    @DataProvider(name = "incorrectDataForVoucher")
    public Object[][] incorrectDataVoucher() {
        return new Object[][]{
                {"", "",},
                {"5082644", "oladni"},
                {"508264455", ""},
                {"", "oladni"},
        };
    }

    @DataProvider(name = "correctDataForVoucher")
    public Object[][] correctDataVoucher() {
        return new Object[][]{
                {"508264455", "oladni"},
        };
    }
}