package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void configure(){
        baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 100000;
    }
    @Test
    void fillFormTest(){
        open("/text-box");
        $("#userName").setValue("Egor");
        $("#userEmail").setValue("Egor@egor.com");
        $("#currentAddress").setValue("Some address 1");
        $("#permanentAddress").setValue("Some address 2");
        $("#submit").click();

        $("#submit").click();

    }
}
