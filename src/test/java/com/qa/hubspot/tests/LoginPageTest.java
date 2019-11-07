package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;

public class LoginPageTest {
    
	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_properties();
		
		String browserName = prop.getProperty("browser");
		driver = basePage.init_driver(browserName);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginPage = new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		Assert.assertEquals(loginPage.getPageTitle(), "HubSpot Login");
	}
	@Test(priority=2)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink());
	}
	@Test(priority=3)
	public void doLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
