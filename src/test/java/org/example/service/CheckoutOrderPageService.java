package org.example.service;

import io.qameta.allure.Step;
import org.example.page.CheckoutOrderPage;

public class CheckoutOrderPageService {

    private AssortmentPageService assortmentPageService = new AssortmentPageService();
    private AddressPageService addressPageService = new AddressPageService();
    private CartPageService cartPageService = new CartPageService();
    private CheckoutOrderPage checkoutOrderPage = new CheckoutOrderPage();

    @Step("Making order")
    public void ordering() {
        addressPageService.createYourAddress();
        assortmentPageService.addingItemToCart();
        cartPageService.clickOnProceedToCheckoutButton();
        checkoutOrderPage.clickOnProceedToCheckoutButton();
        checkoutOrderPage.chooseAPickupShipping();
        checkoutOrderPage.clickOnProceedToCheckoutButtonAfterAgreementOfTermsOfServices();
        checkoutOrderPage.clickOnBankTransferButton();
        checkoutOrderPage.clickOnOrderConfirmationButton();
    }

    @Step("Getting text of order4 confirmation message")
    public String getTextOfOrderConfirmationMessage() {
        return checkoutOrderPage.getTextOfOrderConfirmationMessage();
    }

    @Step("Deleting address")
    public void deleteAddress() {
        addressPageService.deleteAddress();
    }
}
