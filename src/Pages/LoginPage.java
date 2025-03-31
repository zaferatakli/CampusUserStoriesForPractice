package Pages;

import Base.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By usernameInput = By.id("mat-input-0");
    private final By passwordInput = By.id("mat-input-1");
    private final By loginButtonClick = By.className("mdc-button__label");
    private final By pageCheck = By.id("cdk-live-announcer-0");

    public LoginPage() {
        this.driver = BaseDriver.getDriver();
        this.wait = BaseDriver.getWait();
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        driver.findElement(usernameInput).sendKeys("Student_4");
        System.out.println("Username is entered");

        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        driver.findElement(passwordInput).sendKeys("S12345");
        System.out.println("Password is entered");

        wait.until(ExpectedConditions.elementToBeClickable(loginButtonClick));
        driver.findElement(loginButtonClick).click();
        System.out.println("Login button is clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(pageCheck));
        Assert.assertTrue(driver.findElement(pageCheck).isDisplayed(), "Page check is not displayed");
        System.out.println("Page check is displayed");
    }
}
