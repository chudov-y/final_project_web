package tests;

import data.RegistrationData;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalDialogComponent;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("chudov-y")
@Epic(value = "Demo QA")
@Feature(value = "Practice Form")
@Story(value = "Fill out a form")
@Tag("ui")


public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    private final RegistrationData data = new RegistrationData();
    ModalDialogComponent modalDialog = new ModalDialogComponent();


    @Severity(NORMAL)
    @DisplayName("Fill registration form with all fields")
    @Description("Fill registration form with all fields")
    @Test
    void successfulRegistrationTest() {
        step("Open form", () -> {
        registrationPage.openPage();});

        step("Fill form", () -> {
            registrationPage.setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .setGender(data.gender)
                .setUserNumber(data.phoneNumber)
                .setDateOfBirth(data.bDay, data.bMonth, data.bYear)
                .setSubject(data.subject)
                .setHobbies(data.hobby)
                .uploadPicture(data.picture)
                .setCurrentAddress(data.address)
                .setState(data.chooseState)
                .setCity(data.chooseCity)
                .submit();});


        step("Verify Form", () -> {
        modalDialog.checkWindow();

        modalDialog.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phoneNumber)
                .checkResult("Date of Birth", data.bDay + " " + data.bMonth+ "," + data.bYear)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobby)
                .checkResult("Picture", data.picture)
                .checkResult("Address", data.address)
                .checkResult("State and City", data.chooseState + " " + data.chooseCity);});

    }

    @Severity(NORMAL)
    @DisplayName("Fill registration form with only required fields")
    @Test
    void requiredFieldsTest(){

        step("Open form", () -> {
        registrationPage.openPage();});

        step("Fill form", () -> {
            registrationPage.setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setUserNumber(data.phoneNumber)
                .submit();});

        step("Verify Form", () -> {
        modalDialog.checkWindow();

        modalDialog.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.phoneNumber);});
    }

    @Severity(NORMAL)
    @DisplayName("Fill registration form with empty fields")
    @Test
    void emptyFieldsTest() {
        step("Open form", () -> {
            registrationPage.openPage();
        });


        step("Click Submit", () -> {
            registrationPage.submit();
        });

        step("Verify form", () -> {
            modalDialog.checkEmptyWindow();
        });
    }

}