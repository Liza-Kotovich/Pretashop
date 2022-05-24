package org.example.test;

import org.example.service.AssortmentPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.example.util.Constants.OO;

public class CartPageTest extends BaseTest {
    AssortmentPageService assortmentPageService;

    @BeforeClass
    public void setUp() {
        assortmentPageService = new AssortmentPageService();
    }

    @Test
    public void addItemToCartTest(){
        assortmentPageService.addItemToCart();
        String actualNameOfItemItTheCart = assortmentPageService.getNameOfItemInTheCart();
        String expectedNameOfItemItTheCart = OO;
        Assert.assertTrue(actualNameOfItemItTheCart.contains(expectedNameOfItemItTheCart), "--------");
    }
}
