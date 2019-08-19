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

public class ProfilesPage extends BasePage {
    public ProfilesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='-totalPages']")
    private WebElement totalPagesCount;

    @FindBy(xpath = "//h3[contains(.,'Zarządzanie profilami - firma')]")
    private WebElement profilesHeader;

    @FindBy(xpath = "//button[.='Następna']")
    private WebElement nextPageButton;

    @FindBy(xpath = "//button[.='Poprzednia']")
    private WebElement backPageButton;


    @Step
    public ProfilesPage verify_profilesPage() throws InterruptedException {
        Thread.sleep(3000);
        waitForPresenceOfElement(profilesHeader);
        Assert.assertTrue(profilesHeader.getText().contains("Zarządzanie profilami - firma "));
        return this;
    }

    @Step
    public ProfilesPage verify_profiles_tab_header_names() {

        List<String> expectedTexts = Arrays.asList("Nazwa", "Limit godzinowy", "Dni tygodnia", "Limit ilościowy", "Limit kwotowy", "Alert gdy zostało mniej niż", "Maksymalna taryfa", "Liczba użytkowników", "Klasa samochodu", "Opcje");
        List<String> actualTexts = new ArrayList<>();

        List<WebElement> listOfHeaderNames = driver.findElements(By.xpath("//div[@class='rt-thead -header']//div[@role='row']/descendant::div[@class='rt-resizable-header-content']"));
        for (WebElement header : listOfHeaderNames) {
            System.out.println(header.getText());
            actualTexts.add(header.getText());
        }

        System.out.println("expected: "+ expectedTexts.toString() + " " + "actual: "+actualTexts.toString());
        Assert.assertEquals(actualTexts.toString(), expectedTexts.toString());

        return this;
    }

    @Step
    public ProfilesPage verify_if_next_and_back_buttons_are_active_and_clickable() throws InterruptedException {
        Thread.sleep(2000);
        int pageCount = Integer.parseInt(totalPagesCount.getText());
        System.out.println(pageCount);
        if (pageCount > 1) {
            Assert.assertTrue(nextPageButton.isEnabled());
            Assert.assertFalse(backPageButton.isEnabled());
            nextPageButton.click();
            Assert.assertTrue(backPageButton.isEnabled());
            Assert.assertFalse(nextPageButton.isEnabled());
            backPageButton.click();
        } else {
            Assert.assertFalse(nextPageButton.isEnabled());
            Assert.assertFalse(backPageButton.isEnabled());
        }
        return this;
    }

}
