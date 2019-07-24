package iTaxiPassanger.utilities;

import iTaxiPassanger.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ChooseCorrectDigitOnKeyboard extends BasePage {

    public ChooseCorrectDigitOnKeyboard(AndroidDriver driver) {
        super(driver);
    }

    public static void chooseCorrectDigit (String numberOfCode){

        switch (numberOfCode) {
            case "0":
                if (numberOfCode.equals("0")) {
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));
                }
                break;

            case "1":
                if (numberOfCode.equals("1")) {
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
                }
                break;

            case "2":
                if (numberOfCode.equals("2")) {
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2));
                }
                break;
            case "3":
                if (numberOfCode.equals("3")) {
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3));
                }
                break;
            case "4":
                if (numberOfCode.equals("4")) {
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4));
                }
                break;
            case "5":
                if (numberOfCode.equals("5")) {
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5));
                }
                break;

            case "6":
                if (numberOfCode.equals("6")) {
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6));
                }
                break;

            case "7":
                if (numberOfCode.equals("7")) {
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7));
                }
                break;

            case "8":
                if (numberOfCode.equals("8")) {
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8));
                }
                break;
            case "9":
                if (numberOfCode.equals("9")) {
                    driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9));
                }
                break;
        }
    }
}
