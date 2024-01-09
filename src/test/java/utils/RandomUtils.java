package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class RandomUtils {

    Faker faker = new Faker(Locale.US);
    final String[] genders = new String[] {"Male", "Female", "Other"},
                     subjects = new String[] {"Maths", "Arts", "Biology"},
                     hobbies = new String[] {"Sports", "Reading", "Music"},
                     pictures = new String[] {"1.png", "2.png", "3.png"};
    final Date birthDate = faker.date().birthday(0, 120);

    final Map<String, String[]> states = new HashMap<>();{
        states.put("NCR", (new String[]{"Delhi", "Gurgaon", "Noida"}));
        states.put("Uttar Pradesh", (new String[]{"Agra", "Lucknow", "Merrut"}));
        states.put("Haryana", (new String[]{"Karnal", "Panipat"}));
        states.put("Rajasthan", (new String[]{"Jaipur", "Jaiselmer"}));
    }

    public String firstName = faker.name().firstName(),
      lastName = faker.name().lastName(),
      email = faker.internet().emailAddress(),
      gender = getRandomGender(),
      phoneNumber = faker.phoneNumber().subscriberNumber(10),
      bYear = dateFormat("yyyy", birthDate),
      bMonth = dateFormat("MMMM", birthDate),
      bDay = dateFormat("dd", birthDate),
      subject = getRandomSubject(),
      hobby = getRandomHobbies(),
      picture = getRandomPicture(),
      address = faker.address().streetAddress(),
      chooseState = getRandomStates(),
      chooseCity = getRandomStateCities(chooseState);


    private String dateFormat(String pattern, Date date) {
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern, Locale.ENGLISH);
        return simpleDate.format(date);
    }

    public  String getRandomGender() {
       return faker.options().option(genders);

    }

    public  String getRandomSubject() {
        return faker.options().option(subjects);

    }

    public  String getRandomHobbies() {
        return faker.options().option(hobbies);

    }

    public  String getRandomPicture() {
        return faker.options().option(pictures);

    }
    public String getRandomStates(){

        return faker.options().option(states.keySet().toArray()).toString();

    }
    public String getRandomStateCities(String state){
        return faker.options().option(states.get(state));
    }

}

