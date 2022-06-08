package org.example.test;

import org.example.service.CheckoutOrderPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.example.util.Constants.EXPECTED_MESSAGE_OF_CHECKOUT_PAGE;

public class CheckoutOrderPageTest extends BaseTest {

    CheckoutOrderPageService checkoutOrderPadeService;

    @BeforeClass
    public void setUp() {
        checkoutOrderPadeService = new CheckoutOrderPageService();
    }

    @Test
    public void checkoutOrderTest() {
        checkoutOrderPadeService.ordering();
        String actualMessageOfCheckoutPage = checkoutOrderPadeService.getTextOfOrderConfirmationMessage();
        String expectedMessageOfCheckoutPage = EXPECTED_MESSAGE_OF_CHECKOUT_PAGE;
        checkoutOrderPadeService.deleteAddress();
        Assert.assertTrue(actualMessageOfCheckoutPage.contains(expectedMessageOfCheckoutPage), "The actual text of checkout page does not match expected!");
    }
}
