package com.simplilearn.cucumberdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(name = "username")
	public WebElement login_useraname;
	
	@FindBy(name = "password")
	public WebElement login_password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement login_button;
	
	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	public WebElement dashboard_label;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void enterUsername(String username) {
		WebElement elm = driver.findElement((By) login_useraname);
		elm.clear();
		elm.sendKeys(username);		
	}
	
	public void enterPassword(String password) {
		WebElement elm = driver.findElement((By) login_password);
		elm.clear();
		elm.sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement((By) login_button).click();
	}
	
	public boolean isDashboardVisible() {
		try {
			return driver.findElement((By) dashboard_label).isDisplayed();
		} catch (Exception e) {
			return false;
		}		
	}
}
