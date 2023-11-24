package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Write down the following test into ‘LoginTest’
 * class
 * 1. userShouldLoginSuccessfullyWithValid
 * Credentials()
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * 2. verifyTheErrorMessageWithInvalidCredentials
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the error message ‘The account sign-in was
 * incorrect or your account is disabled temporarily. Please wait and try again
 * later.’
 * 3. userShouldLogOutSuccessfully
 * * Click on ‘Sign In’ link
 * * Enter valid Email
 * * Enter valid Password
 * * Click on ‘Sign In’ button
 * * Verify the ‘Welcome’ text is display
 * * Click on down aero neare Welcome
 * * Click on Sign Out link
 * * Verify the text ‘You are signed out’
 * Created by Sandip Patel
 */
public class LoginTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // Individual open and close
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1. userShouldLoginSuccessfullyWithValidCredentials()
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        // Enter valid Email
        driver.findElement(By.id("email")).sendKeys("shanewarne1978@gmail.com");
        // Enter valid Password
        driver.findElement(By.name("login[password]")).sendKeys("Shane1234");
        // Click on ‘Sign In’ button
        driver.findElement(By.xpath("//button[@type='submit' and @class='action login primary']")).click();
        // Verify the ‘Welcome’ text is display
        String expectedText = "Welcome";
        String actualText = driver.findElement(By.xpath("//header[@class = 'page-header']//span[starts-with(text(), 'Welcome')]")).getText();
        String actualText1 = expectedText.substring(0, 7);
        Assert.assertEquals(actualText1, expectedText);

    }

    // 2. verifyTheErrorMessageWithInvalidCredentials
    @Test
    public void verifyTheErrorMessageWithInvalidCredentials() {
        // Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        // Enter valid Email
        driver.findElement(By.id("email")).sendKeys("shanewarne197@gmail.com");
        // Enter valid Password
        driver.findElement(By.name("login[password]")).sendKeys("Shane123");
        // Click on ‘Sign In’ button
        driver.findElement(By.xpath("//button[@type='submit' and @class='action login primary']")).click();
        // Verify the error message ‘The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.’
        String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualErrorMessage = driver.findElement(By.xpath("//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']")).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }

    // 3. userShouldLogOutSuccessfully
    @Test
    public void userShouldLogOutSuccessfully() {
        // Click on ‘Sign In’ link
        driver.findElement(By.linkText("Sign In")).click();
        // Enter valid Email
        driver.findElement(By.id("email")).sendKeys("shanewarne1978@gmail.com");
        // Enter valid Password
        driver.findElement(By.name("login[password]")).sendKeys("Shane1234");
        // Click on ‘Sign In’ button
        driver.findElement(By.xpath("//button[@type='submit' and @class='action login primary']")).click();
        // Verify the ‘Welcome’ text is display
        String expectedText = "Welcome";
        String actualText = driver.findElement(By.xpath("//header[@class = 'page-header']//span[starts-with(text(), 'Welcome')]")).getText();
        String actualText1 = expectedText.substring(0, 7);
        Assert.assertEquals(actualText1, expectedText);
        // Click on down aero near Welcome
        driver.findElement(By.xpath("//div[@class='panel header']//li[@class='customer-welcome']//button[@class='action switch']")).click();
        // Click on Sign Out link
        driver.findElement(By.linkText("Sign Out")).click();
        // Verify the text ‘You are signed out’
        String expectedSignOutText = "You are signed out";
        String actualSignOutText = driver.findElement(By.xpath("//span[@class='base']")).getText();
        Assert.assertEquals(expectedSignOutText, actualSignOutText);
    }

    // Individual open and close
    @After
    public void tearDown() {
        closeBrowser();
    }
}

