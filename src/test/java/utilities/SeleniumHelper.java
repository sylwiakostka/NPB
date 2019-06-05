package utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class SeleniumHelper {

    private static WebDriver driver;

    public SeleniumHelper(WebDriver driver) {
        this.driver = driver;
    }


    static final int WAIT_TIMEOUT = 10;
    private static WebDriverWait wait = new WebDriverWait(driver, WAIT_TIMEOUT);

    public static void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
}

