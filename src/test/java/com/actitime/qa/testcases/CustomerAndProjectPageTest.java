package com.actitime.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.actitime.qa.base.Testbase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.ProjectsAndCustomersPage;
import com.actitime.qa.util.TestUtil;

public class CustomerAndProjectPageTest extends Testbase {
	
	LoginPage loginpage;
	HomePage homepage;
	ProjectsAndCustomersPage prcupage;// = new ProjectsAndCustomersPage();
	
	
	public CustomerAndProjectPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyCustomerAdd(){
		homepage.clickOnTasksLink();
		homepage.createNewCustomer();
		
		System.out.println(prcupage.verifyAddedCustomersByName());
		//prcupage.verifyAddedCustomersByName();
		
	}
	public String ReturnName()
	{
	String name = "Saila";
	return name;
	}
	
	@DataProvider
	public Object[][] getActiTimeTestData(){
		
		Object data[][] = TestUtil.getTestData("Data");
		return data;	
		
	}
	
	/*@Test(dataProvider="getActiTimeTestData")
	public void addNewProject(String projectName){
		homepage.clickOnTasksLink();
		homepage.clickOnNewProject();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//prcupage.createNewProject("Assurant");
		prcupage.createNewProject(projectName);
		
	}*/
	
	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}

}
