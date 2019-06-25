package iTaxiPassanger.tests;

import iTaxiPassanger.pages.OrderDetailsPage;
import org.testng.annotations.Test;

public class OrderDetailsTests extends BaseTests {

    @Test
    public void setFutureOrderIn30Min (){
        new OrderDetailsPage(driver).makeBeReadyToOrder().setTimeIn30Minutes().verifyIsFutureOrderSet();
    }

    @Test
    public void chooseTaxiFromList () throws InterruptedException {
        new OrderDetailsPage(driver).makeBeReadyToOrder().chooseTaxiFromList();
    }
}
