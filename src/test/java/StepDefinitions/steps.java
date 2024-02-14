package StepDefinitions;

import Setup.WebDriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class steps {

    private WebDriver driver;

    @Given("browser is open")
    public void browser_is_open() {
        String url = "https://anupdamoda.github.io/AceOnlineShoePortal/index.html";
        driver = WebDriverSetup.initializeDriver(url);
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id='menuToggle']/input")).click();

        driver.findElement(By.xpath("//ul[@id='menu']//li[.='Sign In Portal']")).click();

    }
    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String username, String password) {
        // Find the username input field and enter the username
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='usr']"));
        usernameInput.sendKeys(username);

        // Find the password input field and enter the password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='pwd']"));
        passwordInput.sendKeys(password);
    }

    @When("user clicks on login")
    public void user_clicks_on_login() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        // Find the element by id
        WebElement smokeTestsElement = driver.findElement(By.id("ShoeType"));
        // Get the text of the element
        String actualText = smokeTestsElement.getText();
        // Expected text
        String expectedText = "Formal Shoes";

        // Assert that the actual text matches the expected text
        boolean equals = actualText.equals(expectedText);
    }


}
