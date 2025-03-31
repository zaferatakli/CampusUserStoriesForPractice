package US_002HomePage;

import Base.BaseDriver;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;


public class TC_H02HomePage extends BaseDriver {
    @Test
    public void homePageTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("Student_4", "S12345");
        HomePage homePage = new HomePage();
        homePage.homePageTest();
    }
}
