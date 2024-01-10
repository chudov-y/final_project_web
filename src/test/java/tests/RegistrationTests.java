package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.ModalDialogComponent;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.NORMAL;

@Owner("chudov-y")
@Epic(value = "Demo QA")
@Feature(value = "Practise Form")
@Story(value = "Fill out a form")
@Tag("ui")


public class RegistrationTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    ModalDialogComponent modalDialog = new ModalDialogComponent();
    RandomUtils random = new RandomUtils();

    @Severity(NORMAL)
    @DisplayName("Fill registration form")
    @Description("Fill registration form with all fields")
    @Test
    void successfulRegistrationTest() {
        step("Open form", () -> {
        registrationPage.openPage();});

        step("Fill form", () -> {
            registrationPage.setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setEmail(random.email)
                .setGender(random.gender)
                .setUserNumber(random.phoneNumber)
                .setDateOfBirth(random.bDay, random.bMonth, random.bYear)
                .setSubject(random.subject)
                .setHobbies(random.hobby)
                .uploadPicture(random.picture)
                .setCurrentAddress(random.address)
                .setState(random.chooseState)
                .setCity(random.chooseCity)
                .submit();});


        step("Verify Form", () -> {
        modalDialog.checkWindow();

        modalDialog.checkResult("Student Name", random.firstName + " " + random.lastName)
                .checkResult("Student Email", random.email)
                .checkResult("Gender", random.gender)
                .checkResult("Mobile", random.phoneNumber)
                .checkResult("Date of Birth", random.bDay + " " + random.bMonth+ "," + random.bYear)
                .checkResult("Subjects", random.subject)
                .checkResult("Hobbies", random.hobby)
                .checkResult("Picture", random.picture)
                .checkResult("Address", random.address)
                .checkResult("State and City", random.chooseState + " " + random.chooseCity);});

    }

    @Severity(NORMAL)
    @DisplayName("Fill registration form with only required fields")
    @Test
    void requiredFieldsTest(){

        step("Open form", () -> {
        registrationPage.openPage();});

        step("Fill form", () -> {
            registrationPage.setFirstName(random.firstName)
                .setLastName(random.lastName)
                .setGender(random.gender)
                .setUserNumber(random.phoneNumber)
                .submit();});

        step("Verify Form", () -> {
        modalDialog.checkWindow();

        modalDialog.checkResult("Student Name", random.firstName + " " + random.lastName)
                .checkResult("Gender", random.gender)
                .checkResult("Mobile", random.phoneNumber);});
    }

    @Severity(NORMAL)
    @DisplayName("Fill registration form with empty fields")
    @Test
    void emptyFieldsTest(){
        step("Open form", () -> {
            registrationPage.openPage();});


        step("Click Submit", () -> {
            registrationPage.submit();});
        }
}