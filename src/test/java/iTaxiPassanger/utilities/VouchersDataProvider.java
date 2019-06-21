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
                {"508264455", "oladni"},
        };
    }

    @DataProvider(name = "voucherCodesInvalid")
    public Object[][] invalidVoucherCodes() {
        return new Object[][]{
                {"508264455", "kuba", "Ten voucher jest przypisany do konkretnego"},
                {"508264455", "VON-5778AP", "Ten voucher jest przypisany do konkretnego"},
                {"508264455", "zzz", "Ten voucher nie moze by¢ wykorzystany w"},
                {"508264455", "marcin", "Ten voucher nie moze by¢ wykorzystany w"},
                {"508264455", "trewq", "Brak vouchera o podanym kodzie"},
                {"508264455", "VON-1188IU", "Voucher ma limit przedziatu godzin, w ktdrych"}
        };
    }

    @DataProvider(name = "voucherCodesValid")
    public Object[][] validVoucherCodes() {
        return new Object[][]{
                {"508264455", "adec"},
//                {"508264455", "VON-8865GI"}
        };
    }
}