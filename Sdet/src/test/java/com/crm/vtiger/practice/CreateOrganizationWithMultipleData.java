package com.crm.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.vtiger.elementrepository.CreateOrganizationPage;
import com.crm.vtiger.elementrepository.HomePage;
import com.crm.vtiger.elementrepository.OrganizationInfoPage;
import com.crm.vtiger.genericutils.SuperClass;

public class CreateOrganizationWithMultipleData extends SuperClass{
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		return eu.getExcelData("Sheet2");
	}
	
	@Test(dataProvider = "getData")
	public void createOrganizationWithMultipleData(String OrgName, String IndType)
	{
		// navigate to organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganization();
		
		// click on create organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.clickOrganizationButton();
		
		// create organization
		cop.createOrganizationWithIndustry(OrgName, IndType);
		
		// get created organization name and industry
		WebElement editButton = driver.findElement(By.name("Edit"));
		wdu.waitForElementVisibility(driver, editButton);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actualOrgName = oip.getOrganizationInformation();
		String actualIndName = oip.getIndustryInformation();
		
		// verify organization name and industry
		Assert.assertTrue(actualOrgName.contains(OrgName));
		Assert.assertTrue(actualIndName.contains(IndType));
		
	}
}
