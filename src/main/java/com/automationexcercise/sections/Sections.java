package com.automationexcercise.sections;

public enum Sections {
    LOGIN("login"),
    PRODUCTS("products"),
    VIEW_CART("view_cart");

    private final String sectionName;

    private Sections(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionName() {
        return sectionName;
    }
}
