package com.crm.vtiger.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import com.crm.vtiger.genericutils.JSONFileUtility;

public class SelectCheckboxes {
	static WebDriver driver;
	public static void main(String[] args) throws Throwable {
		// read data from json file
		JSONFileUtility jsonLib = new JSONFileUtility();
		String BROWSER = jsonLib.readDataFromJson("browser");
		String URL = jsonLib.readDataFromJson("url");
		String USERNAME = jsonLib.readDataFromJson("username");
		String PASSWORD = jsonLib.readDataFromJson("password");
		
		// select the browser
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new OperaDriver();
		}
		
		// load the url
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// click on organization
		driver.findElement(By.linkText("Organizations")).click();
		
		// select all checkboxes
		//List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]//input[@name='selected_id']"));
//			for(WebElement wb : list) {
//				wb.click();
//			}
			// select last checkbox
			//list.get(list.size()-1).click();
		
		// select 5th row
		//list.get(5).click();
		
		// get the organization name
//		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
//		for(WebElement wb: list) {
//			System.out.println(wb.getText());
//		}
		
		// delete a organization
		
		
		// close the browser
		driver.close();
	}
}
