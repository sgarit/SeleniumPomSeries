package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;

public class HomePageTest {
    BasePage basePage;
    Properties prop;
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    
    @BeforeTest
    public void setUp() {
    	basePage = new BasePage();
    	prop = basePage.init_properties();
    	String browser = prop.getProperty("browser");
    	driver = basePage.init_driver(browser);
    	driver.get(prop.getProperty("url"));
      	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		loginPage = new LoginPage(driver);
    	homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
    @Test
    public void verifyHomePageTitleTest() {
      String title =	homePage.getHomePageTitle();
      System.out.println("Home Page title is" + title);
      Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
    }
    @Test
    public void verifyHomePageHeaderTest() {
    	Assert.assertTrue(homePage.isHeaderPresent(),"Home page header is not present");
    	String header = homePage.getHomePageHeaderValue();
    	System.out.println(header);
    	Assert.assertEquals(header,Constants.HOME_PAGE_HEADER);
    }
    
    @AfterTest
    public void tearDown() {
    	driver.quit();
    }
    
}
