package com.actitime.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.Testbase;

public class LoginPage extends Testbase{
	
	//Object Repository => OR
	
	@FindBy(id= "username1")
	WebElement username;
	
	@FindBy(name = "pwd1")
	WebElement password;
	
	@FindBy(xpath = "//div[text()='Login ']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//td[@id='logoContainer']/div/img")
	WebElement atiTimeLogo;
	
	//Initializing Object
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	
	public String validateLoginPageTitle(){
		
		return driver.getTitle();
	}
	
	public boolean validateactiTimeLogo(){
		return atiTimeLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		loginBtn.click();
		return new HomePage();
		
	}

}
