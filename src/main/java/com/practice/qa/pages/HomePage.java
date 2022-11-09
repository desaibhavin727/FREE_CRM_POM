package com.practice.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.practice.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Bhavin Desai')]")
	WebElement username;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement ContactsLinks;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactsLink;

	@FindBy(xpath="(//span[@class='item-text'])[5]")
	WebElement DealsLinks;
	
	@FindBy(xpath="(//span[@class='item-text'])[6]")
	WebElement TaskLinks;
	
	//ini the page objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	
	public boolean VerifyCorrectUserName() {
		return username.isDisplayed();
	}
	
	public ContactsPage ClickonContactsLink() {
		
		ContactsLinks.click();
		return new ContactsPage();
	}
	
	public DealPage ClickonDealsLink() {
		DealsLinks.click();
		return new DealPage();
	}

	public TaskPage ClickonTaskLink() {
		TaskLinks.click();
		return new TaskPage();
	}

	public void clickOnNewContactLink() {
		
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLinks).build().perform();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		//wait.until(ExpectedConditions.visibilityOf(newContactsLink)).click();
	
		newContactsLink.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}