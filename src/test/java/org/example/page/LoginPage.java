package org.example.page;

import lombok.extern.log4j.Log4j2;
import org.example.driver.DriverSingleton;
import org.example.elements.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//i[@class='icon-lock left']")
    private WebElement signInButton;

    public LoginPage openPage(String url) {
        log.info("Opening page by URL");
        driver.get(url);
        return this;
    }

    public LoginPage fillInEmail(String emailAddress) {
        log.info("Filling email address");
        emailField.clear();
        emailField.sendKeys(emailAddress);
        return this;
    }

    public LoginPage fillInPassword(String password) {
        log.info("Filling password");
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }
//
//    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 15);
//
//    public LoginPage chooseALanguage() {
//        log.info("Choosing a language");
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='languages-block']"))).click();
//        driver.findElement(By.xpath("//span[contains(text(),'English')]")).click();
//        return this;
//    }

        public void clickSignInButton () {
            log.info("Clicking on the sign in button");
            signInButton.click();
        }
    }
