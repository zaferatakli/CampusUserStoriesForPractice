package Pages;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    // Locators
    By logo = By.cssSelector("img[src^='data:image/png;base64']");
    By signIn = By.linkText("SIGN IN");
    public void homePage() {
        WebElement logoElement = driver.findElement(logo);
        MyFunc.sleep(2);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(logo).isDisplayed(), "Logo is not displayed");
        System.out.println("Logo is displayed");
        logoElement.click();
        System.out.println("Logo is clicked");

        System.out.println("Navigated to the website");
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));
        System.out.println("Switched to the new tab");
        driver.getCurrentUrl();

        System.out.println("URL: " + driver.getCurrentUrl());
        WebElement signInElement = driver.findElement(signIn);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(signInElement.isDisplayed(), "Sign In is not displayed");
        System.out.println("Sign in is displayed");
    }
}
