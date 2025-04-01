package Test;

import Base.BaseDriver;
import Utility.MyFunc;
import org.testng.annotations.*;

public class TC_L01_Login extends BaseDriver {
    @Test
    public void loginTest() {
        MyFunc.sleep(2);
        login();
    }
}
