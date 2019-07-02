package iTaxiPassanger.pages;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import iTaxiPassanger.utilities.GetNIP;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import static iTaxiPassanger.utilities.MobileGestures.ScrollDown;


public class RegisterPageB2B extends BasePage {
    public RegisterPageB2B(AndroidDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragRegisterBackHeader")
    private WebElement registerPageHeader;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragLoginChooseType")
    private WebElement profileSwitch;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/agreementBusinessAll")
    private WebElement allAgreementsCheckboxB2B;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/fragRegBusinessFormBtnSendForm")
    private WebElement sendB2bButton;

    @FindBy(id = "android:id/message")
    private WebElement popupMessage;

    @FindBy(id = "android:id/button1")
    private WebElement acceptPopupButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/agreementBusinessOne")
    private WebElement firstAgreementCheckboxB2B;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/agreementBusinessTwo")
    private WebElement secondAgreementCheckboxB2B;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/agreementBusinessThree")
    private WebElement thirdAgreementCheckboxB2B;


    @Step
    public RegisterPageB2B verifyRegisterPage() {
        waitForVisibilityOfElement(registerPageHeader);
        Assert.assertTrue(registerPageHeader.isDisplayed());
        return this;
    }

    @Step
    public RegisterPageB2B openRegisterPage() {
        new LogInPage(driver).verifyLogInPageHeader().backToSplashPage().verifyMainScreen().goToRegisterPage().verifyRegisterPage();
        return this;
    }

    @Step
    public RegisterPageB2B completeFieldsCorrectlyB2B() {
        Faker plFaker = new Faker(new Locale("pl"));
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pl"), new RandomService());
        String email = fakeValuesService.bothify("????##@xyz.xyz");
        String password = fakeValuesService.regexify("[a-z1-9]{10}");
        String nameAndSurname = plFaker.name().fullName();
        String phoneNumber = "508264455";
        waitForVisibilityOfElement(profileSwitch);
        if (profileSwitch.getText().equals("WŁ.")) {
            List<WebElement> registerFieldsB2B = driver.findElements(By.className("android.widget.EditText"));
            registerFieldsB2B.get(0).sendKeys(nameAndSurname);
            registerFieldsB2B.get(1).sendKeys(GetNIP.generateNIP());
            registerFieldsB2B.get(2).sendKeys(email);
            registerFieldsB2B.get(3).sendKeys(phoneNumber);
            registerFieldsB2B.get(4).sendKeys(password);
        } else if (profileSwitch.getText().equals("WYŁ.")) {
            profileSwitch.click();
            List<WebElement> registerFieldsB2B = driver.findElements(By.className("android.widget.EditText"));
            registerFieldsB2B.get(0).sendKeys(nameAndSurname);
            registerFieldsB2B.get(1).sendKeys(GetNIP.generateNIP());
            registerFieldsB2B.get(2).sendKeys(email);
            registerFieldsB2B.get(3).sendKeys(phoneNumber);
            registerFieldsB2B.get(4).sendKeys(password);
        }
        return this;
    }

    @Step
    public RegisterPageB2B markAllAgreementsAndAcceptB2B() {
        allAgreementsCheckboxB2B.click();
        ScrollDown();
        sendB2bButton.click();
        return this;
    }

    @Step
    public void verifyConfirmationPopup() {
        waitForVisibilityOfElement(driver.findElement(By.id("android:id/parentPanel")));
        Assert.assertEquals(popupMessage.getText(), "Dziękujemy! Wkrótce skontaktujemy się z Tobą, by dokończyć rejestrację!");
        acceptPopupButton.click();
        new SplashPage(driver).verifyMainScreen();
    }

    @Step
    public RegisterPageB2B doNotSetDataB2B() {
        waitForVisibilityOfElement(profileSwitch);
        profileSwitch.click();
        ScrollDown();
        sendB2bButton.click();
        List<WebElement> errorTextElements = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/editWithIconErrorText"));
        for (WebElement ele : errorTextElements) {
            String textOfElements = ele.getText();
            Assert.assertEquals(textOfElements, "Pole jest wymagane");
        }
        return this;
    }

    @Step
    public RegisterPageB2B setWrongDataB2B(String nameAndSurname, String errorText0, String nip, String errorText1, String email, String errorText2,
                                           String phoneNumber, String errorText3, String password, String errorText4) throws InterruptedException {
        waitForVisibilityOfElement(profileSwitch);
        if (profileSwitch.getText().equals("WŁ.")) {
            List<WebElement> registerFieldsB2B = driver.findElements(By.className("android.widget.EditText"));
            registerFieldsB2B.get(0).sendKeys(nameAndSurname);
            registerFieldsB2B.get(1).sendKeys(nip);
            registerFieldsB2B.get(2).sendKeys(email);
            registerFieldsB2B.get(3).sendKeys(phoneNumber);
            registerFieldsB2B.get(4).sendKeys(password);
            ScrollDown();
            sendB2bButton.click();
            Thread.sleep(3000);

            List<WebElement> errorTextElements = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/editWithIconErrorText"));
            Assert.assertEquals(errorTextElements.get(0).getText(), errorText0);
            Assert.assertEquals(errorTextElements.get(1).getText(), errorText1);
            Assert.assertEquals(errorTextElements.get(2).getText(), errorText2);
            Assert.assertEquals(errorTextElements.get(3).getText(), errorText3);
            Assert.assertEquals(errorTextElements.get(4).getText(), errorText4);

        } else if (profileSwitch.getText().equals("WYŁ.")) {
            profileSwitch.click();
            List<WebElement> registerFieldsB2B = driver.findElements(By.className("android.widget.EditText"));
            registerFieldsB2B.get(0).sendKeys(nameAndSurname);
            registerFieldsB2B.get(1).sendKeys(nip);
            registerFieldsB2B.get(2).sendKeys(email);
            registerFieldsB2B.get(3).sendKeys(phoneNumber);
            registerFieldsB2B.get(4).sendKeys(password);
            ScrollDown();
            sendB2bButton.click();
            Thread.sleep(3000);
            List<WebElement> errorTextElements = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/editWithIconErrorText"));
            Assert.assertEquals(errorTextElements.get(0).getText(), errorText0);
            Assert.assertEquals(errorTextElements.get(1).getText(), errorText1);
            Assert.assertEquals(errorTextElements.get(2).getText(), errorText2);
            Assert.assertEquals(errorTextElements.get(3).getText(), errorText3);
            Assert.assertEquals(errorTextElements.get(4).getText(), errorText4);
        }
        return this;
    }

    @Step
    public RegisterPageB2B markFirstAgreementB2B() {
        ScrollDown();
        firstAgreementCheckboxB2B.click();
        sendB2bButton.click();
        return this;
    }

    @Step
    public RegisterPageB2B markSecondAgreementB2B() throws InterruptedException, TesseractException, IOException {
        ScrollDown();
        secondAgreementCheckboxB2B.click();
        sendB2bButton.click();
        Thread.sleep(3000);
        String toastMessage = readToastMessage();
        String toastText = "Zaznaczenie pierwszej zgody";
        Assert.assertTrue((toastMessage).contains(toastText));
        return this;
    }

    @Step
    public RegisterPageB2B markThirdAgreementB2B() throws InterruptedException, TesseractException, IOException {
        ScrollDown();
        thirdAgreementCheckboxB2B.click();
        sendB2bButton.click();
        Thread.sleep(3000);
        String toastMessage = readToastMessage();
        String toastText = "Zaznaczenie pierwszej zgody";
        Assert.assertTrue((toastMessage).contains(toastText));
        return this;
    }

    @Step
    public RegisterPageB2B markFirstAndSecondAgreementsB2B() {
        ScrollDown();
        firstAgreementCheckboxB2B.click();
        secondAgreementCheckboxB2B.click();
        sendB2bButton.click();
        return this;
    }

    public RegisterPageB2B markFirstAndThirdAgreementsB2B() {
        ScrollDown();
        firstAgreementCheckboxB2B.click();
        secondAgreementCheckboxB2B.click();
        sendB2bButton.click();
        return this;
    }

    @Step
    public RegisterPageB2B setExistingEmailB2B () throws InterruptedException, TesseractException {
        Faker plFaker = new Faker(new Locale("pl"));
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("pl"), new RandomService());
        String email = "jarsar888@gmail.com";
        String password = fakeValuesService.regexify("[a-z1-9]{10}");
        String nameAndSurname = plFaker.name().fullName();
        String phoneNumber = "508264455";
        waitForVisibilityOfElement(profileSwitch);

        if (profileSwitch.getText().equals("WŁ.")) {
            List<WebElement> registerFieldsB2B = driver.findElements(By.className("android.widget.EditText"));
            registerFieldsB2B.get(0).sendKeys(nameAndSurname);
            registerFieldsB2B.get(1).sendKeys(GetNIP.generateNIP());
            registerFieldsB2B.get(2).sendKeys(email);
            registerFieldsB2B.get(3).sendKeys(phoneNumber);
            registerFieldsB2B.get(4).sendKeys(password);

        } else if (profileSwitch.getText().equals("WYŁ.")) {
            profileSwitch.click();
            List<WebElement> registerFieldsB2B = driver.findElements(By.className("android.widget.EditText"));
            registerFieldsB2B.get(0).sendKeys(nameAndSurname);
            registerFieldsB2B.get(1).sendKeys(GetNIP.generateNIP());
            registerFieldsB2B.get(2).sendKeys(email);
            registerFieldsB2B.get(3).sendKeys(phoneNumber);
            registerFieldsB2B.get(4).sendKeys(password);
        }
        firstAgreementCheckboxB2B.click();
        ScrollDown();
        sendB2bButton.click();
        Thread.sleep(3000);
        String toastMessage = readToastMessage();
        String toastText = "Btedne dane w polach: email is already used";
        Assert.assertTrue((toastMessage).contains(toastText));
        Assert.assertTrue(registerPageHeader.isDisplayed());
        return this;
    }


}

