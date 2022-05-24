package org.example.page;

import org.example.driver.DriverSingleton;
import org.example.elements.DropDown;
import org.example.elements.InputFields;
import org.example.model.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage extends BasePage {

    public AddressPage openPage(String url) {
        driver.get(url);
        return this;
    }

    public AddressPage firstNameInput(Address address) {
        new InputFields("firstname").writeText(address.getFirstName());
        return this;
    }

    public AddressPage lastNameInput(Address address) {
        new InputFields("lastname").writeText(address.getLastName());
        return this;
    }

    public AddressPage addressInput(Address address) {
        new InputFields("address1").writeText(address.getAddress());
        return this;
    }

    public AddressPage zipInput(Address address) {
        new InputFields("postcode").writeText(address.getZip());
        return this;
    }

    public AddressPage cityInput(Address address) {
        new InputFields("city").writeText(address.getCity());
        return this;
    }

    public AddressPage homePhoneInput(Address address) {
        new InputFields("phone").writeText(address.getHomePhone());
        return this;
    }

    public AddressPage addressTitleInput(Address address) {
        new InputFields("alias").writeText(address.getAddressTitle());
        return this;
    }

    public AddressPage chooseACountry(Address address) {
        new DropDown("uniform-id_country").selectOption(address.getCountry());
        return this;
    }

    public AddressPage chooseAState(Address address) {
        new DropDown("uniform-id_state").selectOption(address.getState());
        return this;
    }

    @FindBy(xpath = "//button[@id='submitAddress']")
    private WebElement saveButton;

    public void clickSaveButton() {
        saveButton.click();
    }

    @FindBy(xpath = "//h3[@class='page-subheading']")
    private WebElement nameOfAddress;

    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 15);

    public String getTextOfNameOfAddress() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[@class='page-subheading']"))));
        return nameOfAddress.getText();
    }

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement deleteAddressButton;

    public void clickDeleteAddressButton() {
        deleteAddressButton.click();
    }

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement availableAddressesButton;

    public String getText() {
        return availableAddressesButton.getText();
    }

}
