package com.practice.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.practice.qa.base.TestBase;

public class ContactsPage extends TestBase{
	

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement ContactsLable;
	
	@FindBy(id="first_name")
	WebElement FirstName;
	
	@FindBy(id="surname")
	WebElement LastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement SaveButton;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLable() {
		return ContactsLable.isDisplayed();
	}

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+"//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();;
	}
	
	
	public void createNewContact(String title, String firstname, String Lname, String Comp) {
		
		Select S = new Select(driver.findElement(By.name("title")));
		S.selectByVisibleText(title);
	
		FirstName.sendKeys(firstname);
		LastName.sendKeys(Lname);
		company.sendKeys(Comp);
		SaveButton.click();
	}
	
	
	
	
	
	
	
	
	
	
}
	