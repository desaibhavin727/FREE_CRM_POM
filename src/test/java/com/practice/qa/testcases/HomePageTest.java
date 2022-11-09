package com.practice.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.utill.TestUtill;
import com.practice.qa.base.TestBase;
import com.practice.qa.pages.ContactsPage;
import com.practice.qa.pages.HomePage;
import com.practice.qa.pages.LoginPage;
import com.practice.qa.utill.TestUtill;

public class HomePageTest extends TestBase {
	
	LoginPage lp = new LoginPage();
	HomePage hp = new HomePage();
	TestUtill tu = new TestUtill();
	ContactsPage cp =new ContactsPage();

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		tu = new TestUtill();
		lp = new LoginPage();
		cp = new ContactsPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = hp.verifyHomepageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		tu.switchToFrame();
		Assert.assertTrue(hp.VerifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		tu.switchToFrame();
		cp = hp.ClickonContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
