package US_002HomePage;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class US_002HomePage extends BaseDriver {
    @Test
    public void homePageTest() {
        WebElement logo = driver.findElement(By.cssSelector("img[src^='data:image/png;base64']"));
        Assert.assertTrue("Logo is not displayed", logo.isDisplayed());
        if (logo.isDisplayed()==true){
            System.out.println("Logo is displayed");
        }
        MyFunc.sleep(2);
        logo.click();
        System.out.println("Logo is clicked");
        System.out.println("Navigated to the website");
        MyFunc.sleep(2);
        //WebElement dashboard = driver.findElement(By.xpath("//a[text()='PROGRAMS']"));
        //Assert.assertTrue("Dashboard is not displayed", programsLink.isDisplayed());
        //if (programsLink.isDisplayed()==true){
           // System.out.println("Dashboard is displayed");
       // }

        WaitAndClose();
    }
}
