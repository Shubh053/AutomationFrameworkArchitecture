package com.crm.vtiger.organizationtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.elementrepository.CreateOrganizationPage;
import com.crm.vtiger.elementrepository.HomePage;
import com.crm.vtiger.elementrepository.OrganizationInfoPage;
import com.crm.vtiger.genericutils.SuperClass;
import com.crm.vtiger.genericutils.CommonUtility;

public class TC_03_CreateOrganizationWithIndustry extends SuperClass{
	CommonUtility wdu = new CommonUtility();
	@Test(groups="RegressionSuite", retryAnalyzer = com.crm.vtiger.genericutils.RetryAnalyzer.class)
	public void createOrganizationWithIndustryTest() throws Throwable
	{
				// get the organization name and industry from external resources
				String ORGANIZATIONNAME = eu.getDataFromExcel("Sheet1", 1, 2);
				String INDUSTRY = eu.getDataFromExcel("Sheet1", 2, 2);
				
				// create organization
				HomePage hp = new HomePage(driver);
				CreateOrganizationPage cop = new CreateOrganizationPage(driver);
				hp.clickOnOrganization();
				cop.clickOrganizationButton();
				String orgName = ORGANIZATIONNAME + ju.getRanDomNumber();
				cop.createOrganizationWithIndustry(orgName, INDUSTRY);
				
				// get created organization name and industry
				WebElement editButton = driver.findElement(By.name("Edit"));
				wdu.waitForElementVisibility(driver, editButton);
				
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String actualOrgName = oip.getOrganizationInformation();
				String actualIndName = oip.getIndustryInformation();
				
				// verify organization name and industry
				Assert.assertTrue(actualOrgName.contains(orgName));
				Assert.assertTrue(actualIndName.contains(INDUSTRY));
	}
}
