package com.nttdata.com.Enums;

public enum UserInfo  {
    PHONE("5348979425"),
    SUBJECT("Computer Science"),
    STATE("Uttar Pradesh"),
    CITY("Lucknow");
    public final String value;
    private UserInfo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
