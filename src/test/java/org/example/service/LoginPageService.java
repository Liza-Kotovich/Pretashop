package org.example.service;

import org.example.page.MyAccountPage;
import org.example.page.LoginPage;

import static org.example.util.Constants.*;

public class LoginPageService {

    LoginPage loginPage = new LoginPage();

    public MyAccountPage login() {
        loginPage.openPage(LOGIN_PAGE_URL)
                .fillInEmail(EMAIL)
                .fillInPassword(PASSWORD)
                .clickSignInButton();
        return new MyAccountPage();
    }
}
