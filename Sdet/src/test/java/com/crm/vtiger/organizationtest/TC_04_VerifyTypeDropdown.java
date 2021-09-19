package com.crm.vtiger.organizationtest;

import org.testng.annotations.Test;

import com.crm.vtiger.elementrepository.CreateOrganizationPage;
import com.crm.vtiger.elementrepository.HomePage;
import com.crm.vtiger.genericutils.SuperClass;

public class TC_04_VerifyTypeDropdown extends SuperClass {
	@Test(groups="SmokeSuite")
	public void verifyTypeDropdownTest() throws Throwable {
		// get the organization name from external resources
		String ORGANIZATIONNAME = eu.getDataFromExcel("Sheet1", 1, 2);
		
		// create organization
		HomePage hp = new HomePage(driver);
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		hp.clickOnOrganization();
		cop.clickOrganizationButton();
		String orgName = ORGANIZATIONNAME + ju.getRanDomNumber();
		System.out.println(cop.createOrganizationAndVerifyType(orgName));
	}
}
