package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Products")
	private WebElement ProductLink;

	public WebElement getProductLink() {
		return ProductLink;
	}

	@FindBy(name = "Campaigns")
	private WebElement campaignlnk;

	@FindBy(linkText = "Contacts")
	private WebElement contactlnk;

	@FindBy(linkText = "More")
	private WebElement morelnk;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
    private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
    private WebElement signOutLnk;

	public WebElement getOrgLink() {
		return getOrgLink();
	}
	
	public WebElement getContactlnk() {
		return contactlnk;
	}

	public void navigateToCampaginPage() {
		Actions act = new Actions(driver);
		act.moveToElement(morelnk).perform();
		campaignlnk.click();
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
    }
	public WebElement getAdminImg() {
		return adminImg;
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutLnk.click();
	}
}
