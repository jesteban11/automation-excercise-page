package com.automationexcercise.tests.registration;

import com.automationexcercise.api.Account;
import com.automationexcercise.entities.User;
import com.automationexcercise.pages.HomePage;
import com.automationexcercise.pages.LoginPage;
import com.automationexcercise.testdata.SingInData;
import com.automationexcercise.tests.base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterExistingUserTest extends BaseTests {
    @Test(testName = "5: Register User with existing email", dataProviderClass = SingInData.class, dataProvider = "sign-in-data")
    public void testRegisterWithExistingEmail(User user) {
        Account.newUser(user);
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.openHomePage()
                .clickSingUpLogin();
        loginPage.signUpNewUser(user);
        Assert.assertEquals("Email Address already exist!", loginPage.getSignUpErrorText(), "Error message is not shown correctly");
        Account.deleteUser(user);
    }
}
