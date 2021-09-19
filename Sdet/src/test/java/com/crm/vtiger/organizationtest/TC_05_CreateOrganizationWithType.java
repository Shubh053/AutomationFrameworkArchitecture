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

public class TC_05_CreateOrganizationWithType extends SuperClass{
	CommonUtility wdu = new CommonUtility();
	@Test(groups="RegressionSuite")
	public void createOrganizationWithTypeTest() throws Throwable
	{
		// get the organization name and type from external resources
		String ORGANIZATIONNAME = eu.getDataFromExcel("Sheet1", 1, 2);
		String TYPE = eu.getDataFromExcel("Sheet1", 5, 2);
		
		// create organization
		HomePage hp = new HomePage(driver);
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		hp.clickOnOrganization();
		cop.clickOrganizationButton();
		String orgName = ORGANIZATIONNAME + ju.getRanDomNumber();
		cop.createOrganizationWithType(orgName, TYPE);
		
		// get created organization name and industry
		WebElement editButton = driver.findElement(By.name("Edit"));
		wdu.waitForElementVisibility(driver, editButton);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgName = oip.getOrganizationInformation();
		String actualType = oip.getTypeInformation();
		
		// verify organization name and verify
		Assert.assertTrue(actualOrgName.contains(orgName));
		Assert.assertTrue(actualType.contains(TYPE));
	}
}
