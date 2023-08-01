package com.automationexcercise.pages;

import com.automationexcercise.entities.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_gender1")
    WebElement rdoMr;

    @FindBy(id = "id_gender2")
    WebElement rdoMrs;

    @FindBy(id = "name")
    WebElement txtName;

    @FindBy(id = "email")
    WebElement txtEmail;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(id = "days")
    WebElement ddlDays;

    @FindBy(id = "months")
    WebElement ddlMonths;

    @FindBy(id = "years")
    WebElement ddlYears;

    @FindBy(id = "newsletter")
    WebElement chkNewsletter;

    @FindBy(id = "optin")
    WebElement chkSpecialOffers;

    @FindBy(id = "first_name")
    WebElement txtFirstName;

    @FindBy(id = "last_name")
    WebElement txtLastName;

    @FindBy(id = "address1")
    WebElement txtAddress;

    @FindBy(id = "country")
    WebElement ddlCountry;

    @FindBy(id = "state")
    WebElement txtState;

    @FindBy(id = "city")
    WebElement txtCity;

    @FindBy(id = "zipcode")
    WebElement txtZipcode;

    @FindBy(id = "mobile_number")
    WebElement txtMobileNumber;

    @FindBy(css = "button[data-qa='create-account']")
    WebElement btnCreateAccount;

    public String getNameValue() {
        return txtName.getAttribute("value");
    }

    public String getEmailValue() {
        return txtEmail.getAttribute("value");
    }

    public AccountCreatedPage fillUserAccountInformation(User user) {
        txtPassword.sendKeys(user.getPassword());
        new Select(ddlDays).selectByVisibleText(String.valueOf(user.getDateOfBirth().getDayOfMonth()));
        selectByVisibleTextIgnoreCase(String.valueOf(user.getDateOfBirth().getMonth()));
        new Select(ddlYears).selectByVisibleText(String.valueOf(user.getDateOfBirth().getYear()));
        chkNewsletter.click();
        chkSpecialOffers.click();
        txtFirstName.sendKeys(user.getName());
        txtLastName.sendKeys(user.getLastName());
        txtAddress.sendKeys(user.getAddress());
        new Select(ddlCountry).selectByVisibleText(user.getCountry());
        txtState.sendKeys(user.getState());
        txtCity.sendKeys(user.getCity());
        txtZipcode.sendKeys(user.getZipcode());
        txtMobileNumber.sendKeys(user.getMobileNumber());
        btnCreateAccount.click();
        return new AccountCreatedPage(driver);
    }

    public void selectByVisibleTextIgnoreCase(String month) {
        Select select = new Select(ddlMonths);
        for (WebElement option : select.getOptions()) {
            if (option.getText().equalsIgnoreCase(month)) {
                option.click();
            }
        }
    }
}
