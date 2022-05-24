package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//i[@class='icon-lock left']")
    private WebElement signInButton;

    public LoginPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public LoginPage fillInEmail(String emailAddress) {
        emailField.clear();
        emailField.sendKeys(emailAddress);
        return this;
    }

    public LoginPage fillInPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
