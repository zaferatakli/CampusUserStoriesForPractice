package Pages;

import Base.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Set;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By logo = By.cssSelector("img[src^='data:image/png;base64']");
    private final By signIn = By.linkText("SIGN IN");

    public HomePage() {
        this.driver = BaseDriver.getDriver();
        this.wait = BaseDriver.getWait();
    }
    public void homePageTest() {
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(signIn));
        Assert.assertTrue(driver.findElement(signIn).isDisplayed(), "Sign In is not displayed");
        System.out.println("Sign in is displayed");
    }
}
