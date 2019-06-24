package iTaxiPassanger.pages;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class RegisterPageB2C extends BasePage {
    public RegisterPageB2C(AndroidDriver driver) {
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

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragRegPrivateFormTermDesc")
    private WebElement regulationsButton;


    public RegisterPageB2C verifyRegisterPage() {
        waitForVisibilityOfElement(registerPageHeader);
        Assert.assertTrue(registerPageHeader.isDisplayed());
        return this;
    }

    public RegisterPageB2C openRegisterPage() {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToRegisterPage().verifyRegisterPage();
        return this;
    }

    public RegisterPageB2C completeFieldsCorrectlyB2C() {
        Faker plFaker = new Faker(new Locale("pl"));
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pl"), new RandomService());
        String email = fakeValuesService.bothify("????##@xyz.xyz");
        String password = fakeValuesService.regexify("[a-z1-9]{10}");
        String nameAndSurname = plFaker.name().fullName();
        String phoneNumber = "508264455";

        if (profileSwitch.getText().equals("WYŁ.")) {
            List<WebElement> registerFields = driver.findElements(By.className("android.widget.EditText"));
            registerFields.get(0).sendKeys(nameAndSurname);
            registerFields.get(1).sendKeys(email);
            registerFields.get(2).sendKeys(phoneNumber);
            registerFields.get(3).sendKeys(password);
            System.out.println(profileSwitch.getText());
        } else if (profileSwitch.getText().equals("WŁ.")) {
            profileSwitch.click();
            List<WebElement> registerFields = driver.findElements(By.className("android.widget.EditText"));
            registerFields.get(0).sendKeys(nameAndSurname);
            registerFields.get(1).sendKeys(email);
            registerFields.get(2).sendKeys(phoneNumber);
            registerFields.get(3).sendKeys(password);
        }
        return this;
    }

    public RegisterPageB2C markAllAgreementsAndAcceptB2C() {
        allAgreementsCheckbox.click();
        nextButton.click();
        return this;
    }

    public RegisterPageB2C markFirstAgreementB2C() {
        firstAgreementCheckbox.click();
        nextButton.click();
        return this;
    }

    public RegisterPageB2C markSecondAgreementB2C() throws InterruptedException, TesseractException, IOException {
        secondAgreementCheckbox.click();
        nextButton.click();
        Thread.sleep(3000);
        String toastMessage = readToastMessage();
        String toastText = "Zaznaczenie pierwszej zgody";
        Assert.assertTrue((toastMessage).contains(toastText));
        return this;
    }

    public RegisterPageB2C markThirdAgreementB2C() throws InterruptedException, TesseractException, IOException {
        thirdAgreementCheckbox.click();
        nextButton.click();
        Thread.sleep(3000);
        String toastMessage = readToastMessage();
        String toastText = "Zaznaczenie pierwszej zgody";
        Assert.assertTrue((toastMessage).contains(toastText));
        return this;
    }

    public RegisterPageB2C markFirstAndSecondAgreementsB2C() {
        firstAgreementCheckbox.click();
        secondAgreementCheckbox.click();
        nextButton.click();
        return this;
    }

    public RegisterPageB2C markFirstAndThirdAgreementsB2C() {
        firstAgreementCheckbox.click();
        secondAgreementCheckbox.click();
        nextButton.click();
        return this;
    }

    public RegisterPageB2C doNotSetDataB2C() {
        nextButton.click();
        List<WebElement> errorTextElements = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/editWithIconErrorText"));
        for (WebElement ele : errorTextElements) {
            String textOfElements = ele.getText();
            Assert.assertEquals(textOfElements, "Pole jest wymagane");
        }
        return this;
    }

    public RegisterPageB2C setWrongDataB2C(String nameAndSurname, String errorText0, String email, String errorText1,
                                           String phoneNumber, String errorText2, String password, String errorText3) throws InterruptedException {

        if (profileSwitch.getText().equals("WYŁ.")) {
            List<WebElement> registerFields = driver.findElements(By.className("android.widget.EditText"));
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
            List<WebElement> registerFields = driver.findElements(By.className("android.widget.EditText"));
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