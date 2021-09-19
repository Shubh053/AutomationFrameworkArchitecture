package com.crm.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	
	// constructor to initilise element at the time of object creation
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// private locators
	@FindBy(id="dtlview_Organization Name")
	private WebElement organizationInfo;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryInfo;
	
	@FindBy(id="dtlview_Type")
	private WebElement organizationTypeInfo;

	// getters for locators
	public WebElement getOrganizationInfo() {
		return organizationInfo;
	}

	public WebElement getIndustryInfo() {
		return industryInfo;
	}

	public WebElement getOrganizationTypeInfo() {
		return organizationTypeInfo;
	}
	
	// business logic
	/**
	 * this method will give organization name
	 * @return
	 */
	public String getOrganizationInformation()
	{
		return organizationInfo.getText();
	}
	
	/**
	 * this method will give organization industry
	 * @return
	 */
	public String getIndustryInformation()
	{
		return industryInfo.getText();
	}
	
	/**
	 * this method will give organization type
	 * @return
	 */
	public String getTypeInformation()
	{
		return organizationTypeInfo.getText();
	}
}
