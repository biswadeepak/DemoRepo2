package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.Testbase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;

public class LoginPageTest extends Testbase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage = new LoginPage();
	}
	
//	@Test(priority = 1)
//	public void loginPageTitleTest(){
//		String title = loginpage.validateLoginPageTitle();
//		Assert.assertEquals(title, "actiTIME - Login");
//	}
//	
//	/*@Test(priority = 2)
//	public void actiTimelogoTest(){
//		boolean flag = loginpage.validateactiTimeLogo();
//		Assert.assertTrue(flag);
//	}
	
	@Test(priority = 3)
	public void loginTest(){
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	 
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
 