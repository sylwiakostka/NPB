package NPB.pages;

import NPB.utilities.CaptureScreenshotOfElement;
import NPB.utilities.CompareScreenshots;
import iTaxiPassanger.utilities.CaptureElementPicture;
import iTaxiPassanger.utilities.CompareScreens;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(className = "dashboard")
    private WebElement dashboardSection;

    @FindBy(xpath = "//h3[.='Zamawiam taksówkę:']")
    private WebElement orderTaxiSection;

    @FindBy(className = "nav-items")
    private WebElement menuSection;

    @FindBy(xpath = "//div[@class='profile-open']")
    private WebElement profileAccount;

    @FindBy(xpath = "//button[@class='btn transparent small']//span[.='Wyloguj']")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[@class='box-inner']//a[@href='/order']")
    private WebElement orderForEmployeeButton;

    @FindBy(xpath = "//div[@class='box-inner']//a[@href='/order/guest']")
    private WebElement orderForGuestButton;

    @FindBy(xpath = "//span[@class='company']")
    private WebElement companyName;

    @FindBy(xpath = "//a[@href='/manage']//span[.='Zarządzanie']")
    private WebElement manageButton;


    @Step
    public DashboardPage verify_dashboardPge_for_employee(String businessPartnerName) {
        waitForVisibilityOfElement(dashboardSection);
        waitForVisibilityOfElement(orderTaxiSection);
        waitForVisibilityOfElement(menuSection);

        List<String> expectedTexts = Arrays.asList("Dashboard", "Zamów taksówkę", "Zamówione taksówki", "Raporty i faktury", "Ustawienia");
        List<String> actualTexts = new ArrayList<>();

        List<WebElement> menuButtonList = driver.findElements(By.xpath("//ul[@class='nav-items']//li"));
        waitForPresenceOfElements(menuButtonList);
        for (WebElement element : menuButtonList) {
            actualTexts.add(element.getText());
        }
        Assert.assertEquals(expectedTexts.toString(), actualTexts.toString());
        System.out.println(expectedTexts.toString() + " " + actualTexts.toString());

        Assert.assertTrue(orderForEmployeeButton.isDisplayed());
        Assert.assertTrue(orderForGuestButton.isDisplayed());
        Assert.assertEquals(orderForEmployeeButton.getText(), "DLA PRACOWNIKÓW");
        Assert.assertEquals(orderForGuestButton.getText(), "DLA GOŚCI");

        Assert.assertTrue(companyName.isDisplayed());
        Assert.assertEquals(companyName.getText(), businessPartnerName);

        return this;
    }


    @Step
    public DashboardPage verify_dashboardPge_for_admin(String businessPartnerName) {
        waitForVisibilityOfElement(dashboardSection);
        waitForVisibilityOfElement(orderTaxiSection);
        waitForVisibilityOfElement(menuSection);

        List<String> expectedTexts = Arrays.asList("Dashboard", "Zamów taksówkę", "Zamówione taksówki", "Raporty i faktury", "Zarządzanie", "Użytkownicy", "Ustawienia");
        List<String> actualTexts = new ArrayList<>();

        List<WebElement> menuButtonList = driver.findElements(By.xpath("//ul[@class='nav-items']//li"));
        for (WebElement element : menuButtonList) {
            actualTexts.add(element.getText());
        }
        Assert.assertEquals(expectedTexts.toString(), actualTexts.toString());
        System.out.println(expectedTexts.toString() + " " + actualTexts.toString());

        Assert.assertTrue(orderForEmployeeButton.isDisplayed());
        Assert.assertTrue(orderForGuestButton.isDisplayed());
        Assert.assertEquals(orderForEmployeeButton.getText(), "DLA PRACOWNIKÓW");
        Assert.assertEquals(orderForGuestButton.getText(), "DLA GOŚCI");

        Assert.assertTrue(companyName.isDisplayed());
        Assert.assertEquals(companyName.getText(), businessPartnerName);


        return this;
    }

    @Step
    public void logout() {
        WebElement header_logo = driver.findElement(By.xpath("//div[@class='header-logo']"));
        header_logo.click();
        profileAccount.click();
        waitForPresenceOfElement(logoutButton);
        logoutButton.click();
        new LoginPage(driver).verify_loginPage();
    }

    @Step
    public MpkPage go_to_MpkPage() {
        waitForPresenceOfElement(manageButton);
        waitForElementToBeClickable(manageButton);
        manageButton.click();
        return new MpkPage(driver);
    }
}

