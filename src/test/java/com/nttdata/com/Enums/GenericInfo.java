package com.nttdata.com.Enums;

public enum GenericInfo {
    WEB_BASE_URL("https://demoqa.com/");
    public final String value;
    private GenericInfo(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
