package com.crm.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericutils.SuperClass;
import com.crm.vtiger.genericutils.CommonUtility;

public class HomePage extends CommonUtility{
	
	// constructor to initilise element at the time of object creation
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// private locators
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutButton;
	
	@FindBy(linkText="Leads")
	private WebElement leadLnk;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement productLnk;
	
	@FindBy(linkText="Email")
	private WebElement emailLnk;

	// getters for locators
	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutButton() {
		return signoutButton;
	}

	public WebElement getLeadLnk() {
		return leadLnk;
	}

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactLnk() {
		return contactLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}
	
	// business logic
	public void signOut(WebDriver driver)
	{
		waitForElementVisibility(driver, administratorImg);
		mouseOver(driver, administratorImg);
		signoutButton.click();
	}
	
	public void clickOnLeads()
	{
		leadLnk.click();
	}
	
	public void clickOnOrganization()
	{
		organizationLnk.click();
	}
	
	public void clickOnContact()
	{
		contactLnk.click();
	}
	
	public void clickOnOpportunities()
	{
		opportunitiesLnk.click();
	}
	
	public void clickOnProduct()
	{
		productLnk.click();
	}
	
	public void clickOnEmail()
	{
		emailLnk.click();
	}
}
