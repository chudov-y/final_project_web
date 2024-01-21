package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import data.RegistrationData;
import io.qameta.allure.Step;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final CalendarComponent calendar = new CalendarComponent();
    private final SelenideElement titleLabel =  $(".practice-form-wrapper"),
                    firstNameInput =  $("#firstName"),
                    lastNameInput =  $("#lastName"),
                    userEmailInput = $("#userEmail"),
                    gender =  $("#genterWrapper"),
                    phoneNumberInput = $("#userNumber"),
                    subjectInput = $("#subjectsInput"),
                    hobbiesWrapper = $("#hobbiesWrapper"),
                    uploadPicture = $("#uploadPicture"),
                    currentAddressInput = $("#currentAddress"),
                    stateCity =  $("#stateCity-wrapper");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        titleLabel.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    @Step("Set first name")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    @Step("Set last name")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    @Step("Set email")
    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    @Step("Set gender")
    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }
    @Step("Set user number")
    public RegistrationPage setUserNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }
    @Step("Set date of Birth")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }
    @Step("Set Subject")
    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();

        return this;
    }
    @Step("Set hobbies")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Upload picture")
    public RegistrationPage uploadPicture(String fileName) {
        if (!Configuration.browser.equalsIgnoreCase("firefox")) {
            uploadPicture.uploadFromClasspath(fileName);
        }

        return this;
    }
    @Step("Set address")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    @Step("Set state")
    public RegistrationPage setState(String state) {
        $("#state").click();
        stateCity.$(byText(state)).click();

        return this;
    }
    @Step("Set city")
    public RegistrationPage setCity(String city) {
        $("#city").click();
       stateCity.$(byText(city)).click();

        return this;
    }

    public void submit(){
        $("#submit").click();
    }
}
