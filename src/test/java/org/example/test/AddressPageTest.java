package org.example.test;

import org.example.service.AddressPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.example.util.Constants.ADDRESS_TITLE;
import static org.example.util.Constants.EXPECTED_MESSAGE_AFTER_DELETE_ADDRESS;

public class AddressPageTest extends BaseTest {

    AddressPageService addressPageService;

    @BeforeClass
    public void setUp() {
        addressPageService = new AddressPageService();
    }

    @Test
    public void createAddressTest() {
        addressPageService.createYourAddress();
        String actualTitleOfAddress = addressPageService.getTitleOfAddressPage();
        String expectedTitleOfAddress = ADDRESS_TITLE;
        Assert.assertTrue(actualTitleOfAddress.contains(expectedTitleOfAddress), "The actual title of the address does not match expected!");
    }

    @Test
    public void deleteAddressTest() {
        addressPageService.deleteAddress();
        String actualMessageOfPageAfterDeleteAddress = addressPageService.getTextOfPageAfterDeleteAddress();
        String expectedMessageOfPageAfterDeleteAddress = EXPECTED_MESSAGE_AFTER_DELETE_ADDRESS;
        Assert.assertTrue(actualMessageOfPageAfterDeleteAddress.contains(expectedMessageOfPageAfterDeleteAddress), "The actual message of the page does not match expected!");
    }

}
