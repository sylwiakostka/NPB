package iTaxiPassanger.utilities;

import org.testng.annotations.DataProvider;

import static com.sun.xml.internal.ws.policy.sourcemodel.wspolicy.XmlToken.Name;

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
                {"574777590", "oladni"},
        };
    }

    @DataProvider(name = "voucherCodesInvalid")
    public Object[][] invalidVoucherCodes() {
        return new Object[][]{
                {"574777590", "kuba", "Ten voucher jest przypisany do konkretnego"},
                {"574777590", "VON-5778AP", "Ten voucher jest przypisany do konkretnego"},
                {"574777590", "zzz", "Ten voucher nie moze by¢ wykorzystany w"},
                {"574777590", "marcin", "Ten voucher nie moze by¢ wykorzystany w"},
                {"574777590", "trewq", "Brak vouchera o podanym kodzie"},
                {"574777590", "VON-1188IU", "Voucher ma limit przedziatu godzin"}
        };
    }

    @DataProvider(name = "voucherCodesValid")
    public Object[][] validVoucherCodes() {
        return new Object[][]{
                {"574777590", "adec"},
//                {"508264455", "VON-8865GI"}
        };
    }
}