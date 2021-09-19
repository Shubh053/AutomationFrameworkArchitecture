package com.crm.vtiger.elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericutils.CommonUtility;

public class CreateOrganizationPage  extends CommonUtility{
	WebDriver driver;
	
	// constructor to initilise element at the time of object creation
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// private locators
	@FindBy(css="img[title='Create Organization...']")
	private WebElement createOrgBtn;
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;
	
	@FindBy(css="input[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="accounttype")
	private WebElement typeDropdown;

	// getters for locators
	public WebElement getCreateOrgBtn() {
		return createOrgBtn;
	}
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}
	
	// business logic
	/**
	 * this method will redirect you to create organization page
	 */
	public void clickOrganizationButton()
	{
		createOrgBtn.click();
	}
	/**
	 *  this method will create organization with mandatory field
	 * @param orgName
	 */
	public void createOrganization(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	/**
	 *  this method will create organization by choosing a industry type
	 * @param orgName
	 * @param indType
	 */
	public void createOrganizationWithIndustry(String orgName, String indType)
	{
		orgNameEdt.sendKeys(orgName);
		select(industryDropdown, indType);
		saveBtn.click();
	}
	
	/**
	 * this method will create organization by choosing a type
	 * @param orgName
	 * @param typeInfo
	 */
	public void createOrganizationWithType(String orgName, String typeInfo)
	{
		orgNameEdt.sendKeys(orgName);
		select(typeDropdown, typeInfo);
		saveBtn.click();
	}
	
	/**
	 * this method will check industry dropdown is working or not
	 * @param orgName
	 * @return
	 */
	public boolean createOrganizationAndVerifyIndustry(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		industryDropdown.click();
		return industryDropdown.isEnabled();
	}
	
	/**
	 * this method will check type dropdown is working or not
	 * @param orgName
	 * @return
	 */
	public boolean createOrganizationAndVerifyType(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		typeDropdown.click();
		return typeDropdown.isEnabled();
	}
}
