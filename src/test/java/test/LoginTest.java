package test;

import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void testLogin() {
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add assertions to verify that the login was successful.
    }
}

