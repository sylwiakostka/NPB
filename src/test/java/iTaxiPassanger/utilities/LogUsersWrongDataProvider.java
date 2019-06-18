package iTaxiPassanger.utilities;

import org.testng.annotations.DataProvider;

public class LogUsersWrongDataProvider {

    @DataProvider(name = "incorrectDataLogInB2C")
    public Object[][] incorrectDataLogInB2C() {
        return new Object[][]{
                {"", "",},
                {"sara@gmai.com", "sara1234"},
                {"sara@gmail.com", "sara123"},
                {"sara@gmail.com", ""},
                {"", "sara1234"}};
    }


    @DataProvider(name = "incorrectDataLogInB2B")
    public Object[][] incorrectDataLogInB2B() {
        return new Object[][]{
                {"", "",},
                {"jarsar888@gmai.com", "1234"},
                {"jarsar888@gmail.com", "123"},
                {"jarsar888@gmail.com", ""},
                {"","1234"}};
    }
}
