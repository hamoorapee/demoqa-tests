package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
//Elements


//Actions
public class RegistrationFormPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();

    private SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    emailInput = $("#userEmail");


    public RegistrationFormPage openPage(){
        open("/automation-practice-form");
        return this;
    }
    public RegistrationFormPage setFirstName(String name){
        firstNameInput.setValue(name);
        return this;

    }
    public RegistrationFormPage clearFirstName(String name){
        firstNameInput.clear();
        return this;

    }
    public RegistrationFormPage setLastName(String name){
        lastNameInput.setValue(name);
        return this;

    }
    public RegistrationFormPage setEmail(String email){
        emailInput.setValue(email);
        return this;

    }
    public RegistrationFormPage setGender(String genter){
        $("#genterWrapper").$(byText(genter)).click();
        return this;

    }
    public RegistrationFormPage setBirthday(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day,month,year);
        return this;
    }
    public RegistrationFormPage setNumber(String number){
        $("#userNumber").setValue(number);
        return this;
    }
    public RegistrationFormPage clickSubmit(){
        $("#submit").click();
        return this;
    }
    public RegistrationFormPage clickClose(){
        $("#closeLargeModal").click();
        return this;
    }
    public RegistrationFormPage checkResultsTableVisible(){
        resultTableComponent.checkVisible();
        return this;
    }
    public RegistrationFormPage checkResults(String key, String value){
        resultTableComponent.checkResult(key, value);
        return this;
    }

}




