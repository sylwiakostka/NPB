package NPB.pages;

import NPB.utilities.DataFaker;
import NPB.utilities.EmailHelper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemindPasswordPage extends BasePage {
    public RemindPasswordPage(WebDriver driver) {
        super(driver);
    }

    public static final String EMAIL = System.getenv("EMAIL_USERNAME");

    @FindBy(id = "login")
    private WebElement emailField;

    @FindBy(xpath = "//button[@id='button']//span[.='Wyślij kod']")
    private WebElement sendCodeButton;

    @FindBy(xpath = "//h3[.='Resetowanie hasła']")
    private WebElement headerRemindPassword;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement backButton;

    @FindBy(className = "benefits")
    private WebElement benefitsSection;

    @FindBy(xpath = "//label[@for='code']")
    private WebElement newCodeLabel;

    @FindBy(xpath = "//label[@for='password']")
    private WebElement newPasswordLabel;

    @FindBy(xpath = "//label[@for='newPassword']")
    private WebElement newPasswordRepeatLabel;

    @FindBy(id = "code")
    private WebElement newCodeField;

    @FindBy(id = "password")
    private WebElement newPasswordField;

    @FindBy(id = "newPassword")
    private WebElement newPasswordRepeatField;

    @FindBy(xpath = "//button[@id='button']//span[.='Resetuj hasło']")
    private WebElement changePasswordButton;

    @FindBy(xpath = "//div[@class='input']//p[.='Podaj adres email']")
    private WebElement errorEmailInfo;

    @FindBy (xpath = "//div[@class='notifications']//p[.='Brak konta biznesowego na podany email']")
    private WebElement errorEmailNotification;

    @Step
    public RemindPasswordPage verify_remindPasswordPage() {
        waitForVisibilityOfElement(headerRemindPassword);
        Assert.assertEquals(headerRemindPassword.getText(), "RESETOWANIE HASŁA");
        waitForVisibilityOfElement(benefitsSection);
        return this;
    }

    @Step
    public RemindPasswordPage verify_benefitsSection() {
        List<String> expectedTexts = Arrays.asList("Oszczędność czasu dla działów administracji i księgowości", "Narzędzie do kontroli kosztów", "Możliwość zarządzania przejazdami pracowników na wielu płaszczyznach", "Możliwość nadania wielu limitów", "Podgląd na bieżące wykorzystanie", "Rozbudowane raportowanie", "Wszystkie faktury w jednym miejscu", "Kanał informacji o bieżących akcjach i promocjach", "Bezpieczeństwo danych");
        List<String> actualTexts = new ArrayList<>();

        WebElement benefitsList = driver.findElement(By.xpath("//div[@class='benefits']//ul"));
        List<WebElement> elementsFromList = benefitsList.findElements(By.tagName("li"));
        for (WebElement element : elementsFromList) {
            actualTexts.add(element.getText());
        }
        Assert.assertEquals(expectedTexts.toString(), actualTexts.toString());
        return this;
    }

    @Step
    public RemindPasswordPage verify_new_fields_to_change_password() {
        Assert.assertEquals(newCodeLabel.getText(), "Wpisz kod do zresetowania hasła");
        Assert.assertEquals(newPasswordLabel.getText(), "Podaj nowe hasło:");
        Assert.assertEquals(newPasswordRepeatLabel.getText(), "Powtórz nowe hasło:");
        return this;
    }


    @Step
    public String remind_password_and_get_new() {
        emailField.sendKeys(EMAIL);
        sendCodeButton.click();
        verify_new_fields_to_change_password();

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String code = new EmailHelper(driver).openMail_and_readCode();
        driver.switchTo().window(tabs.get(0));
        newCodeField.sendKeys(code);
        String newPassword = DataFaker.generate_fake_passwrod();
        newPasswordField.sendKeys(newPassword);
        newPasswordRepeatField.sendKeys(newPassword);
        changePasswordButton.click();
        return newPassword;
    }

    @Step
    public RemindPasswordPage introduce_wrong_email() {
        waitForPresenceOfElement(emailField);
        waitForPresenceOfElement(sendCodeButton);
        waitForElementToBeClickable(sendCodeButton);
        emailField.sendKeys(DataFaker.generate_fake_email());
        sendCodeButton.click();
        waitForPresenceOfElement(errorEmailInfo);
        Assert.assertEquals(errorEmailInfo.getText(), "Podaj adres email");
        waitForPresenceOfElement(errorEmailNotification);
        Assert.assertEquals(errorEmailNotification.getText(), "Brak konta biznesowego na podany email");
        verify_remindPasswordPage();
        return this;
    }

    @Step
    public RemindPasswordPage empty_email() {
        waitForPresenceOfElement(emailField);
        waitForPresenceOfElement(sendCodeButton);
        waitForElementToBeClickable(sendCodeButton);
        emailField.sendKeys(" ");
        sendCodeButton.click();
        waitForPresenceOfElement(errorEmailInfo);
        Assert.assertEquals(errorEmailInfo.getText(), "Podaj adres email");
        verify_remindPasswordPage();
        return this;
    }

}
