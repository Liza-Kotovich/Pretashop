package org.example.service;

import io.qameta.allure.Step;
import org.example.page.AssortmentPage;
import org.example.page.CartPage;
import org.example.page.MyAccountPage;

public class AssortmentPageService {

    private AssortmentPage assortmentPage = new AssortmentPage();
    private LoginPageService loginPageService = new LoginPageService();
    private MyAccountPage myAccountPage = new MyAccountPage();
    private CartPage cartPage = new CartPage();

    @Step("Add item to cart")
    public void addItemToCart() {
        loginPageService.login();
        myAccountPage.clickOnWomenAssortmentPageButton();
        assortmentPage.clickToAddToCartButton()
                .clickToContinueShoppingButton()
                .clickToCartButton();
    }

    @Step("Adding item to the cart")
    public void addingItemToCart() {
        myAccountPage.clickOnWomenAssortmentPageButton();
        assortmentPage.clickToAddToCartButton()
                .clickToContinueShoppingButton()
                .clickToCartButton();
    }

    @Step("Getting name of item in the cart")
    public String getNameOfItemInTheCart() {
        return cartPage.nameOfItemInTheCart();
    }

    @Step("Getting expected price of item")
    public String getExpectedPriceOfItem() {
        loginPageService.login();
        myAccountPage.clickOnWomenAssortmentPageButton();
        assortmentPage.clickToAddToCartButton()
                .clickToContinueShoppingButton();
        return assortmentPage.getPriceOfItem();
    }

    @Step("Clicking on the cart button")
    public void clickToCartButton() {
        assortmentPage.clickToCartButton();
    }

    @Step("Getting description about item")
    public String getDescriptionAboutItem() {
        loginPageService.login();
        myAccountPage.clickOnWomenAssortmentPageButton();
        assortmentPage.clickOnMoreInformationAboutItemButton();
        return assortmentPage.getTextOfDescriptionOfItem();
    }
}
