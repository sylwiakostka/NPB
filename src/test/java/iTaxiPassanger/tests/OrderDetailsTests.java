package iTaxiPassanger.tests;

import iTaxiPassanger.pages.OrderDetailsPage;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Order Details Tests")
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
