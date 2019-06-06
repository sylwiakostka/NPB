package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class HomePage  extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(tagName = "button")
    private WebElement logInButton;


    @Step
    public HomePage verifyURL() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://taxi.demo.eo.pl/taxi-business-client-web/login.html?iTaxiCookieCheck=check");
        return this;
    }

    @Step
    public HomePage logIn(String username, String password) {
        waitForVisibilityOfElement(driver.findElement(By.id("loginForm")));
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
}
