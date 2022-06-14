package org.example.service;

import io.qameta.allure.Step;
import org.example.driver.DriverSingleton;
import org.example.model.Address;
import org.example.page.AddressPage;
import org.openqa.selenium.Alert;

import static org.example.model.Address.ADDRESSES_PAGE_URL;
import static org.example.model.Address.ADDRESS_PAGE_URL;

public class AddressPageService {
    private AddressPage addressPage = new AddressPage();
    private LoginPageService loginPageService = new LoginPageService();

    Alert alert;

    @Step("Creating address")
    public void createYourAddress() {
        loginPageService.login();
        Address address = new Address();
        addressPage.openPage(ADDRESS_PAGE_URL)
                .firstNameInput(address)
                .lastNameInput(address)
                .addressInput(address)
                .zipInput(address)
                .cityInput(address)
                .chooseACountry()
                .homePhoneInput(address)
                .chooseAState()
                .addressTitleInput(address)
                .clickSaveButton();
    }

    @Step("Clicking on logout button")
    public void clickOnLogoutButton() {
        addressPage.clickOnLogoutButton();
    }

    @Step("Getting title of address page")
    public String getTitleOfAddressPage() {
        return addressPage.getTextOfNameOfAddress();
    }

    @Step("Deleting address")
    public void deleteAddress() {
        addressPage.openPage(ADDRESSES_PAGE_URL)
                .clickDeleteAddressButton();
        alert = DriverSingleton.getDriver().switchTo().alert();
        alert.accept();
    }

    @Step("Getting text of the page after deleting address")
    public String getTextOfPageAfterDeleteAddress() {
        return addressPage.getText();
    }
}
