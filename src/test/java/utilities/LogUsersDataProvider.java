package utilities;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.DataProvider;

import java.util.LinkedList;
import java.util.List;

public class LogUsersDataProvider {

    @DataProvider(name = "correctData")
    public Object[][] correctDataLogIn() {
        return new Object[][]{{"sylwia", "123456789"}};
    }

    @DataProvider(name = "incorrectData")
    public Object[][] incorrectDataLogIn() {
        return new Object[][]{
                {"", "", "Niepoprawny login/hasło."},
                {"sylwia", "123", "Niepoprawny login/hasło."},
                {"ada", "123456789", "Niepoprawny login/hasło."},
                {"sylwia", "", "Niepoprawny login/hasło."},
                {"", "123456789", "Niepoprawny login/hasło."}};
    }


    @DataProvider(name = "incorrectCompanyName")
    public Object[][] incorrectCompanyName() {
        return new Object[][]{
                {""},
                {"qwe"}
        };
    }

    @DataProvider(name = "correctCompanyName")
    public Object[][] correctCompanyName() {
        return new Object[][]{{"ABC"}};
    }
    
    
    @DataProvider (name ="combineCorrectDataLogInAndWrongCompanyName")
    public Object [][] combineCorrectDataLogInAndWrongCompanyName (){
        return combine (correctDataLogIn(), incorrectCompanyName());
    }

    @DataProvider (name = "combineCorrectDataLogInAndCorrectCompanyName")
    public Object [][] combineCorrectDataLogInAndCorrectCompanyName (){
        return combine(correctDataLogIn(), correctCompanyName());
    }

    private Object[][] combine(Object[][] objects1, Object[][] objects2) {
        List<Object[]> objectCodesList = new LinkedList<>();
        for(Object[] o1 : objects1){
            for(Object[] o2 : objects2){
                objectCodesList.add(concatAll(o1, o2));
            }
        }
        return objectCodesList.toArray(new Object[0][0]);
    }

    private Object[] concatAll(Object[] o, Object[] o2) {
        return ArrayUtils.addAll(o, o2);
    }

}
 