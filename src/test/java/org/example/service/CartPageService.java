package org.example.service;

import org.example.page.CartPage;

public class CartPageService {

    CartPage cartPage = new CartPage();

    public void deleteItemFromCart() {
        cartPage.clickOnDeleteItemButton();
    }

    public String getCountOfItemsInTheCart() {
        return cartPage.getCountOfItemsInTheCart();
    }

    public void clickOnLogoutButton() {
        cartPage.clickOnLogoutButton();
    }

    public String getTextOfLoginButton() {
        return cartPage.getTextOfLoginButton();
    }

    public String getActualPriceOfItemIhTheCart(){
        return cartPage.getPriceOfItem();
    }

    public String getTotalPriceWithTax(){
        return cartPage.getTotalPriceWithTax();
    }

    public String getTotalOrderValue(){
        return cartPage.getTotalOrderValue();
    }

    public void clickOnProceedToCheckoutButton(){
        cartPage.clickOnProceedToCheckoutButton();
    }
}
