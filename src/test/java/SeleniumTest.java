import Setup.WebDriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Setup.WebDriverSetup.takeScreenshot;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeTest
    void Setup() {
        String url = "https://anupdamoda.github.io/AceOnlineShoePortal/index.html";
        driver = WebDriverSetup.initializeDriver(url);
        takeScreenshot(driver, "screenshot.png");
    }

    @AfterTest
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void teststeps() {
        driver.findElement(By.xpath("//*[@id='menuToggle']/input")).click();
        WebElement menuElement = driver.findElement(By.id("menu"));
        Assert.assertTrue(menuElement.isDisplayed(), "Menu is not visible!");
        takeScreenshot(driver, "screenshot1.png");
    }

    @Test
    void teststeps1() {
        driver.findElement(By.xpath("//*[@id='menuToggle']/input")).click();
        WebElement menuElement = driver.findElement(By.id("menu"));
        //Test will fail
        Assert.assertFalse(menuElement.isDisplayed(), "Menu is not visible!");
        takeScreenshot(driver, "screenshot1.png");
    }
}
