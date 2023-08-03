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

    @FindBy(css = "[data-qa='login-email']")
    private WebElement txtLoginEmail;

    @FindBy(css = "[data-qa='login-password']")
    private WebElement txtLoginPassword;

    @FindBy(css = "[data-qa='login-button']")
    private WebElement btnLogin;

    @FindBy(css = "form[action='/login'] p")
    private WebElement txaLoginError;

    @FindBy(css= ".login-form h2")
    private WebElement txaLoginToYourAccount;


    public SignUpPage signUpNewUser(User user) {
        txtSignUpName.sendKeys(user.getName());
        txtSignUpEmail.sendKeys(user.getEmail());
        btnSignUp.click();
        return new SignUpPage(driver);
    }

    public HomePage loginIn(User user) {
        txtLoginEmail.sendKeys(user.getEmail());
        txtLoginPassword.sendKeys(user.getPassword());
        btnLogin.click();
        return new HomePage(driver);
    }

    public String getLoginErrorText() {
        return txaLoginError.getText();
    }

    public String getLoginToYourAccountText(){
        return txaLoginToYourAccount.getText();
    }
}
