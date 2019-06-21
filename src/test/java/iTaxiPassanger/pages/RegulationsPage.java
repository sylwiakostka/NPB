package iTaxiPassanger.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegulationsPage extends BasePage {
    public RegulationsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyRegulationsPage (){
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://itaxi.pl/regulamin/");
    }
}
