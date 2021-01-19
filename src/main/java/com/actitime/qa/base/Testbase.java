package com.actitime.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.actitime.qa.util.TestUtil;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Testbase(){
		try{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\NewWorkSpace\\TPoint\\ActiTimeTest\\src\\main\\java\\com\\"
					+ "actitime\\qa\\config\\config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "//C:\\Users\\bschi\\OneDrive"
					+ "\\Desktop\\Selenium Download\\Chrome\\chromedriver.exe");
		    driver = new ChromeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITE_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}
