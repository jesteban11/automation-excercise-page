package com.automationexcercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage {

    @FindBy(css = "[data-qa='account-deleted'] b")
    WebElement txaAccountDeleted;

    @FindBy(css = "a[data-qa='continue-button']")
    WebElement btnContinue;

    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }

    public HomePage clickButtonContinue() {
        btnContinue.click();
        return new HomePage(driver);
    }

    public String getAccountDeletedText() {
        return txaAccountDeleted.getText();
    }
}
