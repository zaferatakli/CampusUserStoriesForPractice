package US_001LoginFeature;

import Base.BaseDriver;
import Pages.LoginPage;
import org.testng.annotations.*;

public class TC_L01_Login extends BaseDriver {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("Student_4", "S12345");
    }
}
