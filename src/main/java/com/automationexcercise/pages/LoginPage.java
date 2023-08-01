package com.automationexcercise.pages;


import com.automationexcercise.entities.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-qa='signup-name']")
    private WebElement txtSignUpName;

    @FindBy(css = "[data-qa='signup-email']")
    private WebElement txtSignUpEmail;

    @FindBy(css = "[data-qa='signup-button']")
    private WebElement btnSignUp;


    public SignUpPage signUpNewUser(User user) {
        txtSignUpName.sendKeys(user.getName());
        txtSignUpEmail.sendKeys(user.getEmail());
        btnSignUp.click();
        return new SignUpPage(driver);
    }
}
