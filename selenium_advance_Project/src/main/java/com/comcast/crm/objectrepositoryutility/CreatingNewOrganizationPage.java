package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

    WebDriver driver;

    public CreatingNewOrganizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "accountname")
    private WebElement orgNameEdt;

    @FindBy(name = "ship_street")
    private WebElement shipaddEdt1;

    @FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
    private WebElement savebtn;

    @FindBy(name = "industry")
    private WebElement industryDB;

    // Getter (optional)
    public WebElement getOrgNameEdt() {
        return orgNameEdt;
    }

    public WebElement getShipaddEdt1() {
        return shipaddEdt1;
    }

    public WebElement getSavebtn() {
        return savebtn;
    }

    // ✅ Method 1 (Basic)// HERE this is FIRST METHOD OVERLOADING CONCEPT
    public void createOrg(String orgName, String shipadd) {
        orgNameEdt.sendKeys(orgName);
        shipaddEdt1.sendKeys(shipadd);
        savebtn.click();
    }

    // ✅ Method 2 HERE this is SECOND: METHOD OVERLOADING CONCEPT
    public void createOrg(String orgName, String shipAdd, String industry) {
        orgNameEdt.sendKeys(orgName);
        shipaddEdt1.sendKeys(shipAdd);

        Select sel = new Select(industryDB);
        sel.selectByVisibleText(industry);   // ✔ correct

        savebtn.click();
    }

	public void createOrgWithIndustry(String orgName, String industry, String type) {
		orgNameEdt.sendKeys(orgName);
		 Select sel = new Select(industryDB);
	        sel.selectByVisibleText(industry);   // ✔ correct
	        savebtn.click();
		
	}

	public void createOrgPhoneNumber(String orgName, String phoneNumber) {
		orgNameEdt.sendKeys(orgName);
		
	}
}