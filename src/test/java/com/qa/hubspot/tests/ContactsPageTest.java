package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPageTest {
	WebDriver driver;
    BasePage basePage;
    Properties prop;
    LoginPage loginPage;
    HomePage homePage;
    ElementUtil elementUtil;
    ContactsPage contactsPage;
    
    @BeforeMethod
    public void setUp() {
    	basePage = new BasePage();
    	prop = basePage.init_properties();
    	String browserName = prop.getProperty("browser");
    	driver = basePage.init_driver(browserName);
    	driver.get(prop.getProperty("url"));
    	loginPage = new LoginPage(driver);
    	homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    	contactsPage = homePage.goToContactsPage();
    	
    }
    @Test(priority=1)
    public void verifyContactsPageTitle() {
    	String title = contactsPage.getContactsPageTitle();
    	System.out.println(title);
    	Assert.assertEquals(title, Constants.Contacts_PAGE_TITLE);
    }
    @Test(priority=2)
    public void createContactPageTest() {
    	contactsPage.createNewContact("rn.mailto@gmail.com", "ragini", "N", "qa");
    }
    
    @AfterMethod
    public void tearDown() {
    	driver.quit();
    }
}
