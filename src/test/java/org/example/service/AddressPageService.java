package org.example.service;

import org.example.driver.DriverSingleton;
import org.example.model.Address;
import org.example.page.AddressPage;
import org.openqa.selenium.Alert;

import static org.example.util.Constants.*;

public class AddressPageService {
    AddressPage addressPage = new AddressPage();
    LoginPageService loginPageService = new LoginPageService();

    public void createYourAddress() {
        loginPageService.login();
        Address address = new Address(FIRST_NAME, LAST_NAME, ADDRESS, ZIP, CITY, COUNTRY, HOME_PHONE, STATE, ADDRESS_TITLE);
        addressPage.openPage(ADDRESS_PAGE_URL)
                .firstNameInput(address)
                .lastNameInput(address)
                .addressInput(address)
                .zipInput(address)
                .cityInput(address)
                .chooseACountry(address)
                .homePhoneInput(address)
                .chooseAState(address)
                .addressTitleInput(address)
                .clickSaveButton();
    }

    public void clickOnLogoutButton() {
        addressPage.clickOnLogoutButton();
    }

    public String getTitleOfAddressPage() {
        return addressPage.getTextOfNameOfAddress();
    }

    Alert alert;

    public void deleteAddress() {
        addressPage.openPage(ADDRESSES_PAGE_URL)
                .clickDeleteAddressButton();
        alert = DriverSingleton.getDriver().switchTo().alert();
        alert.accept();
    }

    public String getTextOfPageAfterDeleteAddress() {
        return addressPage.getText();
    }
}
