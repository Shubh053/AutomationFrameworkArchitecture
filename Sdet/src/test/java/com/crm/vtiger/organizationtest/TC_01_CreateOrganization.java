package com.crm.vtiger.organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.elementrepository.CreateOrganizationPage;
import com.crm.vtiger.elementrepository.HomePage;
import com.crm.vtiger.elementrepository.OrganizationInfoPage;
import com.crm.vtiger.genericutils.SuperClass;
import com.crm.vtiger.genericutils.CommonUtility;
//@Listeners(com.crm.vtiger.genericutils.ListenersImplementation.class)
public class TC_01_CreateOrganization extends SuperClass {
	CommonUtility wdu = new CommonUtility();
	@Test(groups="SmokeSuite" , retryAnalyzer = com.crm.vtiger.genericutils.RetryAnalyzer.class)
	public void createOrganisationTest() throws Throwable {
		// get the organization name from external resources
		String ORGANIZATIONNAME = eu.getDataFromExcel("Sheet1", 1, 2);
		
		// create organization
		HomePage hp = new HomePage(driver);
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		hp.clickOnOrganization();
		cop.clickOrganizationButton();
		String orgName = ORGANIZATIONNAME + ju.getRanDomNumber();
		cop.createOrganization(orgName);
		
		// get created organization name
		WebElement editButton = driver.findElement(By.name("Edit"));
		wdu.waitForElementVisibility(driver, editButton);
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgName = oip.getOrganizationInformation();
		
		// verify organization name
		Assert.assertTrue(actualOrgName.contains(orgName));
		Assert.assertEquals(false, true);
	}
}
