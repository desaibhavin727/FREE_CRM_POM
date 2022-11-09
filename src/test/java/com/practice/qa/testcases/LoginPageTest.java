package com.practice.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.qa.pages.LoginPage;
import com.practice.qa.pages.HomePage;
import com.practice.qa.base.TestBase;

public class LoginPageTest extends TestBase {
	
	LoginPage lp = new LoginPage();
	HomePage hp = new HomePage();
	
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		initialization();
		lp = new LoginPage();	
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = lp.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = lp.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void loginTest(){
		
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}