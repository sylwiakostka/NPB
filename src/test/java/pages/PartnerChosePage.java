package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PartnerChosePage extends BasePage {

    public PartnerChosePage(WebDriver driver) {super(driver);
    }

    @Step
    public void verifyURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://taxi.demo.eo.pl/taxi-business-client-web/index.html");
    }
}
