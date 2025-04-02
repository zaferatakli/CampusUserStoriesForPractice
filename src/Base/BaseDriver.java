package Base;

import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void Setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en"); // 🌍 Tarayıcıyı İngilizce başlatır

        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // 20 sn mühlet: elementi bulma mühleti
        driver.get("https://test.mersys.io/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 20 sn mühlet: elementi bulma mühleti
    }

    @AfterClass
    public void TearDown() {
        MyFunc.sleep(6);
        driver.quit();
        MyFunc.CloseFaultyWindows();
    }
}
