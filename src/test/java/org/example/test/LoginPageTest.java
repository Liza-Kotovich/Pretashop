package org.example.test;

import org.example.page.MyAccountPage;
import org.example.service.LoginPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test
    public void loginTest() {
        MyAccountPage myAccountPage = loginPageService.login();
        String expectedTextOfNameOfMyAccountPage = "MY ACCOUNT";
        String actualTextOfMyAccountPage = myAccountPage.getTextOfNameOfMainPageSection();
        Assert.assertEquals(actualTextOfMyAccountPage, expectedTextOfNameOfMyAccountPage, "The actual text of the page does not match expected!");
    }
}
