package org.example.page;

import lombok.extern.log4j.Log4j2;
import org.example.driver.DriverSingleton;
import org.example.elements.InputFields;
import org.example.model.Address;
import org.example.util.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2

public class AddressPage extends BasePage {

    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 15);

    @FindBy(xpath = "//button[@id='submitAddress']")
    private WebElement saveButton;

    @FindBy(xpath = "//h3[@class='page-subheading']")
    private WebElement nameOfAddress;

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement deleteAddressButton;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement availableAddressesButton;

    @FindBy(xpath = "//a[@class='logout']")
    private WebElement logoutButton;

    public AddressPage openPage(String url) {
        log.info("Open address page by URL");
        driver.get(url);
        return this;
    }

    public AddressPage firstNameInput(Address address) {
        log.info("Entering a name");
        new InputFields("firstname").writeText(address.getFirstName());
        return this;
    }

    public AddressPage lastNameInput(Address address) {
        log.info("Entering a last name");
        new InputFields("lastname").writeText(address.getLastName());
        return this;
    }

    public AddressPage addressInput(Address address) {
        log.info("Entering an address");
        new InputFields("address1").writeText(address.getAddress());
        return this;
    }

    public AddressPage zipInput(Address address) {
        log.info("Entering a zip code");
        new InputFields("postcode").writeText(address.getZip());
        return this;
    }

    public AddressPage cityInput(Address address) {
        log.info("Entering a name of the city");
        new InputFields("city").writeText(address.getCity());
        return this;
    }

    public AddressPage homePhoneInput(Address address) {
        log.info("Entering a home phone");
        new InputFields("phone").writeText(address.getHomePhone());
        return this;
    }

    public AddressPage addressTitleInput(Address address) {
        log.info("Entering a title of address");
        new InputFields("alias").writeText(address.getAddressTitle());
        return this;
    }

    public AddressPage chooseACountry() {
        log.info("Choosing a country");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='id_country']//parent::div"))).click();
        driver.findElement(By.xpath("//select[@id='id_country']//option[@value='216']")).click();
        return this;
    }


    public AddressPage chooseAState() {
        log.info("Choosing a state");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='id_state']//parent::div"))).click();
        driver.findElement(By.xpath("//select[@id='id_state']//option[@value='321']")).click();
        return this;
    }

    public void clickSaveButton() {
        log.info("Clicking on the save button");
        saveButton.click();
    }

    public String getTextOfNameOfAddress() {
        log.info("Getting a text of name of address");
        Waiter.waitVisibilityOfElement(driver, nameOfAddress);
        return nameOfAddress.getText();
    }

    public void clickDeleteAddressButton() {
        log.info("Clicking on the delete address button");
        deleteAddressButton.click();
    }

    public String getText() {
        log.info("Getting text from the button (for assert)");
        return availableAddressesButton.getText();
    }


    public void clickOnLogoutButton() {
        log.info("Clicking on the logout button");
        logoutButton.click();
    }

}
