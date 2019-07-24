package iTaxiPassanger.tests;


import iTaxiPassanger.pages.MapPage;
import iTaxiPassanger.pages.MenuPage;
import iTaxiPassanger.pages.VerifyUserBySMSCodePage;
import org.testng.annotations.Test;

public class PromotionsPageTests extends BaseTests {

    @Test
    public void introduceCorrectPromotionCodeNewUser() throws InterruptedException {
        new MenuPage(driver).registerAndOpenMenu();
        new VerifyUserBySMSCodePage(driver)
                .readAndPutSMSIfNeedToVerify();
        new MapPage(driver).openMenu()
                .openPromotionsPage()
                .putPromotionCodeCorrectly("890")
                .backFromPromotionPage();
    }

    @Test
    public void introduceEmptyPromotionCodeNewUser() throws InterruptedException {
        new MenuPage(driver).registerAndOpenMenu();
        new VerifyUserBySMSCodePage(driver)
                .readAndPutSMSIfNeedToVerify();
        new MapPage(driver).openMenu()
                .openPromotionsPage()
                .doNotPutCode()
                .backFromPromotionPage();
    }

    @Test
    public void introduceIncorrectPromotionCodeNewUser() throws InterruptedException {
        new MenuPage(driver).registerAndOpenMenu();
        new VerifyUserBySMSCodePage(driver)
                .readAndPutSMSIfNeedToVerify();
        new MapPage(driver).openMenu()
                .openPromotionsPage()
                .putWrongPromotionCode("000")
                .backFromPromotionPage();
    }

    @Test
    public void changeExistingPromotionCodeNewUser() throws InterruptedException {
        new MenuPage(driver).registerAndOpenMenu();
        new VerifyUserBySMSCodePage(driver)
                .readAndPutSMSIfNeedToVerify();
        new MapPage(driver).openMenu()
                .openPromotionsPage()
                .putPromotionCodeCorrectly("BLIK2")
                .changeCode("890")
                .backFromPromotionPage();
    }



}
