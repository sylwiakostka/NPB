package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }


    @Step
    public HomePage verifyURL() {
        Assert.assertEquals("https://phptravels.com/demo/", driver.getCurrentUrl());
        return this;
    }
}