package org.example.test;

import org.example.driver.DriverSingleton;
import org.example.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)

public class BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
