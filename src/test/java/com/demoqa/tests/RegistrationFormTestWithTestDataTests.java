package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.Test;
import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.tests.TestData.*;
import static java.lang.String.format;

public class RegistrationFormTestWithTestDataTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Test
    void firstTest() {
        registrationFormPage.openPage();
        $("#firstName").setValue(firstName);
        $("#userName-wrapper #lastName").setValue(lastName);
        $("#userEmail-wrapper #userEmail ").setValue("NikitaPidarasov@mail.com");
        $("label[for='gender-radio-1']").click();
        $("label[for='gender-radio-2']").click();
        $("label[for='gender-radio-3']").click();
        $("#userNumber").setValue("9512648910");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(format(".react-datepicker__day--0%s", day)).click();
        $x("(//label[text()='Subjects']/following::input)[1]").setValue("English").pressEnter();
        $("#uploadPicture").uploadFile(new File("C:/Users/Niko/Downloads/Forma_T9.rtf"));
        $("#currentAddress").setValue("I am Nikita Pidarasov and i have friend Matvey Huesosov");
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();
        $(".table-responsive table").$(byText("Student Name"))
                .parent().shouldHave(text(firstName + " " + lastName));

        String expectedName = format("%s %s", firstName, lastName);

        $(".table-responsive table").$(byText("Student Name"))
                .parent().shouldHave(text(expectedName));

        String expectedDate = format("%s %s,%s", day, month, year);

        $(".table").shouldHave(text("Date of Birth"), text(expectedDate));
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text(expectedDate));


        $(".table-responsive table").shouldHave(text("Student Email"), text("NikitaPidarasov@mail.com"));
        $(".table-responsive table").shouldHave(text("Gender"), text("Other"));
        $(".table-responsive table").shouldHave(text("Mobile"), text("9512648910"));
        // $(".table-responsive table").shouldHave(text("Date of Birth"), text("17 April,2024"));
        $(".table-responsive table").shouldHave(text("Subjects"), text("English"));
        $(".table-responsive table").shouldHave(text("Picture"), text("Forma_T9.rtf"));
        $(".table-responsive table").shouldHave(text("Address"), text("I am Nikita Pidarasov and i have friend Matvey Huesosov"));
        $(".table-responsive table").shouldHave(text("State and City"), text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}
