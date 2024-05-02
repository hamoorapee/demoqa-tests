package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormTest {
    @BeforeAll
    static void configure(){
        baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void firstTest(){
        $("#firstName").setValue("Nikita");
        $("#userName-wrapper #lastName").setValue("Pidarasov");
        $("#userEmail-wrapper #userEmail ").setValue("NikitaPidarasov@mail.com");
        $("label[for='gender-radio-1']").click();
        $("label[for='gender-radio-2']").click();
        $("label[for='gender-radio-3']").click();
        $("#userNumber").setValue("9512648910");
        $("#dateOfBirthInput").click();
        $x("//div[@aria-label='Choose Wednesday, April 17th, 2024']").click();
        $x("(//label[text()='Subjects']/following::input)[1]").setValue("English").pressEnter();
        $("#uploadPicture").uploadFile(new File("C:/Users/Niko/Downloads/Forma_T9.rtf"));
        $("#currentAddress").setValue("I am Nikita Pidarasov and i have friend Matvey Huesosov");
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();
        $(".table").shouldHave(text("Student Name"), text("Nikita Pidarasov"));
        $(".table").shouldHave(text("Student Email"), text("NikitaPidarasov@mail.com"));
        $(".table").shouldHave(text("Gender"), text("Other"));
        $(".table").shouldHave(text("Mobile"), text("9512648910"));
        $(".table").shouldHave(text("Date of Birth"), text("17 April,2024"));
        $(".table").shouldHave(text("Subjects"), text("English"));
        $(".table").shouldHave(text("Picture"), text("Forma_T9.rtf"));
        $(".table").shouldHave(text("Address"), text("I am Nikita Pidarasov and i have friend Matvey Huesosov"));
        $(".table").shouldHave(text("State and City"), text("NCR Delhi"));
        $("#closeLargeModal").click();
    }
}
