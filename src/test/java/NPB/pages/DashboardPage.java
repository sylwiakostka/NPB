package NPB.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    @Step
    public void verify_dashboardPge_for_employee() {
        waitForVisibilityOfElement(dashboardSection);
        waitForVisibilityOfElement(orderTaxiSection);
        waitForVisibilityOfElement(menuSection);

        List<String> expectedTexts = Arrays.asList("Dashboard", "Zamów taksówkę", "Zamówione taksówki", "Raporty i faktury", "Ustawienia");
        List<String> actualTexts = new ArrayList<>();

        List<WebElement> menuButtonList = driver.findElements(By.xpath("//ul[@class='nav-items']//li"));
        for (WebElement element : menuButtonList) {
            actualTexts.add(element.getText());
        }
        Assert.assertEquals(expectedTexts.toString(), actualTexts.toString());
        System.out.println(expectedTexts.toString() + " " + actualTexts.toString());
    }


    @Step
    public void verify_dashboardPge_for_admin() {
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
    }
}

