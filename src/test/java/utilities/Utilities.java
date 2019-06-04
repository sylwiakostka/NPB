package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utilities {

    static final int WAIT_TIMEOUT = 10;
    WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);

    @Step
    public void waitForVisiblityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


        

}
