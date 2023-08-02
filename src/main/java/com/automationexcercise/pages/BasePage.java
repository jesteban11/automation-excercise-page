package com.automationexcercise.pages;

import com.automationexcercise.sections.Sections;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    private String baseUrl = "https://www.automationexercise.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openHomePage() {
        driver.get(baseUrl);
        return  new HomePage(driver);
    }

    public void openSection(String section) {
        driver.get(baseUrl + section);
    }
}
