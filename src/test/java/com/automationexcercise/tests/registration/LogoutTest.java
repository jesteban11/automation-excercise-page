package com.automationexcercise.tests.registration;

import com.automationexcercise.api.CreateAccount;
import com.automationexcercise.entities.User;
import com.automationexcercise.pages.HomePage;
import com.automationexcercise.pages.LoginPage;
import com.automationexcercise.testdata.SingInData;
import com.automationexcercise.tests.base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTests {
    @Test(testName = "4. Logout User", dataProviderClass = SingInData.class, dataProvider = "sign-in-data")
    public void testLogin(User user) {
        CreateAccount.newUser(user);
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        LoginPage loginPage = homePage.clickSingUpLogin();
        loginPage.loginIn(user);
        Assert.assertEquals("Logged in as " + user.getName(), homePage.getLoggedInUser(), "Username us not correct");
        driver.get("https://www.google.com.co");
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Current Time");
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);
    }

}
