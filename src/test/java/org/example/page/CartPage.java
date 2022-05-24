package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {
    @FindBy(xpath = "//td[@class='cart_description']//*[contains(text(), 'Faded Short Sleeve T-shirts')]")
    private WebElement itemInTheCart;

    public String nameOfItemInTheCart() {
        return itemInTheCart.getText();
    }
}
