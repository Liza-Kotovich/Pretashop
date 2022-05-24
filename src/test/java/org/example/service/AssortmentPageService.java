package org.example.service;

import org.example.page.AssortmentPage;
import org.example.page.CartPage;
import org.example.page.MyAccountPage;

public class AssortmentPageService {

    AssortmentPage assortmentPage = new AssortmentPage();
    LoginPageService loginPageService = new LoginPageService();
    MyAccountPage myAccountPage = new MyAccountPage();
    CartPage cartPage = new CartPage();

    public void addItemToCart() {
        loginPageService.login();
        myAccountPage.clickOnWomenAssortmentPageButton();
        assortmentPage.clickToAddToCartButton()
                .clickToContinueShoppingButton()
                .clickToCartButton();
    }

    public String getNameOfItemInTheCart() {
        return cartPage.nameOfItemInTheCart();
    }
}
