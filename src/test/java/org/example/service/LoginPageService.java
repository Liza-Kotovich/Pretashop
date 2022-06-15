package org.example.service;

import io.qameta.allure.Step;
import org.example.page.MyAccountPage;
import org.example.page.LoginPage;

public class LoginPageService {

    public static final String LOGIN_PAGE_URL = "http://prestashop.qatestlab.com.ua/ru/authentication?back=my-account";
    public static final String EMAIL = "motherlodesimss@gmail.com";
    public static final String PASSWORD = "8motherLode8";

    private LoginPage loginPage = new LoginPage();

    @Step("Login")
    public MyAccountPage login() {
        loginPage.openPage(LOGIN_PAGE_URL)
                .fillInEmail(EMAIL)
                .fillInPassword(PASSWORD)
                .clickSignInButton();
        return new MyAccountPage();
    }
}
