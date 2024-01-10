package data;

import utils.RandomUtils;

public class RegistrationData {
    private final RandomUtils random = new RandomUtils();

    public String firstName = random.firstName,
            lastName = random.lastName,
            email = random.email,
            gender = random.gender,
            phoneNumber = random.phoneNumber,
            bDay = random.bDay,
            bMonth = random.bMonth,
            bYear = random.bYear,
            subject = random.subject,
            hobby = random.hobby,
            picture = random.picture,
            address = random.address,
            chooseState = random.chooseState,
            chooseCity = random.chooseCity;

}
