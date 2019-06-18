package MobileSittings.sauceLabsMobile;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogInTestMobile extends TestConfigMobile {


    @Test
    public void openPage() {
        String startUrl = "https://taxi.demo.eo.pl/taxi-business-client-web/login.html";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(startUrl);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("loginForm"))));
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("sylwia");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456789");
        driver.findElement(By.tagName("button")).click();
    }
}
