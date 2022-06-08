package org.example.test;

import org.example.service.AssortmentPageService;
import org.example.service.CartPageService;
import org.example.util.Retry;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.example.util.Constants.*;

public class CartPageTest extends BaseTest {
    AssortmentPageService assortmentPageService;
    CartPageService cartPageService;

    @BeforeClass
    public void setUp() {
        assortmentPageService = new AssortmentPageService();
        cartPageService = new CartPageService();
    }

    @Test
    public void addItemToCartTest() {
        assortmentPageService.addItemToCart();
        String actualNameOfItemItTheCart = assortmentPageService.getNameOfItemInTheCart();
        cartPageService.clickOnLogoutButton();
        String expectedNameOfItemItTheCart = EXPECTED_NAME_OF_ITEM_IN_CART;
        Assert.assertTrue(actualNameOfItemItTheCart.contains(expectedNameOfItemItTheCart), "The actual name of item in the cart does not match expected!");
    }

    @Test
    public void deleteItemFromCartTest() {
        assortmentPageService.addItemToCart();
        cartPageService.deleteItemFromCart();
        String actualCountOfItemsInTheCart = cartPageService.getCountOfItemsInTheCart();
        String expectedCountOfItemsInTheCart = EXPECTED_COUNT_OF_ITEMS_IN_THE_CART;
        Assert.assertEquals(actualCountOfItemsInTheCart, expectedCountOfItemsInTheCart, "The actual count of item in the cart does not match expected!");
    }

    @Test
    public void logoutTest() {
        cartPageService.clickOnLogoutButton();
        String actualTextOfButton = cartPageService.getTextOfLoginButton();
        String expectedTextOfButton = EXPECTED_TEXT_OF_BUTTON;
        Assert.assertEquals(actualTextOfButton, expectedTextOfButton, "You have been not logout!");
    }

    @Test
    public void correctPriceDisplayTest() {
        String expectedPriceOfItem = assortmentPageService.getExpectedPriceOfItem();
        assortmentPageService.clickToCartButton();
        String actualPriceOfItem = cartPageService.getActualPriceOfItemIhTheCart();
        cartPageService.clickOnLogoutButton();
        Assert.assertEquals(actualPriceOfItem, expectedPriceOfItem, "The actual price of item un the cart does not match expected!");
    }

    @Test
    public void correctOrderValueTest() {
        assortmentPageService.addItemToCart();
        String expectedOrderValue = cartPageService.getTotalPriceWithTax();
        String actualOrderValue = cartPageService.getTotalOrderValue();
        cartPageService.clickOnLogoutButton();
        Assert.assertEquals(actualOrderValue, expectedOrderValue, "The actual order value does not match expected!");
    }

}
