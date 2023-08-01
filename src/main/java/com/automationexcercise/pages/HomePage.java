package com.automationexcercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "slider-carousel")
    WebElement sldCarousel;

    @FindBy(className = "features_items")
    WebElement txaFeatureItems;

    @FindBy(partialLinkText = "Login")
    WebElement btnSingUpLogin;

    @FindBy(css = ".nav.navbar-nav .fa.fa-user + b")
    WebElement lnkUserName;

    @FindBy(partialLinkText = "Delete Account")
    WebElement btnDeleteAccount;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSliderCarouselDisplayed() {
        return sldCarousel.isDisplayed();
    }

    public boolean isTextAreaDisplayed() {
        return txaFeatureItems.isDisplayed();
    }

    public boolean isHomePageLoaded() {
        return isSliderCarouselDisplayed() && isTextAreaDisplayed();
    }

    public LoginPage clickSingUpLogin() {
        btnSingUpLogin.click();
        return new LoginPage(driver);
    }

    public String getLoggedInUserName() {
        return lnkUserName.getText();
    }

    public DeleteAccountPage clickDeleteAccount() {
        btnDeleteAccount.click();
        return new DeleteAccountPage(driver);
    }
}
