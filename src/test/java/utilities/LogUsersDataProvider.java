package utilities;

import org.testng.annotations.DataProvider;

public class LogUsersDataProvider {

    @DataProvider(name = "correctData")
    public Object[][] correctData() {
        return new Object[][]{{"sylwi", "123456789"}};
    }

    @DataProvider(name = "incorrectData")
    public Object[][] incorrectData() {
        return new Object[][]{
                {"", "", "Niepoprawny login/hasło."},
                {"sylwia", "123", "Niepoprawny login/hasło."},
                {"ada", "123456789", "Niepoprawny login/hasło."},
                {"sylwia", "", "Niepoprawny login/hasło."},
                {"", "123456789", "Niepoprawny login/hasło."}};

    }
}
