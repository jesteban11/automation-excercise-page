package com.automationexcercise.tests.registration;


import com.automationexcercise.api.CreateAccount;
import com.automationexcercise.pages.*;
import com.automationexcercise.testdata.SingInData;
import com.automationexcercise.entities.User;
import com.automationexcercise.tests.base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTests extends BaseTests {

    @Test(testName = "1. Register User", dataProviderClass = SingInData.class, dataProvider = "sign-in-data")
    public void testRegisterUser(User user) {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        Assert.assertTrue(homePage.isHomePageLoaded(), "Home page was not loaded correctly");
        LoginPage loginPage = homePage.clickSingUpLogin();
        SignUpPage signUpPage = loginPage.signUpNewUser(user);
        Assert.assertEquals(user.getName(), signUpPage.getNameValue(), "Name value was not taken to the sign up page");
        Assert.assertEquals(user.getEmail(), signUpPage.getEmailValue(), "Email value was not taken to the sign up page");
        AccountCreatedPage accountCreatedPage = signUpPage.fillUserAccountInformation(user);
        Assert.assertEquals("ACCOUNT CREATED!", accountCreatedPage.getAccountCreatedText(), "Account created text is not correct");
        homePage = accountCreatedPage.clickButtonContinue();
        Assert.assertEquals(user.getName(), homePage.getLoggedInUserName(), "Username us not correct");
        DeleteAccountPage deleteAccountPage = homePage.clickDeleteAccount();
        Assert.assertEquals("ACCOUNT DELETED!", deleteAccountPage.getAccountDeletedText(), "Account deleted text is not correct");
        deleteAccountPage.clickButtonContinue();
    }
}
