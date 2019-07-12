package iTaxiPassanger.utilities;

import org.testng.annotations.DataProvider;


public class CreditCardDataProvider {

    @DataProvider(name = "CorrectCreditCard")
    public Object[][] correctCreditCard() {
        return new Object[][]{
                {"378282246310005", "072021", "1234"}};
    }

    @DataProvider(name = "IncorrectCreditCard")
    public Object[][] incorrectCreditCard() {
        return new Object[][]{
                {"5555555555554440", "112020", "123"},
                {"4000111111111114", "112021", "456"}};
    }
}
