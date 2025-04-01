package Base;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

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
        driver.get("https://test.mersys.io/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 20 sn mühlet: elementi bulma mühleti
    }

    @AfterClass
    public void TearDown() {
        MyFunc.sleep(6);
        driver.quit();
    }

    By usernameInput = By.id("mat-input-0");
    By passwordInput = By.id("mat-input-1");
    By loginButtonClick = By.xpath("//span[@class='mdc-button__label']");
    By pageCheck = By.id("cdk-live-announcer-0");
    public void login() {
        WebElement username = driver.findElement(usernameInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        username.sendKeys("Student_4");
        System.out.println("Username is entered");

        WebElement password = driver.findElement(passwordInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        password.sendKeys("S12345");
        System.out.println("Password is entered");

        WebElement loginButton = driver.findElement(loginButtonClick);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonClick));
        loginButton.click();
        System.out.println("Login button is clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(pageCheck));
        Assert.assertTrue(driver.findElement(pageCheck).isDisplayed(), "Page check is not displayed");
        System.out.println("Page check is displayed");
    }
    By logo = By.cssSelector("img[src^='data:image/png;base64']");
    By signIn = By.linkText("SIGN IN");
    public void homePage() {
        WebElement logoElement = driver.findElement(logo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        Assert.assertTrue(driver.findElement(logo).isDisplayed(), "Logo is not displayed");
        System.out.println("Logo is displayed");
        driver.findElement(logo).click();
        System.out.println("Logo is clicked");

        System.out.println("Navigated to the website");
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));
        System.out.println("Switched to the new tab");
        driver.getCurrentUrl();

        System.out.println("URL: " + driver.getCurrentUrl());
        WebElement signInElement = driver.findElement(signIn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signIn));
        Assert.assertTrue(driver.findElement(signIn).isDisplayed(), "Sign In is not displayed");
        System.out.println("Sign in is displayed");
    }
}
