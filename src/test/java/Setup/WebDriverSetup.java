package Setup;

import io.cucumber.java.After;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebDriverSetup {

    public static @NotNull WebDriver initializeDriver(String url) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Set implicit wait to 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get(url);
        return driver;
    }

    public static void takeScreenshot(WebDriver driver, String fileName) {
        // Convert WebDriver instance to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture screenshot as a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Specify the destination to save the screenshot
        File destFile = new File("src/test/resources/screenshots/" + fileName);

        try {
            // Copy the captured screenshot to the specified destination
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error while saving screenshot: " + e.getMessage());
        }
    }
}
