package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

/**
 * Write down the following test into ‘RegisterTest’
 * class
 * 1. verifyThatSignInPageDisplay
 * * click on the ‘Create an Account’ link
 * * Verify the text ‘Create New Customer Account’
 * 2. userSholdRegisterAccountSuccessfully
 * * click on the ‘Create an Account’ link
 * * Enter First name
 * * Enter Last name
 * * Click on checkbox Sign Up for Newsletter
 * * Enter Emai
 * * Enter Password
 * * Enter Confirm Password
 * * Click on Create an Account button
 * * Verify the text 'Thank you for
 * registering with Main Website Store.’
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 * Created by Sandip Patel
 */

public class RegisterTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // Individual open and close
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1. verifyThatSignInPageDisplay
    @Test
    public void verifyThatSignInPageDisplay() {
        // click on the ‘Create an Account’ link
        driver.findElement(By.linkText("Create an Account")).click();
        // Verify the text ‘Create New Customer Account’
        String expectedText = "Create New Customer Account";
        String actualText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    // 2. userShouldRegisterAccountSuccessfully
    @Test
    public void userShouldRegisterAccountSuccessfully() {
        // click on the ‘Create an Account’ link
        driver.findElement(By.linkText("Create an Account")).click();
        //  Enter First name
        driver.findElement(By.id("firstname")).sendKeys("Shane");
        //  Enter Last name
        driver.findElement(By.id("lastname")).sendKeys("Warne");
        // Click on checkbox Sign Up for Newsletter
        // Option not available
        // Enter Email
        Random random = new Random();
        String email = "shane" + random.nextInt() + "@gmail.com";
        driver.findElement(By.id("email_address")).sendKeys(email);
        // Enter Password
        driver.findElement(By.id("password")).sendKeys("Shane1234");
        // Enter Confirm Password
        driver.findElement(By.id("password-confirmation")).sendKeys("Shane1234");
        // Click on Create an Account button
        driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
        // Verify the text 'Thank you for registering with Main Website Store.’
        String expectedText = "Thank you for registering with Main Website Store.";
        String actualText = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store.')]")).getText();
        Assert.assertEquals(expectedText, actualText);
        // Click on down aero near Welcome
        driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']")).click();
        // Click on Sign Out link
        driver.findElement(By.linkText("Sign Out")).click();
        // Verify the text ‘You are signed out’
        String expectedSignOutText = "You are signed out";
        String actualSignOutText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedSignOutText,actualSignOutText);

    }

    // Individual open and close
    @After
    public void tearDown() {
        closeBrowser();
    }
}
