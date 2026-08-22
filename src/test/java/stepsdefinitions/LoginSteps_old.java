package stepsdefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

public class LoginSteps_old {
    WebDriver driver;

    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
    		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); 
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");        
        driver.wait(5000);
        
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {    		
    		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
    		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    		driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("user should see the homepage")
    public void user_should_see_homepage() {
        Assert.assertTrue(driver.findElement(By.tagName("h6")).getText().contains("Dashboard"));
        driver.quit();
    }
}
