package stepsdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public void setUp() {
		//Setup ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Change the url to project url
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
