package US_001LoginFeature;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class US_001LoginFeature extends BaseDriver {
    @Test
    public void loginTest() {
        driver.navigate().to("https://test.mersys.io/");
        MyFunc.sleep(2);
        WebElement username = driver.findElement(By.id("mat-input-0"));
        username.sendKeys("Student_4");
        System.out.println("Username is entered");
        MyFunc.sleep(2);
        WebElement password = driver.findElement(By.id("mat-input-1"));
        password.sendKeys("S12345");
        System.out.println("Password is entered");
        MyFunc.sleep(2);
        WebElement loginButton = driver.findElement(By.className("mdc-button__label"));
        loginButton.click();
        System.out.println("Login button is clicked");
        MyFunc.sleep(2);
        WebElement pageCheck = driver.findElement(By.id("cdk-live-announcer-0"));
        Assert.assertTrue("Do not access to the homepage", pageCheck.isDisplayed());
        MyFunc.sleep(2);
        if (pageCheck.isDisplayed() == true) {
            System.out.println("Login is successful");
        }
    }
}
