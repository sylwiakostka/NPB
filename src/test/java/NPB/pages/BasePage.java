package NPB.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        PageFactory.initElements(driver, this);
    }
    private static final int WAIT_TIMEOUT = 10;

    protected void waitForVisibilityOfElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    protected void waitForPresenceOfElement (WebElement element) {
        WebElement element1 = wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                return element;
            }
        });
    }

    protected void waitForPresenceOfElements (List<WebElement> elements) {
        List<WebElement> elements1 = wait.until(new ExpectedCondition<List<WebElement>>() {
            public List<WebElement> apply(WebDriver d) {
                return elements;
            }
        });
    }

}
