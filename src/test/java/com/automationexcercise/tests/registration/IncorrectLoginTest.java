package com.automationexcercise.tests.registration;

import com.automationexcercise.entities.User;
import com.automationexcercise.pages.HomePage;
import com.automationexcercise.pages.LoginPage;
import com.automationexcercise.testdata.SingInData;
import com.automationexcercise.tests.base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncorrectLoginTest extends BaseTests {
    @Test(testName = "3. Login ser with incorrect email and password", dataProviderClass = SingInData.class, dataProvider = "sign-in-data")
    public void testIncorrectLogin(User user) {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        LoginPage loginPage = homePage.clickSingUpLogin();
        loginPage.loginIn(user);
        Assert.assertEquals(loginPage.getLoginErrorText(), "Your email or password is incorrect!", "Login error message is not correct");
    }
}
