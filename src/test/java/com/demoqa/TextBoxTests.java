package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void configure(){
        baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 100000;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillFormTest(){
        open("/text-box");
        $("#userName").setValue("Egor");
       // $("[id=userName]").setValue("Egor");
        $("#userEmail").setValue("Egor@egor.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Some address 2");
        $("#submit").click();

        $("#submit").click();
        $("#output #name").shouldHave(text("Egor"));
        $("#output #email").shouldHave(text("Egor@egor.com"));
        $("#output #currentAddress").shouldHave(text("Some address 1"));
        $("#output #permanentAddress").shouldHave(text("Some address 2"));
    //  $("#output").$("#name").shouldHave(text("Egor"));
    //  $("#name").shouldHave(text("Egor"));
    //  $("#output").shouldHave(text("Egor"));
    //  $("#output").$("#email").shouldHave(text("Egor"));


    }
}
