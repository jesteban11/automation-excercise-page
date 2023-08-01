package com.automationexcercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends BasePage {

    @FindBy(css = "[data-qa='account-created'] b")
    WebElement txaAccountCreated;

    @FindBy(css = "a[data-qa='continue-button']")
    WebElement btnContinue;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickButtonContinue() {
        btnContinue.click();
        return new HomePage(driver);
    }

    public String getAccountCreatedText() {
        return txaAccountCreated.getText();
    }

}
