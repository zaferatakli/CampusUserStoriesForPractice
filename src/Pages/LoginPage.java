package Pages;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By usernameInput = By.id("mat-input-0");
    By passwordInput = By.id("mat-input-1");
    By loginButtonClick = By.xpath("//span[@class='mdc-button__label']");
    By pageCheck = By.id("cdk-live-announcer-0");
    // Methods
    public void login(String username, String password) {
        WebElement usernameField = driver.findElement(usernameInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        usernameField.sendKeys(username);
        System.out.println("Username is entered");

        WebElement passwordField = driver.findElement(passwordInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        passwordField.sendKeys(password);
        System.out.println("Password is entered");
        MyFunc.sleep(10);

        WebElement loginButton = driver.findElement(loginButtonClick);
        //wait.until(ExpectedConditions.elementToBeClickable(loginButtonClick));
        loginButton.click();
        System.out.println("Login button is clicked");

        wait.until(ExpectedConditions.visibilityOfElementLocated(pageCheck));
        Assert.assertTrue(driver.findElement(pageCheck).isDisplayed(), "Page check is not displayed");
        System.out.println("Page check is displayed");
    }

    By usernameRequiredError = By.cssSelector("#mat-mdc-error-3");
    By passwordRequiredError = By.cssSelector("#mat-mdc-error-2");
    By invalidLoginError = By.cssSelector("mat-panel-description[class='mat-expansion-panel-header-description ng-star-inserted'] div");

    public boolean waitForInvalidLoginError() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(invalidLoginError));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
