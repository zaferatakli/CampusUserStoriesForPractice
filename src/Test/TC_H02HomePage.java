package Test;

import Base.BaseDriver;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC_H02HomePage extends BaseDriver {
    @Test
    public void homePageTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Student_4", "S12345");

        HomePage homePage = new HomePage(driver);
        homePage.homePage();
    }
}
