package com.actitime.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.Testbase;
import com.actitime.qa.testcases.CustomerAndProjectPageTest;

public class ProjectsAndCustomersPage extends Testbase {
	
	HomePage homepage = new HomePage();
	CustomerAndProjectPageTest obj = new CustomerAndProjectPageTest();
	
	@FindBy(xpath= "//div[@id='projectPopup_sectionDetails']/div/input")
	@CacheLookup
	WebElement projectName;
	
	@FindBy(xpath="//div[@id='projectPopup_commitBtn']/div/span")
	WebElement createProjectBtn;
	
	
	public ProjectsAndCustomersPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyAddedCustomersByName(){
		
		String abc = driver.findElement(By.xpath("//a[contains(text(),'"+obj.ReturnName()+"')]")).getText();
		return abc;
	}
	
	public void createNewProject(String pName){
		
		projectName.sendKeys(pName);
		createProjectBtn.click();
		
	}
	
	

}
