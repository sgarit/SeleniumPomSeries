package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//1 Page Objects or By locators
	
	By emailId = By.id("username");
	By password = By.id("password");
	By loginButton  = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
    
	//2 Constructor of Page Class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//3page actions/page methods
	
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println("Login Page title is" + title);
		return title;
	}
	public boolean verifySignUpLink() {
		return driver.findElement(signUpLink).isDisplayed();
	}
	public HomePage doLogin(String username,String pwd) {
		/*driver.findElement(emailId).sendKeys(username);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginButton).click();*/
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new HomePage(driver);
		
	}
}
