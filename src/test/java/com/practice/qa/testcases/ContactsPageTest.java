package com.practice.qa.testcases;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.practice.qa.base.TestBase;
import com.practice.qa.pages.ContactsPage;
import com.practice.qa.pages.HomePage;
import com.practice.qa.pages.LoginPage;
import com.practice.qa.utill.TestUtill;

public class ContactsPageTest extends TestBase{

	LoginPage lp = new LoginPage();
	HomePage hp = new HomePage();
	TestUtill tu = new TestUtill();
	ContactsPage cp =new ContactsPage();
	
	String sheetName ="contacts";

	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		tu = new TestUtill();
		lp = new LoginPage();
		cp = new ContactsPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		tu.switchToFrame();
		cp = hp.ClickonContactsLink();
	}
	
	@Test(priority=1)
	public void VerifyContactsPageLable() {
		Assert.assertTrue(cp.verifyContactsLable(),"contacts lable is missing on page");
	}

	@Test(priority=2)
	public void selectContactsTest() {
		cp.selectContactsByName("Nirav patel");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		cp.selectContactsByName("Nirav patel");
		cp.selectContactsByName("Hemali Desai");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException {
		
		Object data[][] = TestUtill.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=4, dataProvider = "getCRMTestData")
	public void VerifyContactAdded(String title, String firstname, String lastname, String company) {
		hp.clickOnNewContactLink();
		//cp.createNewContact("Mr.", "Mansi", "Desai", "Meta");
		cp.createNewContact(title, firstname, lastname, company);
		
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
