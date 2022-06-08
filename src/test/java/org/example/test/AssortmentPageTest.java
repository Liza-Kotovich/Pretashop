package org.example.test;

import org.example.service.AssortmentPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.example.util.Constants.EXPECTED_DESCRIPTION_ABOUT_ITEM;

public class AssortmentPageTest extends BaseTest {

    AssortmentPageService assortmentPageService;

    @BeforeClass
    public void setUp() {
        assortmentPageService = new AssortmentPageService();
    }

    @Test
    public void getDescriptionAboutItemTest(){
        String actualDescriptionAboutItem = assortmentPageService.getDescriptionAboutItem();
        String expectedDescriptionAboutItem = EXPECTED_DESCRIPTION_ABOUT_ITEM;
        Assert.assertTrue(actualDescriptionAboutItem.contains(expectedDescriptionAboutItem),"The actual description about item does not match expected!");
    }
}
