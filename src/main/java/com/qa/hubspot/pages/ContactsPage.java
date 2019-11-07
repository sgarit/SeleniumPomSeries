package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.Constants;
import com.qa.hubspot.util.ElementUtil;

public class ContactsPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	By CreateContact = By.xpath("//span[text()='Create contact']");
	By CreateContactButton = By.xpath("//li//div[text()='Create contact']");
	
	By email = By.xpath("input[data-field='email']");
	By FirstName = By.xpath("//input[@data-field='firstname']");
	
	By LastName = By.xpath("//input[@data-field='lastname']");
	//div//label[text()='Job title']
	By JobTitle = By.xpath("//input[@data-field='jobtitle']");
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);	
	}
	public String getContactsPageTitle() {
		return elementUtil.waitForTitlePresent(Constants.Contacts_PAGE_TITLE, 15);
	}
	public void createNewContact(String mail,String FN,String LN,String JT) {
		elementUtil.doClick(CreateContact);
		elementUtil.doSendKeys(email, mail);
		elementUtil.doSendKeys(FirstName, FN);
		elementUtil.doSendKeys(LastName, LN);
		elementUtil.doSendKeys(JobTitle, JT);
		
	}

}
