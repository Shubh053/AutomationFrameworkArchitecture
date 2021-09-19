package com.crm.vtiger.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.genericutils.ExcelUtility;
import com.crm.vtiger.genericutils.FileUtility;
import com.crm.vtiger.genericutils.JavaUtility;
import com.crm.vtiger.genericutils.CommonUtility;

public class TC_03_CreateContactWithOrganizationTest {
	WebDriver driver;
	@Test
	public void createContactTest() throws Throwable {
		// get the data from external resources
				FileUtility file = new FileUtility();
				CommonUtility wdu = new CommonUtility();
				JavaUtility ju = new JavaUtility();
				ExcelUtility eu = new ExcelUtility();
				
				String BROWSER = file.getDataFromJson("browser");
				String URl =file.getDataFromJson("url");
				String USERNAME = file.getDataFromJson("username");
				String PASSWORD = file.getDataFromJson("password");
				String CONTACTNAME = eu.getDataFromExcel("Sheet1", 3, 2);
				
				// select the browser
				if(BROWSER.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				} else {
					System.out.println("Invalid Browser");
				}
				
				// wait for the element to load
				wdu.waitUntilPageLoad(driver);
				
				// maximise the browser
				wdu.maximizeWindow(driver);
				
				// launch browser
				driver.get(URl);
				
				// login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				// create contact
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys(CONTACTNAME + ju.getRanDomNumber());
				driver.findElement(By.xpath("//td[text()='Organization Name 			']/following-sibling::td/img")).click();
				wdu.switchToWindow(driver, "Accounts");
				wdu.waitForElementVisibility(driver, driver.findElement(By.name("search_text")));
				List<WebElement> list = driver.findElements(By.xpath("//table[@class='small']/tbody/tr[*]/td[1]/a[@href='javascript:window.close();']"));
			 	list.get(0).click();
			 	wdu.switchToWindow(driver, "Contacts");
			 	//wdu.waitForElementVisibility(driver, driver.findElement(By.xpath("//td[text()=' Contact Information']")));
				driver.findElement(By.xpath("//img[@value='  Save  ']")).click();
				
				// sign out from application
				WebElement editButton = driver.findElement(By.name("Edit"));
				wdu.waitForElementVisibility(driver, editButton);
				WebElement signOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wdu.mouseOver(driver, signOut);
				WebElement clickSignOut = driver.findElement(By.linkText("Sign Out"));
				wdu.mouseOver(driver, clickSignOut);
			
				// close the browser
				wdu.closeBrowser(driver);
	}
}
