package org.example.page;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssortmentPage extends BasePage {

    @FindBy(xpath = "//div[@class='button-container']//a[@data-id-product='1']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='right-block']")
    private WebElement element;

    public AssortmentPage clickToAddToCartButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).moveToElement(addToCartButton).click().build().perform();
        return this;
    }

    @FindBy(xpath = "//span[@title='Продолжить покупки']")
    private WebElement continueShoppingButton;

    public AssortmentPage clickToContinueShoppingButton() {
        continueShoppingButton.click();
        return this;
    }

    @FindBy(xpath = "//a[@title='Посмотреть корзину']")
    private WebElement cartButton;

    public void clickToCartButton() {
        cartButton.click();
    }
}
