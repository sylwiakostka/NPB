package iTaxiPassanger.utilities;

import iTaxiPassanger.tests.BaseTests;
import io.appium.java_client.android.Activity;


public class ReadSMS extends BaseTests {

    public String readSMS() {
//        Activity activity = new Activity("com.android.mms", "com.android.mms.ui.MmsTabActivity");
//        activity.setAppWaitPackage("com.android.mms");
//        activity.setAppWaitActivity("com.android.mms.ui.MmsTabActivity");
//        driver.startActivity(activity);
        String codeFromSMS = driver.findElementById("com.android.mms:id/subject").getText().substring(24, 28);
        return codeFromSMS;
    }
}

