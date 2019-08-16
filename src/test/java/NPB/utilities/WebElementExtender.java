package NPB.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

public class WebElementExtender {

    public static void setAttribute(WebElement element, String attributeName, String value) {
        WrapsDriver wrappedElement = (WrapsDriver) element;
        JavascriptExecutor js=(JavascriptExecutor)wrappedElement.getWrappedDriver();
        js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])", element,attributeName,value);
    }
}
