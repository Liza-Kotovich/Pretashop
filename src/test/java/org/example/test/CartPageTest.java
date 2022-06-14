package org.example.test;

import org.example.service.AssortmentPageService;
import org.example.service.CartPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class CartPageTest extends BaseTest {
    private AssortmentPageService assortmentPageService;
    private CartPageService cartPageService;

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
        String expectedNameOfItemItTheCart = "Faded Short Sleeve T-shirts";
        Assert.assertTrue(actualNameOfItemItTheCart.contains(expectedNameOfItemItTheCart), "The actual name of item in the cart does not match expected!");
    }

    @Test
    public void deleteItemFromCartTest() {
        assortmentPageService.addItemToCart();
        cartPageService.deleteItemFromCart();
        String actualCountOfItemsInTheCart = cartPageService.getCountOfItemsInTheCart();
        String expectedCountOfItemsInTheCart = "1 product";
        Assert.assertEquals(actualCountOfItemsInTheCart, expectedCountOfItemsInTheCart, "The actual count of item in the cart does not match expected!");
    }

    @Test
    public void logoutTest() {
        cartPageService.logout();
        String actualTextOfThePageAfterLogout = cartPageService.gettingTextOfThePageAfterClickingOnLogoutButton();
        String expectedTextOfThePageAfterLogout = "AUTHENTICATION";
        Assert.assertEquals(actualTextOfThePageAfterLogout, expectedTextOfThePageAfterLogout, "You have been not logout!");
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
