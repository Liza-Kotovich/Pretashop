package org.example.elements;

import org.example.driver.DriverSingleton;
import org.example.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InputFields extends BasePage {
    private final String label;

    public InputFields(String label) {
        this.label = label;
    }

    WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriver(), 15);
    private static final String INPUT_XPATH = "//input[@id='%s']";

    public void writeText(String text) {
        wait.until(ExpectedConditions.
                visibilityOf(driver.findElement(By.xpath(String.format(INPUT_XPATH, label))))).sendKeys(text);
    }
}
