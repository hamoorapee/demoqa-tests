package com.demoqa.pages.components;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {
    private final static String TITLE_TEXT = "Thanks for submitting the form";
    public ResultTableComponent checkVisible(){
        $(".modal-content").should(appear);
        $(".modal-header").shouldHave(text(TITLE_TEXT));
        return this;
    }
    public ResultTableComponent checkResult(String key, String value){
        $(By.xpath(String.format("//td[contains(text(), '%s')]/following-sibling::td", key)))
                .shouldHave(text(value));
        return this;
    }
}




