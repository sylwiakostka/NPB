package NPB.pages;

import NPB.utilities.WebTable;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MpkPage extends BasePage {
    public MpkPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='btn small violet']//span[.='Dodaj']")
    private WebElement addMpkButton;

    @FindBy(xpath = "//div[@class='inputs']//h3[.='Dodaj']")
    private WebElement addMpkForm;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "amountLimitGr")
    private WebElement maxAmountField;

    @FindBy(id = "alertLimitGr")
    private WebElement alertAmountField;

    @FindBy(id = "comment")
    private WebElement commentField;

    @FindBy(id = "button")
    private WebElement saveMpkButton;

    @FindBy(xpath = "//div[@class='notification green notification-enter-done']//p[.='Pomyślnie dodano']")
    private WebElement notificationSucessfullAdded;

    @FindBy(tagName = "h3")
    private WebElement mpkHeader;

    @FindBy(xpath = "//div[@class='tabs']//a[@href='/manage/mpk']")
    private WebElement mpkButtonHeader;

    @FindBy(xpath = "//div[@class='tabs']//a[@href='/manage/profiles']")
    private WebElement profilesButtonHeader;

    @FindBy(xpath = "//div[@class='tabs']//a[@href='/manage/projects']")
    private WebElement projectsButtonHeader;

    @FindBy(xpath = "//div[@class='tabs']//a[@href='/manage/offices']")
    private WebElement officesButtonHeader;

    @FindBy(xpath = "//div[@class='notification red notification-enter-done']//p[.='Brak nazwy departamentu']")
    private WebElement notificationNoMpkName;

    @FindBy (xpath = "//div[@class='inputs delete']")
    private WebElement deleteMpkConfirmSection;

    @FindBy (xpath = "//button[@id='button']//span[.='Usuń']")
    private WebElement deleteMpkConfirmButton;



    @Step
    public MpkPage verify_MpkPage() throws InterruptedException {
        Thread.sleep(3000);
        waitForPresenceOfElement(mpkHeader);
        waitForPresenceOfElement(mpkButtonHeader);
        waitForPresenceOfElement(profilesButtonHeader);
        waitForPresenceOfElement(profilesButtonHeader);
        waitForPresenceOfElement(officesButtonHeader);
        Assert.assertTrue(mpkHeader.getText().contains("Zarządzanie MPK - firma "));
        Assert.assertEquals(mpkButtonHeader.getText(), "MPK");
        Assert.assertEquals(profilesButtonHeader.getText(), "Profile");
        Assert.assertEquals(projectsButtonHeader.getText(), "Projekty");
        Assert.assertEquals(officesButtonHeader.getText(), "Firma");
        return this;
    }

    @Step
    public MpkPage add_new_mpk(String mpkName, String maxAmount, String alertAmount, String comment) {
        waitForPresenceOfElement(addMpkButton);
        addMpkButton.click();
        waitForPresenceOfElement(addMpkForm);
        nameField.sendKeys(mpkName);
        maxAmountField.sendKeys(maxAmount);
        alertAmountField.sendKeys(alertAmount);
        commentField.sendKeys(comment);
        saveMpkButton.click();
        waitForPresenceOfElement(notificationSucessfullAdded);
        Assert.assertEquals(notificationSucessfullAdded.getText(), "Pomyślnie dodano");
        return this;
    }

    @Step
    public MpkPage verify_is_mpk_added(String mpkName, String maxAmount, String alertAmount, String comment) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td']"));
        for (WebElement row : rows) {
            if (row.getText().equals(mpkName)) {
                WebElement maxAmountRow = row.findElement(By.xpath("./following-sibling::div[1]"));
                WebElement alertRow = row.findElement(By.xpath("./following-sibling::div[3]"));
                WebElement commentRow = row.findElement(By.xpath("./following-sibling::div[4]"));
                WebElement optionsRow = row.findElement(By.xpath("./following-sibling::div[5]"));

                Assert.assertEquals(row.getText(), mpkName);
                Assert.assertEquals(maxAmountRow.getText(), maxAmount);
                Assert.assertEquals(alertRow.getText(), alertAmount);
                Assert.assertEquals(commentRow.getText(), comment);
                Assert.assertTrue(optionsRow.getText().contains("Edytuj"));
                Assert.assertTrue(optionsRow.getText().contains("Usuń"));
                Assert.assertFalse(optionsRow.getText().contains("Aktywuj"));
            }
        }
        return this;
    }

    @Step
    public MpkPage cant_add_mpk_without_data() throws InterruptedException {
        waitForPresenceOfElement(addMpkButton);
        addMpkButton.click();
        waitForPresenceOfElement(addMpkForm);
        saveMpkButton.click();
        waitForPresenceOfElement(notificationNoMpkName);
        Assert.assertEquals(notificationNoMpkName.getText(), "Brak nazwy departamentu");
        return this;
    }

    @Step
    public MpkPage choose_appropriate_mpk_without_users_and_click_delete(String mpkName) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr -even']//div[@class='rt-td']"));
        for (WebElement row : rows) {
            if (row.getAttribute("text-content").equals(mpkName)) {
                System.out.println(row.getAttribute("text-content"));
                WebElement optionsRow = row.findElement(By.xpath("./following-sibling::div[5]"));
                WebElement deleteButton = optionsRow.findElement(By.xpath("//div[@class='options']//span[.='Usuń']"));
                deleteButton.click();
            }
            System.out.println(deleteMpkConfirmSection.getText());

        }
        return this;
    }







    @Step
    public MpkPage edit_mpk(String mpkName) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td']"));
        for (WebElement row : rows) {
            if (row.getText().equals(mpkName)) {
                WebElement optionsRow = row.findElement(By.xpath("./following-sibling::div[5]"));
                WebElement editButton = optionsRow.findElement(By.xpath("//div[@class='options']//span[.='Edytuj']"));
                editButton.click();
            }
        }

        return this;
    }


}





