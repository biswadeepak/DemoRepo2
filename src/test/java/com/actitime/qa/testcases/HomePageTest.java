package com.actitime.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.actitime.qa.base.Testbase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;

public class HomePageTest extends Testbase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority=1)
	public void verifytextTest(){
		
		String homepagetxt = homepage.verifypageText();
		Assert.assertEquals(homepagetxt, "Enter Time-Track","Text not matched");
		
	}
	
	
	@AfterMethod
	public void tearDown(){
	//	driver.quit();
	}

}
