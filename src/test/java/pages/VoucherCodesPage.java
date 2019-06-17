package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class VoucherCodesPage extends BasePage {
    public VoucherCodesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='generateVoucherForm']//label[@for='userType1']")
    private WebElement guestRadioButton;


    @FindBy(xpath = "//*[@id='generateVoucherForm']//label[@for='userType0']")
    private WebElement employeeRadioButton;

    @Step
    public void verifyVoucherCodesURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://taxi.demo.eo.pl/taxi-business-client-web/voucher/list.html");
    }

    @Step
    public VoucherCodesPage goToVoucherCodesPage(String username, String password, String correctCompanyName) {
        new HomePage(driver).logIn(username, password);
        new PartnerChosePage(driver).canGoIn(correctCompanyName);
        new CentralBPPage(driver).goToVoucherCodesPage();
        return new VoucherCodesPage(driver);
    }

    @Step
    public VoucherCodesPage selectOneUseVoucher() {
        Select voucherUseType = new Select(driver.findElement(By.id("voucher.useType")));
        Assert.assertFalse(voucherUseType.isMultiple());
        Assert.assertEquals(2, voucherUseType.getOptions().size());
        voucherUseType.selectByValue("ONE_USE_VOUCHER");
        Assert.assertEquals("Voucher jednorazowy             ", voucherUseType.getFirstSelectedOption().getText());
        return new VoucherCodesPage(driver);
    }

    @Step
    public VoucherCodesPage selectMultiUseVoucher() {
        Select voucherUseType = new Select(driver.findElement(By.id("voucher.useType")));
        Assert.assertFalse(voucherUseType.isMultiple());
        Assert.assertEquals(2, voucherUseType.getOptions().size());
        voucherUseType.selectByValue("MULTI_USE_VOUCHER");
        Assert.assertEquals("Voucher wielorazowy             ", voucherUseType.getFirstSelectedOption().getText());
        return new VoucherCodesPage(driver);
    }

    @Step
    public VoucherCodesPage selectVoucherForGuest() {
        guestRadioButton.click();
        Assert.assertFalse(employeeRadioButton.isSelected());
        return new VoucherCodesPage(driver);
    }

    @Step
    public VoucherCodesPage selectVoucherForEmployee() {
        employeeRadioButton.click();
        Assert.assertTrue(employeeRadioButton.isSelected());
        return new VoucherCodesPage(driver);
    }


}
