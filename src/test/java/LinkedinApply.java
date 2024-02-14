import Setup.WebDriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import static Setup.WebDriverSetup.takeScreenshot;

public class LinkedinApply {
    private WebDriver driver;

    @AfterTest
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @BeforeTest
    void Setup() throws InterruptedException {
        String url = "https://www.linkedin.com/";
        driver = WebDriverSetup.initializeDriver(url);

        WebElement username = driver.findElement(By.xpath(".//*[@id='session_key']"));
        username.click();
        username.sendKeys("nicolasdiasgomes@gmail.com");

        WebElement password = driver.findElement(By.xpath(".//*[@id='session_password']"));
        password.click();
        password.sendKeys("Olivia@1955");

        driver.findElement(By.xpath(".//button[@type='submit']")).click();

        WebElement element = driver.findElement(By.xpath("//a[@href='https://www.linkedin.com/jobs/?']"));
        element.click();

        WebElement el = driver.findElement(By.xpath("//*[starts-with(@id, 'jobs-search-box-keyword-id-ember')]"));
        el.click();
        el.sendKeys("test engineer");

        el.click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).perform();

        WebElement el1 = driver.findElement(By.xpath("//*[starts-with(@id, 'jobs-search-box-location-id-ember')]"));
        el1.click();
        el1.sendKeys("Antwerp");
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();
    }

    @Test
    void applyLinkedin() throws InterruptedException {

        Thread.sleep(5000);
    }

}
