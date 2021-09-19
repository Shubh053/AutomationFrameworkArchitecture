package com.crm.vtiger.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.genericutils.ExcelUtility;
import com.crm.vtiger.genericutils.FileUtility;
import com.crm.vtiger.genericutils.JavaUtility;
import com.crm.vtiger.genericutils.CommonUtility;

public class TC_06_CreateOrganizationByQuickCreateTest {
	WebDriver driver;
	@Test
	public void createOrganizationFromQuickCreateTest() throws Throwable {
		// get the data from external resources
				FileUtility file = new FileUtility();
				CommonUtility wdu = new CommonUtility();
				JavaUtility ju = new JavaUtility();
				ExcelUtility eu = new ExcelUtility();
				
				String BROWSER = file.getDataFromJson("browser");
				String URl =file.getDataFromJson("url");
				String USERNAME = file.getDataFromJson("username");
				String PASSWORD = file.getDataFromJson("password");
				String ORGANIZATIONNAME = eu.getDataFromExcel("Sheet1", 1, 2);
				
				// select the browser
				if(BROWSER.equalsIgnoreCase("chrome")) {
					driver = new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("firefox")) {
					driver = new FirefoxDriver();
				} else if (BROWSER.equalsIgnoreCase("opera")) {
					driver = new OperaDriver();
				}
				
				// wait for the element to load
				wdu.waitUntilPageLoad(driver);
				
				// maximize the browser
				wdu.maximizeWindow(driver);
				
				// launch browser
				driver.get(URl);
				
				// login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				// open quick create and select organization
				driver.findElement(By.id("qccombo")).click();
				driver.findElement(By.xpath("//option[contains(text(),'Organization')]")).click();
				
				// save organization
				driver.findElement(By.name("accountname")).sendKeys(ORGANIZATIONNAME + ju.getRanDomNumber());
				driver.findElement(By.xpath("//table[@class='qcTransport']//input[@title='Save [Alt+S]']")).click();
				
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
