package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CentralBPPage extends BasePage {

    public CentralBPPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul//li[3]")
    private WebElement zarzadzanieButton;

    @FindBy(xpath = "//ul//li[3]//a[@href ='/taxi-business-client-web/voucher/list.html']")
    private WebElement kodyVoucheroweButton;



    @Step
    public void verifyCentralPageURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://taxi.demo.eo.pl/taxi-business-client-web/main.html");
    }

    @Step
    public VoucherCodesPage goToVoucherCodesPage() {
        zarzadzanieButton.click();
        kodyVoucheroweButton.click();
        new VoucherCodesPage(driver).verifyVoucherCodesURL();
        return new VoucherCodesPage(driver);
    }

}
