package org.example.test;

import org.example.page.MyAccountPage;
import org.example.service.AddressPageService;
import org.example.service.LoginPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.example.util.Constants.EXPECTED_TEXT_OF_NAME_OF_MY_ACCOUNT_PAGE;

public class LoginPageTest extends BaseTest {


    LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test
    public void loginTest() {
        MyAccountPage myAccountPage = loginPageService.login();
        String actualTextOfMyAccountPage = myAccountPage.getTextOfNameOfMainPageSection();
        Assert.assertEquals(actualTextOfMyAccountPage, EXPECTED_TEXT_OF_NAME_OF_MY_ACCOUNT_PAGE, "The actual text of the page does not match expected!");
    }
}
