package testsuite;
/**
 * .Write down the following test into ‘SaleTest’ class
 * 1. verifyTheTotalItemsDisplayedOnTheWomens
 * JacketsPage()
 * * Click on ‘Sale’ Menu tab
 * * Click on ‘Jackets’ link on left side
 * under WOMEN’S DEAL Category
 * * Verify the text ‘Jackets’ is displayed
 * * Count the Total Item Displayed on Page
 * and print the name of all items into
 * console.
 * * Verify total 12 Items displayed on page.
 * Created by Sandip Patel
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SaleTest extends BaseTest {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    // Individual open and close
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    // 1. verifyTheTotalItemsDisplayedOnTheWomensJacketsPage
    @Test
    public void verifyTheTotalItemsDisplayedOnTheWomensJacketsPage() {
        // Click on ‘Sale’ Menu tab
        driver.findElement(By.id("ui-id-8")).click();
        // Click on ‘Jackets’ link on left side under WOMEN’S DEAL Category
        driver.findElement(By.linkText("Jackets")).click();
        // Verify the text ‘Jackets’ is displayed
        String expectedDisplayText = "Jackets";
        String actualDisplayText = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']")).getText();
        Assert.assertEquals(expectedDisplayText, actualDisplayText);
        List<WebElement> totalItemDisplayed = driver.findElements(By.xpath("//a[@class = 'product-item-link']"));
        System.out.println("Total numbers of products = " + totalItemDisplayed.size());
        for (WebElement item : totalItemDisplayed) {
           // System.out.println(item.getAttribute("href")); // name as print names
            System.out.println(item.getText());
            // Verify total 12 Items displayed on page.
            int productCount = driver.findElements(By.className("product-item-link")).size();
            Assert.assertEquals(productCount, 12);
        }

    }

    // Individual open and close
    @After
    public void tearDown() {
        closeBrowser();
    }
}
