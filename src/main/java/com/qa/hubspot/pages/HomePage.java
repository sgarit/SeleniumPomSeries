package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.ElementUtil;

public class HomePage extends BasePage{
    
	WebDriver driver;
	ElementUtil elementUtil;
	
	// locators 
	By header = By.className("private-page__title");
	By contactsLink = By.id("nav-primary-contacts-branch");
	By childContactsLink = By.id("nav-secondary-contacts");
	
	//constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//page actions
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	public boolean isHeaderPresent() {
		return driver.findElement(header).isDisplayed();
	}
	public String getHomePageHeaderValue() {
		return driver.findElement(header).getText();
	}
	public void ClickOnContacts() {
		elementUtil.doClick(contactsLink);
		elementUtil.doClick(childContactsLink);
	}
	public ContactsPage goToContactsPage() {
		ClickOnContacts();
		return new ContactsPage(driver);
	}

	
}
