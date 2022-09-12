package com.nttdata.com.Locators;

public enum PracticeFormElements {
    CLICK_HOMEPAGE_FORMS_ELEMENT("#app > div > div > div.home-body > div > div:nth-child(2) > div > div.avatar.mx-auto.white > svg"),
    CLICK_PRACTICE_FORM_ELEMENT("#app > div > div > div.row > div:nth-child(1) > div > div > div:nth-child(2) > div"),
    FIRST_NAME_ELEMENT("firstName"),
    LAST_NAME_ELEMENT("lastName"),
    EMAIL_ELEMENT("userEmail"),
    GENDER_MALE_ELEMENT("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label"),
    GENDER_FEMALE_ELEMENT("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label"),
    GENDER_OTHER_ELEMENT("gender-radio-1"),
    MOBILE_PHONE_ELEMENT("userNumber"),
    DATE_CLICK_ELEMENT("dateOfBirthInput"),
    MONTHS_SELECT_ELEMENT("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--select > div.react-datepicker__month-dropdown-container.react-datepicker__month-dropdown-container--select > select"),
    YEARS_SELECT_ELEMENT("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__header > div.react-datepicker__header__dropdown.react-datepicker__header__dropdown--select > div.react-datepicker__year-dropdown-container.react-datepicker__year-dropdown-container--select > select"),
    DAY_SELECT_ELEMENT("#dateOfBirth > div.react-datepicker__tab-loop > div.react-datepicker-popper > div > div > div.react-datepicker__month-container > div.react-datepicker__month > div:nth-child(3) > div.react-datepicker__day.react-datepicker__day--015"),
    SUBJECT_ELEMENT("subjectsInput"),
    HOBBIES_SPORTS_ELEMENT("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label"),
    HOBBIES_READING_ELEMENT("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(2) > label"),
    HOBBIES_MUSIC_ELEMENT("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label"),
    UPLOAD_PICTURES_ELEMENT("uploadPicture"),
    CURRENT_ADDRESS_ELEMENT("currentAddress"),
    STATE_ELEMENT("//input[@id='react-select-3-input']"),
    CITY_ELEMENT("//*[@id=\"react-select-4-input\"]"),
    SUBMIT_ELEMENT("document.querySelector('#submit').click()"),
    CLOSE_MODAL_ELEMENT("document.querySelector(\"#closeLargeModal\").click();");

    public final String value;
    PracticeFormElements(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
