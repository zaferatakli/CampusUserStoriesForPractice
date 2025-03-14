package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;

    static {
        // normalde public static void DriverStart() olarak kullandigimiz metodu extends eden classlarda direk calismasi icin static{ islemler } seklinde tanimliyoruz.
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // 20 sn mühlet: elementi bulma mühleti
    }

    public static void WaitAndClose() {
        MyFunc.sleep(6);
        driver.quit();
    }
}
