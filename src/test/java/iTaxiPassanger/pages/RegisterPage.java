package iTaxiPassanger.pages;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidTouchAction;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragRegisterBackHeader")
    private WebElement registerPageHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragLoginChooseType")
    private WebElement profileSwitch;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/agreementPrivateAll")
    private WebElement allAgreementsCheckbox;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/agreementPrivateOne")
    private WebElement firstAgreementCheckbox;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/agreementPrivateTwo")
    private WebElement secondAgreementCheckbox;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/agreementPrivateThree")
    private WebElement thirdAgreementCheckbox;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragRegBtnFeelForm")
    private WebElement nextButton;


    public RegisterPage verifyRegisterPage() {
        waitForVisibilityOfElement(registerPageHeader);
        Assert.assertTrue(registerPageHeader.isDisplayed());
        return this;
    }

    public RegisterPage openRegisterPage() {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToRegisterPage().verifyRegisterPage();
        return this;
    }

    public RegisterPage completeFieldsCorrectlyB2C() {
        Faker plFaker = new Faker(new Locale("pl"));
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pl"), new RandomService());
        String email = fakeValuesService.bothify("????##@xyz.xyz");
        String password = fakeValuesService.regexify("[a-z1-9]{10}");
        String nameAndSurname = plFaker.name().fullName();
        String phoneNumber = "508264455";
        List<WebElement> registerFields = driver.findElements(By.className("android.widget.EditText"));

        if (profileSwitch.getText().equals("WYŁ.")) {
            registerFields.get(0).sendKeys(nameAndSurname);
            registerFields.get(1).sendKeys(email);
            registerFields.get(2).sendKeys(phoneNumber);
            registerFields.get(3).sendKeys(password);

        } else if (profileSwitch.getText().equals("WŁ."))
            profileSwitch.click();
        registerFields.get(0).sendKeys(nameAndSurname);
        registerFields.get(1).sendKeys(email);
        registerFields.get(2).sendKeys(phoneNumber);
        registerFields.get(3).sendKeys(password);
        return this;
    }

    public RegisterPage markAllAgreementsAndAccept() {
        allAgreementsCheckbox.click();
//        nextButton.click();
        return this;
    }

    public RegisterPage markFirstAgreement() {
        firstAgreementCheckbox.click();
        nextButton.click();
        return this;
    }

    public RegisterPage markSecondAgreement() throws InterruptedException, TesseractException, IOException {
        secondAgreementCheckbox.click();
        nextButton.click();
        Thread.sleep(3000);
        String toastMessage = readToastMessage();
        String toastText = "Zaznaczenie pierwszej zgody";
        Assert.assertTrue((toastMessage).contains(toastText));
        return this;
    }

    public RegisterPage markThirdAgreement() throws InterruptedException, TesseractException, IOException {
        thirdAgreementCheckbox.click();
        nextButton.click();
        Thread.sleep(3000);
        String toastMessage = readToastMessage();
        String toastText = "Zaznaczenie pierwszej zgody";
        Assert.assertTrue((toastMessage).contains(toastText));
        return this;
    }

    public RegisterPage markFirstAndSecondAgreements() {
        firstAgreementCheckbox.click();
        secondAgreementCheckbox.click();
        nextButton.click();
        return this;
    }

    public RegisterPage markFirstAndThirdAgreements() {
        firstAgreementCheckbox.click();
        secondAgreementCheckbox.click();
        nextButton.click();
        return this;
    }

    public RegisterPage doNotSetData() {
        nextButton.click();
        List<WebElement> errorTextElements = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/editWithIconErrorText"));
        for (WebElement ele : errorTextElements) {
            String textOfElements = ele.getText();
            Assert.assertEquals(textOfElements, "Pole jest wymagane");
        }
        return this;
    }

    public RegisterPage setWrongData(String nameAndSurname, String errorText0, String email, String errorText1,
                                     String phoneNumber, String errorText2, String password, String errorText3) throws InterruptedException {
        List<WebElement> registerFields = driver.findElements(By.className("android.widget.EditText"));

        if (profileSwitch.getText().equals("WYŁ.")) {
            registerFields.get(0).sendKeys(nameAndSurname);
            registerFields.get(1).sendKeys(email);
            registerFields.get(2).sendKeys(phoneNumber);
            registerFields.get(3).sendKeys(password);
            nextButton.click();
            Thread.sleep(3000);

            List<WebElement> errorTextElements = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/editWithIconErrorText"));
            Assert.assertEquals(errorTextElements.get(0).getText(), errorText0);
            Assert.assertEquals(errorTextElements.get(1).getText(), errorText1);
            Assert.assertEquals(errorTextElements.get(2).getText(), errorText2);
            Assert.assertEquals(errorTextElements.get(3).getText(), errorText3);

        } else if (profileSwitch.getText().equals("WŁ.")) {
            profileSwitch.click();
            registerFields.get(0).sendKeys(nameAndSurname);
            registerFields.get(1).sendKeys(email);
            registerFields.get(2).sendKeys(phoneNumber);
            registerFields.get(3).sendKeys(password);
            nextButton.click();
            Thread.sleep(3000);
            List<WebElement> errorTextElements = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/editWithIconErrorText"));
            Assert.assertEquals(errorTextElements.get(0).getText(), errorText0);
            Assert.assertEquals(errorTextElements.get(1).getText(), errorText1);
            Assert.assertEquals(errorTextElements.get(2).getText(), errorText2);
            Assert.assertEquals(errorTextElements.get(3).getText(), errorText3);
        }
        return this;
    }


}
