package iTaxiPassanger.pages;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class OrderDetailsPage extends BasePage {

    public OrderDetailsPage(AndroidDriver driver) {
        super(driver);

    }

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiMapOrder")
    private WebElement firstOrderButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/confirmTime")
    private WebElement setTimeButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/hour")
    private WebElement hourScroll;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/minutes")
    private WebElement minuteScroll;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/dialogButtonRight")
    private WebElement confirmTimeButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/day_of_week")
    private WebElement dayScroll;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/taxiCategoryLux")
    private WebElement luxuryTaxiButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/confirmExtraCharge")
    private WebElement extraChargeConfirm;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/confirmSelectTaxiIcon")
    private WebElement chooseFromListButton;

    @FindBy(id = "com.geckolab.eotaxi.passenger.demo:id/mainMessageEmptyPicker")
    private WebElement messageTaxiListEmpty;

    @FindBy(id = "android:id/parentPanel")
    private WebElement comfirmTaxiFromListMessage;

    @FindBy(id = "android:id/button1")
    private WebElement confirmTaxiFromListButton;



    @Step
    public OrderDetailsPage makeBeReadyToOrder() {
        new SplashPage(driver).allowPermision().verifyMainScreen().goToLogInPage().verifyLogInPageHeader().logAsB2CUser("wasmarc12@gmail.com", "was1234");
        firstOrderButton.click();
        return this;
    }

    @Step
    public OrderDetailsPage addHours(int numberOfHours) {
        waitForVisibilityOfElement(setTimeButton);
        setTimeButton.click();
        waitForVisibilityOfElement(hourScroll);

        int leftX = hourScroll.getLocation().getX();
        int rightX = leftX + hourScroll.getSize().getWidth();
        int middleX = (leftX + rightX) / 2;
        int upperY = hourScroll.getLocation().getY();
        int lowerY = upperY + hourScroll.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        for (int i = 0; i < numberOfHours; i++) {
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(middleX, middleY)).moveTo(PointOption.point(middleX, upperY)).release().perform();
        }
        confirmTimeButton.click();
        return this;
    }

    @Step
    public OrderDetailsPage addMinutes(int numberOfScrollsMinutes) {
        waitForVisibilityOfElement(setTimeButton);
        setTimeButton.click();
        waitForVisibilityOfElement(minuteScroll);
        int leftX = minuteScroll.getLocation().getX();
        int rightX = leftX + minuteScroll.getSize().getWidth();
        int middleX = (leftX + rightX) / 2;
        int upperY = minuteScroll.getLocation().getY();
        int lowerY = upperY + minuteScroll.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;
        for (int i = 0; i < numberOfScrollsMinutes; i++) {
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(middleX, middleY)).moveTo(PointOption.point(middleX, upperY)).release().perform();
        }
        confirmTimeButton.click();
        return this;
    }

    @Step
    public OrderDetailsPage addDay(int numberOfDays) {
        waitForVisibilityOfElement(setTimeButton);
        setTimeButton.click();
        waitForVisibilityOfElement(dayScroll);
        int leftX = dayScroll.getLocation().getX();
        int rightX = leftX + dayScroll.getSize().getWidth();
        int middleX = (leftX + rightX) / 2;
        int upperY = dayScroll.getLocation().getY();
        int lowerY = upperY + dayScroll.getSize().getHeight();
        int middleY = (upperY + lowerY) / 2;

        for (int i = 0; i < numberOfDays; i++) {
            TouchAction action = new TouchAction(driver);
            action.press(PointOption.point(middleX, middleY)).moveTo(PointOption.point(middleX, upperY)).release().perform();
        }
        confirmTimeButton.click();
        return this;
    }

    @Step
    public OrderDetailsPage setTimeIn30Minutes() {
        waitForVisibilityOfElement(setTimeButton);
        setTimeButton.click();
        confirmTimeButton.click();
        return this;
    }

    @Step
    public OrderDetailsPage verifyIsFutureOrderSet() {
        waitForVisibilityOfElement(setTimeButton);
        String timeOfOrder = setTimeButton.getAttribute("text");
        Assert.assertFalse(timeOfOrder.equals("Na teraz"));
        return this;
    }

    @Step
    public OrderDetailsPage setLuxuryTaxi() {
        waitForVisibilityOfElement(luxuryTaxiButton);
        luxuryTaxiButton.click();
        Assert.assertTrue(extraChargeConfirm.isDisplayed());
        Assert.assertEquals(extraChargeConfirm.getText(), "Taksówka Luksusowa: dopłata 40,00 zł");
        return this;
    }

    @Step
    public OrderDetailsPage chooseTaxiFromList() throws InterruptedException {
        Thread.sleep(5000);
        waitForVisibilityOfElement(chooseFromListButton);
        chooseFromListButton.click();
        List<WebElement> taxiList = driver.findElements(By.id("com.geckolab.eotaxi.passenger.demo:id/rowTaxiDetails"));
        if (taxiList.size() > 0) {
            taxiList.get(0).click();
            waitForVisibilityOfElement(comfirmTaxiFromListMessage);
            confirmTaxiFromListButton.click();
        } else {
            Assert.assertEquals("W okolicy nie mamy wolnych taksówek, spełniających wymagania", messageTaxiListEmpty.getText());
        driver.findElement(By.id("com.geckolab.eotaxi.passenger.demo:id/headerBackIconLeft")).click();}

        return this;
    }
}