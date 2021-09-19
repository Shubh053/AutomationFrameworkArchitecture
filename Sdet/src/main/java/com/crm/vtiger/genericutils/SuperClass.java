package com.crm.vtiger.genericutils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.vtiger.elementrepository.HomePage;
import com.crm.vtiger.elementrepository.LoginPage;
import com.google.common.io.Files;
/**
 *  this class contains all the basic configuration annotations
 * @author shubh
 *
 */
public class SuperClass  {
	public  WebDriver driver;
	public static WebDriver staticdriver;
	public CommonUtility wdu = new CommonUtility();
	public FileUtility file = new FileUtility();
	public JavaUtility ju = new JavaUtility();
	public ExcelUtility eu = new ExcelUtility();
	
	@BeforeSuite(groups = {"SmokeSuite" , "RegressionSuite"})
	public void openDatabase()
	{
		System.out.println("Database connection eastablished");
	}
	
	//@Parameters("Browser")
	@BeforeClass(groups = {"SmokeSuite" , "RegressionSuite"})
	public void launchBrowser() throws Throwable {
		String BROWSER = file.getDataFromJson("browser");
		String URl =file.getDataFromJson("url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("opera")) {
		driver = new OperaDriver();
		} else {
			System.out.println("Invalid browser");
		}
		wdu.maximizeWindow(driver);
		wdu.waitUntilPageLoad(driver);
		driver.get(URl);
		staticdriver = driver;
	}
	
	@BeforeMethod(groups = {"SmokeSuite" , "RegressionSuite"})
	public void login() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		String USERNAME = file.getDataFromJson("username");
		String PASSWORD = file.getDataFromJson("password");
		lp.login(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups = {"SmokeSuite" , "RegressionSuite"})
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
	}
	
	@AfterClass(groups = {"SmokeSuite" , "RegressionSuite"})
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite(groups = {"SmokeSuite" , "RegressionSuite"})
	public void closeDatabase()
	{
		System.out.println("Database connection closed");
	}
	
	public String getscreenshot(String name) throws Throwable
	{
		System.out.println("screenshot procesdure start");
		File srcfile = ((TakesScreenshot)  staticdriver).getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir")+"/screenshots/"+name+".png";
		File finaldest = new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		return destfile;
	}
}
