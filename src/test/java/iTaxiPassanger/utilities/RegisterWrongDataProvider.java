package iTaxiPassanger.utilities;

import org.testng.annotations.DataProvider;

public class RegisterWrongDataProvider {

    @DataProvider(name = "incorrectDataRegisterB2C")
    public Object[][] incorrectDataRegisterB2C() {
        return new Object[][]{
                {"aa", "Błąd w imieniu i nazwisku", "aa", "W adresie zauważyliśmy błąd", "55", "Numer telefonu jest niepoprawny", "44", "Nieprawidłowa długość pola"}};
    }

    @DataProvider(name = "incorrectDataRegisterB2B")
    public Object[][] incorrectDataRegisterB2B() {
        return new Object[][]{
                {"aa", "Błąd w imieniu i nazwisku", "555", "Nieprawidłowy numer NIP", "aa", "W adresie zauważyliśmy błąd", "55", "Numer telefonu jest niepoprawny", "44", "Nieprawidłowa długość pola"}};
    }
}
