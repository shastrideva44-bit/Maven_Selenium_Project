package com.comcast.crm.objectrepositoryutility;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class CreatingNewContactPage {
	
		WebDriver driver;
		public CreatingNewContactPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);	
		}
		
		@FindBy( name="lastname")
		private WebElement lastNameEdt;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement saveinfoBtn;
		
		@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
		private WebElement OrgNamePlus;
		
		public WebElement getOrgNamePlus() {
			return OrgNamePlus;
		}

		public WebElement getLastName() {
			return lastNameEdt;
		}

		public WebElement getSaveinfoBtn() {
			return saveinfoBtn;
		}
		
		public void enterLastName(String lastname) {
		    lastNameEdt.sendKeys(lastname);
		}

		public void clickOrgLookup() {
		    OrgNamePlus.click();
		}

		public WebElement getLastNameEdt() {
			return lastNameEdt;
		}

		public WebElement getEndDateEdt() {
			return endDateEdt;
		}

		public void clickSave() {
		    saveinfoBtn.click();
		}
		
		@FindBy(name="support_start_date")
		private WebElement startDateEdt;

		@FindBy(name="support_end_date")
		private WebElement endDateEdt;
		
		public void createContact(String lastName) {
	        enterLastName(lastName);
	        clickSave();
	    }

		public void createContactWithSupportDate(String lastName, String startDate, String endDate) {

		    lastNameEdt.sendKeys(lastName);

		    startDateEdt.clear();
		    startDateEdt.sendKeys(startDate);

		    endDateEdt.clear();
		    endDateEdt.sendKeys(endDate);

		    saveinfoBtn.click();
		}

		public void createContactWithOrg(String contactLastName, String orgName) {
			// TODO Auto-generated method stub
			
		}		
		
			
		
	}
	