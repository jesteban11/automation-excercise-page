package com.automationexcercise.tests.registration;

import com.automationexcercise.api.CreateAccount;
import com.automationexcercise.entities.User;
import com.automationexcercise.pages.DeleteAccountPage;
import com.automationexcercise.pages.HomePage;
import com.automationexcercise.pages.LoginPage;
import com.automationexcercise.testdata.SingInData;
import com.automationexcercise.tests.base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTests {
    @Test(testName = "2. Login User with correct email and password", dataProviderClass = SingInData.class, dataProvider = "sign-in-data")
    public void testLogin(User user) {
        CreateAccount.newUser(user);
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        LoginPage loginPage = homePage.clickSingUpLogin();
        loginPage.loginIn(user);
        Assert.assertEquals("Logged in as " + user.getName(), homePage.getLoggedInUser(), "Username us not correct");
        DeleteAccountPage deleteAccountPage = homePage.clickDeleteAccount();
        Assert.assertEquals("ACCOUNT DELETED!", deleteAccountPage.getAccountDeletedText(), "Account deleted text is not correct");
    }
}
