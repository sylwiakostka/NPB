package pages;


import com.sun.xml.internal.ws.policy.AssertionSet;
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

    @FindBy (xpath = "//div[contains(text(),'Niepoprawny login/hasło.')]")
    private WebElement cantLogInInfo;



    @Step
    public PartnerChosePage logIn(String username, String password) {
        waitForVisibilityOfElement(driver.findElement(By.id("loginForm")));
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        logInButton.click();
        return new PartnerChosePage(driver);
    }

    @Step
    public void cantLogIn(String username, String password, String expectedResult) {
        waitForVisibilityOfElement(driver.findElement(By.id("loginForm")));
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        logInButton.click();
        Assert.assertTrue(cantLogInInfo.isDisplayed());
        Assert.assertEquals(cantLogInInfo.getText(), expectedResult);

    }
}
