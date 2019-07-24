package iTaxiPassanger.utilities;

import iTaxiPassanger.tests.BaseTests;
import io.appium.java_client.android.Activity;


public class ReadSMS extends BaseTests {

    public String readSMS() {
        String codeFromSMS = driver.findElementById("com.android.mms:id/subject").getText().substring(24, 28);
        return codeFromSMS;
    }
}

