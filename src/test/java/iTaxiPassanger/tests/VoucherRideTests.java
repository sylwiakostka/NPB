package iTaxiPassanger.tests;



import iTaxiPassanger.pages.VoucherMapAndMenuPage;
import iTaxiPassanger.utilities.VouchersDataProvider;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.Test;

import java.io.IOException;

public class VoucherRideTests extends BaseTests {

    @Test (dataProvider = "voucherCodesValid", dataProviderClass = VouchersDataProvider.class)
    public void shouldVerifyScreenOfOrderDetailsElements (String phoneNumber, String code) throws InterruptedException, IOException, TesseractException{
        new VoucherMapAndMenuPage(driver).makeBeReadyToOrderWithVoucher(phoneNumber, code).verifyDetailsOfScreenElements();
        new VoucherMapAndMenuPage(driver).compareScreens();
    }

    @Test (dataProvider = "voucherCodesValid", dataProviderClass = VouchersDataProvider.class)
    public void shouldOrderLuxuryTaxiRide (String phoneNumber, String code) throws InterruptedException, IOException, TesseractException{
        new VoucherMapAndMenuPage(driver)
                .makeBeReadyToOrderWithVoucher(phoneNumber, code)
                .verifyVoucherMapPage()
                .setStartAddress("Kmicica 1, Warszawa")
                .setLuxuryTaxi()
                .setDestinationAddress("Prosta 1, Warszawa")
                .confirmOrder();
    }

}
