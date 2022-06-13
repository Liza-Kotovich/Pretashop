package org.example.test;

import org.example.service.AssortmentPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssortmentPageTest extends BaseTest {

    private AssortmentPageService assortmentPageService;

    @BeforeClass
    public void setUp() {
        assortmentPageService = new AssortmentPageService();
    }

    @Test
    public void getDescriptionAboutItemTest(){
        String actualDescriptionAboutItem = assortmentPageService.getDescriptionAboutItem();
        String expectedDescriptionAboutItem = "Faded short sleeve t-shirt with high neckline. Soft and stretchy material for a comfortable fit. Accessorize with a straw hat and you're ready for summer!";
        Assert.assertTrue(actualDescriptionAboutItem.contains(expectedDescriptionAboutItem),"The actual description about item does not match expected!");
    }
}
