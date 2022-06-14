package org.example.test;

import org.example.service.CheckoutOrderPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutOrderPageTest extends BaseTest {

    private CheckoutOrderPageService checkoutOrderPadeService;

    @BeforeClass
    public void setUp() {
        checkoutOrderPadeService = new CheckoutOrderPageService();
    }

    @Test
    public void checkoutOrderTest() {
        checkoutOrderPadeService.ordering();
        String actualMessageOfCheckoutPage = checkoutOrderPadeService.getTextOfOrderConfirmationMessage();
        String expectedMessageOfCheckoutPage = "ORDER CONFIRMATION";
        checkoutOrderPadeService.deleteAddress();
        Assert.assertTrue(actualMessageOfCheckoutPage.contains(expectedMessageOfCheckoutPage), "The actual text of checkout page does not match expected!");
    }
}
