package com.actitime.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.qa.base.Testbase;
import com.actitime.qa.testcases.CustomerAndProjectPageTest;

public class HomePage extends Testbase{
	
	CustomerAndProjectPageTest customer = new CustomerAndProjectPageTest();
	//public String custName;
	
	@FindBy(xpath="//td[contains(text(),'Enter Time-Track')]")
	@CacheLookup
	WebElement timetracklabel;
	
	@FindBy(xpath= "//div[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath= "//div[contains(text(),'Reports')]")
	WebElement reportsLink;
	
	@FindBy(xpath= "//div[contains(text(),'Users')]")
	WebElement usersLink;
	
	@FindBy(xpath= "//a[contains(text(),'Projects & Customers')]")
	WebElement projectandcustomerLink;
	
	@FindBy(xpath= "//div[@id='ext-gen13']")
	WebElement createCustomerBtn;
	
	@FindBy(xpath= "//div[@id='ext-comp-1004']/span")
	WebElement createprojectbtn;
	
	
	//Initialize the Page Object
	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String verifypageText(){
		return timetracklabel.getText();
	}
	
	public void addNoteforTasks(){
		//driver.findElement(By.xpath(xpathExpression))
		
	}
	
	public OpenTasksPage clickOnTasksLink(){
		tasksLink.click();
		return new OpenTasksPage();
	}
	
	public SavedReportsPage clickOnReportsLink(){
		reportsLink.click();
		return new SavedReportsPage();
	}
	
	public UsersListPage clickOnUsersLink(){
		usersLink.click();
		return new UsersListPage();
	}
	
	public void createNewCustomer(){
		projectandcustomerLink.click();
		createCustomerBtn.click();
		driver.findElement(By.xpath("//input[@id='customerLightBox_nameField']")).sendKeys(customer.ReturnName());
		driver.findElement(By.xpath("//div[@id='customerLightBox_commitBtn']/div/span")).click();
		
	}
	
	public void clickOnNewProject(){
		projectandcustomerLink.click();
		createprojectbtn.click();
	}
	
	
}
