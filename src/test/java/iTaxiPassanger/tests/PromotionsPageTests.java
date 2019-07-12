package iTaxiPassanger.tests;


import iTaxiPassanger.pages.MapPage;
import iTaxiPassanger.pages.MenuPage;
import iTaxiPassanger.pages.VerifyUserBySMSCodePage;
import org.testng.annotations.Test;

public class PromotionsPageTests extends BaseTests {

    @Test
    public void introduceCorrectPromotionCode() throws InterruptedException {
        new MenuPage(driver).registerAndOpenMenu();
        new VerifyUserBySMSCodePage(driver)
                .readAndPutSMSIfNeedToVerify();
        new MapPage(driver).openMenu()
                .openPromotionsPage()
                .putPromotionCodeCorrectly("890")
                .backFromPromotionPage();
    }

}
