package org.example.service;

import org.example.page.CheckoutOrderPage;

public class CheckoutOrderPageService {

    AssortmentPageService assortmentPageService = new AssortmentPageService();
    AddressPageService addressPageService = new AddressPageService();
    CartPageService cartPageService = new CartPageService();
    CheckoutOrderPage checkoutOrderPage = new CheckoutOrderPage();


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

    public String getTextOfOrderConfirmationMessage(){
        return checkoutOrderPage.getTextOfOrderConfirmationMessage();
    }

    public void deleteAddress() {
        addressPageService.deleteAddress();
    }
}
