package com.automationexcercise.tests.registration;

import com.automationexcercise.api.CreateAccount;
import com.automationexcercise.entities.User;
import com.automationexcercise.pages.HomePage;
import com.automationexcercise.testdata.SingInData;
import com.automationexcercise.tests.base.BaseTests;
import org.testng.annotations.Test;

public class IncorrectLogin extends BaseTests {
    @Test(testName = "3. incorrectLogin", dataProviderClass = SingInData.class, dataProvider = "sign-in-data")
    public void testIncorrectLogin(User user) {
        CreateAccount.newUser(user);
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        driver.get("https://www.google.com.co");
        homePage.clickDeleteAccount();
    }
}
