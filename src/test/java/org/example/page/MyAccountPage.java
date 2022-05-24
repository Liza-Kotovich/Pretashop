package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement mainObjectOfMyAccountPage;

    public String getTextOfNameOfMainPageSection() {
        return mainObjectOfMyAccountPage.getText();
    }

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement womenAssortmentPageButton;

    public void clickOnWomenAssortmentPageButton(){
        womenAssortmentPageButton.click();
    }
}
