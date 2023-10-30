package com.example.BTThymeleaf.statics;

public enum PersonCategory {

    SV("Sinh Viên"),

    HV("Học Viên"),
    GV("Giao Viên");
    public String value;

    PersonCategory(String value) {
        this.value = value;
    }

}
