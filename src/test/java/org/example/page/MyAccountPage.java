package org.example.page;

import lombok.extern.log4j.Log4j2;
import org.example.driver.DriverSingleton;
import org.example.elements.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement titleOfMyAccountPage;

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenAssortmentPageButton;

    public String getTextOfNameOfMainPageSection() {
        log.info("Getting text of main page section");
        return titleOfMyAccountPage.getText();
    }

    public void clickOnWomenAssortmentPageButton(){
        log.info("Clicking on the women assortment button");
        womenAssortmentPageButton.click();
    }
}
