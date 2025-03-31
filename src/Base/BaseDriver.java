package Base;

import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void Setup() {
        // normalde public static void DriverStart() olarak kullandigimiz metodu extends eden classlarda direk calismasi icin static{ islemler } seklinde tanimliyoruz.
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 20 sn mühlet: elementi bulma mühleti
        driver.navigate().to("https://test.mersys.io/");
    }
    @AfterClass
    public static void TearDown() {
        MyFunc.sleep(6);
        driver.quit();
    }
    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
