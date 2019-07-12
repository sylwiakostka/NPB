package iTaxiPassanger.utilities;


import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.codearte.jfairy.Fairy;

import io.codearte.jfairy.producer.person.Person;

import java.util.Locale;

public class classToVerifyMethodsTest {

    public static void main(String[] args) {

//        Fairy plFairy = Fairy.create(Locale.forLanguageTag("pl"));
//        Person person = plFairy.person();
//        System.out.println(person.email());
//
//
//        Faker plFaker = new Faker(new Locale("pl"));
//        String city = plFaker.address().cityName();
//        String street = plFaker.address().streetName();
//        String nameAndSurname = plFaker.name().fullName();
//
//
//        FakeValuesService fakeValuesService = new FakeValuesService(
//                new Locale("pl"), new RandomService());
//        String email = fakeValuesService.bothify("????##@xyz.xyz");
//        String alphaNumericString = fakeValuesService.regexify("[a-z1-9]{10}");
//
//        System.out.println(email + " " + alphaNumericString + " " + nameAndSurname);

        String text = "01234";
//        String splitedFirstPart = text.split("to")[1].trim();
//        System.out.println(splitedFirstPart);
//        String splittedSecondPart = splitedFirstPart.split(". K")[0];
        String digit1 = text.substring(0,1);
        String digit2 = text.substring(1,2);
        String digit3 = text.substring(2,3);
        String digit4 = text.substring(3,4);

        System.out.println(digit1);
        System.out.println(digit2);
        System.out.println(digit3);
        System.out.println(digit4);

    }
}