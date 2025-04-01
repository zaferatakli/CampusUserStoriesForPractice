package Test;

import Base.BaseDriver;
import Utility.MyFunc;
import org.testng.annotations.*;

public class TC_H02HomePage extends BaseDriver {
    @Test
    public void homePageTest() {
        MyFunc.sleep(2);
        login();
        homePage();
    }
}
