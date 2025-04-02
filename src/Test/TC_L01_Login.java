package Test;

import Base.BaseDriver;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC_L01_Login extends BaseDriver {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Student_4", "S12345");
    }
    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Student_4", "wrongPass");
        Assert.assertTrue(loginPage.waitForInvalidLoginError(), "Erroneous login message did not appear!");
    }

    @Test
    public void testEmptyFieldsLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", "");
    }
}
