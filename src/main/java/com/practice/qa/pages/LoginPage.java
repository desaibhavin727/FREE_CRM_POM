package com.practice.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR:
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;

		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;
		
		@FindBy(linkText="Sign Up")
		WebElement signUpBtn;
		
		@FindBy(xpath="(//img[@class='img-responsive'])")
		WebElement crmLogo;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd){
			username.sendKeys(un);
			password.sendKeys(pwd);
			loginBtn.click();
			//    	JavascriptExecutor js = (JavascriptExecutor)driver;
			  //  	js.executeScript("arguments[0].click();", loginBtn);
			    	
			return new HomePage();
		}
		
	}
	